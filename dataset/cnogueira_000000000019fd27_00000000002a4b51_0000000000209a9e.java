import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner STD_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private final int bits;
    private final boolean[] solution;

    enum Change {
        NONE, COMP, REV, COMP_REV
    }

    private class LeadGroup {

        // [1, 2, 3, 4, 5, B-4, B-3, B-2, B-1, B]
        private boolean[] current = new boolean[10];
        private boolean[] comp = new boolean[10];
        private boolean[] rev = new boolean[10];
        private boolean[] compRev = new boolean[10];
        private Map<Change, boolean[]> changeMap = new HashMap<>();
        private boolean isLead;
        private int groupNum;

        // true if this group has able to spot fluctuations
        void init(int groupNum) {
            this.groupNum = groupNum;
            changeMap.put(Change.NONE, current);
            changeMap.put(Change.REV, rev);
            changeMap.put(Change.COMP, comp);
            changeMap.put(Change.COMP_REV, compRev);

            final int groupFirstPosition = groupFirstPosition();
            for (int i = 0; i < 5; i++) {
                // ask for bit at position 'i'
                final boolean first = readBitAt(groupFirstPosition + i);
                current[i] = first;
                solution[i + groupFirstPosition - 1] = first;
                rev[9 - i] = first;

                // ask for bit at position '(b-i)+1'
                final boolean second = readBitAt(bits - groupFirstPosition - i + 1);
                current[9 - i] = second;
                solution[bits - groupFirstPosition - i] = second;
                rev[i] = second;
            }

            comp = complement(current, false);
            compRev = complement(rev, false);

            isLead = !Arrays.equals(current, comp) && !Arrays.equals(current, rev) && !Arrays.equals(current, compRev);
        }

        Change syncWithFluctuation() {
            final Change change = identifyChange();

            boolean[] aux;

            switch (change) {
                case REV:
                    aux = current;
                    current = rev;
                    rev = aux;

                    aux = comp;
                    comp = compRev;
                    compRev = aux;
                    break;
                case COMP:
                    aux = current;
                    current = comp;
                    comp = aux;

                    aux = rev;
                    rev = compRev;
                    compRev = aux;
                    break;
                case COMP_REV:
                    aux = current;
                    current = compRev;
                    compRev = aux;

                    aux = rev;
                    rev = comp;
                    comp = aux;
                    break;
            }

            return change;
        }

        private Change identifyChange() {
            // identify Change
            List<Change> candidates = new ArrayList<>(2);
            final int groupFirstPosition = groupFirstPosition();
            final boolean position1Value = readBitAt(groupFirstPosition);
            if (current[0] == position1Value) {
                candidates.add(Change.NONE);
            }
            if (rev[0] == position1Value) {
                candidates.add(Change.REV);
            }
            if (comp[0] == position1Value) {
                candidates.add(Change.COMP);
            }
            if (compRev[0] == position1Value) {
                candidates.add(Change.COMP_REV);
            }

            // at this point we have 2 candidates
            final int discriminatingPosition = findDiscriminatingPosition(candidates);
            final boolean discriminatingPositionValue = readBitAt(
                discriminatingPosition < 5
                    ? discriminatingPosition
                    : bits - (9 - discriminatingPosition) - groupFirstPosition + 1);
            if (current[discriminatingPosition] != discriminatingPositionValue) {
                candidates.remove(Change.NONE);
            }
            if (rev[discriminatingPosition] != discriminatingPositionValue) {
                candidates.remove(Change.REV);
            }
            if (comp[discriminatingPosition] != discriminatingPositionValue) {
                candidates.remove(Change.COMP);
            }
            if (compRev[discriminatingPosition] != discriminatingPositionValue) {
                candidates.remove(Change.COMP_REV);
            }

            // at this point we only have 1 candidate
            return candidates.get(0);
        }

        private int findDiscriminatingPosition(List<Change> candidates) {
            final boolean[] fstList = changeMap.get(candidates.get(0));
            final boolean[] secList = changeMap.get(candidates.get(1));

            for (int i = 1; i < fstList.length; i++) {
                if (fstList[i] != secList[i]) {
                    return i;
                }
            }

            return 2;
        }

        // for non lead groups. Syncs the current group solution space
        public void syncSolution() {
            if (isLead) {
                return; // nothing to do, as solution should already be synchronized
            }

            final boolean valueAtFirstPos = readBitAt(groupFirstPosition());

            if (current[0] == valueAtFirstPos) {
                flushToSolution(current);
            } else if (rev[0] == valueAtFirstPos) {
                flushToSolution(rev);
            } else if (compRev[0] == valueAtFirstPos) {
                flushToSolution(compRev);
            } else if (comp[0] == valueAtFirstPos) {
                flushToSolution(comp);
            }
        }

        private int groupFirstPosition() {
            return (groupNum - 1) * 5 + 1;
        }

        private void flushToSolution(boolean[] list) {
            final int firstPosition = groupFirstPosition() - 1;
            for (int i = 0; i < 5; i++) {
                solution[firstPosition + i] = list[i];
                solution[bits - firstPosition - i - 1] = list[9 - i];
            }
        }
    }

    private static boolean readBitAt(int position) {
        System.out.println(position);
        return STD_IN.nextInt() == 1;
    }

    public Solution(int bits) {
        this.bits = bits;
        solution = new boolean[bits];
    }

    public static void main(String[] args) {

        int tests = STD_IN.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        int bits = STD_IN.nextInt();

        for (int testNum = 1; testNum <= tests; ++testNum) {
            Solution solution = new Solution(bits);

            solution.guess();
        }
    }


    private void guess() {
        ArrayDeque<LeadGroup> groups = new ArrayDeque<>();
        do {
            final LeadGroup leadGroup = new LeadGroup();
            leadGroup.init(groups.size() + 1); // this fills first 10 - next query will be a fluctuation!
            groups.push(leadGroup);
        } while (!groups.peek().isLead && groups.size() * 10 < bits);

        for (int current = groups.size() * 5; current < bits - current; current += 4) {
            final Change change = groups.peek().syncWithFluctuation();

            switch (change) {
                case COMP_REV:
                    complement(solution, true);
                case REV:
                    reverse(solution);
                    break;

                case COMP:
                    complement(solution, true);
                    break;
            }

            for (int i = 0; i < 4; i++) {
                solution[current + i] = readBitAt(current + i + 1);
                solution[bits - current - i - 1] = readBitAt(bits - current - i);
            }
        }

        groups.forEach(group -> group.syncSolution());

        submitFinalGuess();
    }

    private void reverse(boolean[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean temp = solution[i];
            solution[i] = solution[solution.length - i - 1];
            solution[solution.length - i - 1] = temp;
        }
    }

    private void submitFinalGuess() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < bits; i++) {
            result.append(solution[i] ? "1" : "0");
        }

        System.out.println(result.toString());
        final String outcome = Character.toString(STD_IN.next().charAt(0));

        if (!outcome.equals("Y")) {
            throw new IllegalStateException("Judge didnt answer with a Y");
        }
    }

    private static boolean[] complement(boolean[] list, boolean inPlace) {
        final boolean[] result = inPlace ? list : new boolean[list.length];

        for (int i = 0; i < list.length; i++) {
            result[i] = !list[i];
        }

        return result;
    }
}
