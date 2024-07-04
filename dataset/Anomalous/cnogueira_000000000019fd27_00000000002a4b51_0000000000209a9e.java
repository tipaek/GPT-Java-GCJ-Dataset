import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final Scanner STD_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private final int bits;
    private final boolean[] solution;

    enum Change {
        NONE, COMP, REV, COMP_REV
    }

    private class LeadGroup {

        private boolean[] current = new boolean[10];
        private boolean[] comp = new boolean[10];
        private boolean[] rev = new boolean[10];
        private boolean[] compRev = new boolean[10];
        private Map<Change, boolean[]> changeMap = new HashMap<>();
        private boolean isLead;
        private int groupNum;

        void init(int groupNum) {
            this.groupNum = groupNum;
            changeMap.put(Change.NONE, current);
            changeMap.put(Change.REV, rev);
            changeMap.put(Change.COMP, comp);
            changeMap.put(Change.COMP_REV, compRev);

            final int groupFirstPosition = groupFirstPosition();
            for (int i = 0; i < 5; i++) {
                final boolean first = readBitAt(groupFirstPosition + i);
                current[i] = first;
                solution[i + groupFirstPosition - 1] = first;
                rev[9 - i] = first;

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
            List<Change> candidates = new ArrayList<>(Arrays.asList(Change.values()));
            final int groupFirstPosition = groupFirstPosition();
            final boolean position1Value = readBitAt(groupFirstPosition);

            candidates.removeIf(change -> changeMap.get(change)[0] != position1Value);

            final int discriminatingPosition = findDiscriminatingPosition(candidates);
            final boolean discriminatingPositionValue = readBitAt(
                discriminatingPosition < 5
                    ? groupFirstPosition + discriminatingPosition
                    : bits - (9 - discriminatingPosition) - groupFirstPosition + 1);

            candidates.removeIf(change -> changeMap.get(change)[discriminatingPosition] != discriminatingPositionValue);

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

        public void syncSolution() {
            if (isLead) return;

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
        this.solution = new boolean[bits];
    }

    public static void main(String[] args) {
        int tests = STD_IN.nextInt();
        int bits = STD_IN.nextInt();

        for (int testNum = 1; testNum <= tests; ++testNum) {
            Solution solution = new Solution(bits);
            solution.guess();
        }
    }

    private void guess() {
        ArrayDeque<LeadGroup> groups = new ArrayDeque<>();
        do {
            LeadGroup leadGroup = new LeadGroup();
            leadGroup.init(groups.size() + 1);
            groups.push(leadGroup);
        } while (!groups.peek().isLead && groups.size() * 10 < bits);

        for (int current = groups.size() * 5; current < bits - current; current += 4) {
            Change change = groups.peek().syncWithFluctuation();

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

        groups.forEach(LeadGroup::syncSolution);
        submitFinalGuess();
    }

    private void reverse(boolean[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    private void submitFinalGuess() {
        StringBuilder result = new StringBuilder();
        for (boolean bit : solution) {
            result.append(bit ? "1" : "0");
        }

        System.out.println(result.toString());
        if (!STD_IN.next().equals("Y")) {
            throw new IllegalStateException("Judge didn't answer with a Y");
        }
    }

    private static boolean[] complement(boolean[] list, boolean inPlace) {
        boolean[] result = inPlace ? list : new boolean[list.length];
        for (int i = 0; i < list.length; i++) {
            result[i] = !list[i];
        }
        return result;
    }
}