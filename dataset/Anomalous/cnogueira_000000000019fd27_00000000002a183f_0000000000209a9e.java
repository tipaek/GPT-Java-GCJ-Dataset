import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static final Scanner STD_IN = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private final int bits;
    private final List<Boolean> solution;

    enum Change {
        NONE, COMP, REV, COMP_REV
    }

    private class LeadGroup {

        private List<Boolean> current = new ArrayList<>(10);
        private List<Boolean> comp = new ArrayList<>(10);
        private List<Boolean> rev = new ArrayList<>(10);
        private List<Boolean> compRev = new ArrayList<>(10);
        private Map<Change, List<Boolean>> changeMap = new HashMap<>();
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
                final boolean first = readBitAt(groupFirstPosition + i + 1);
                current.add(i, first);
                solution.add(i, first);
                rev.add(9 - i, first);

                final boolean second = readBitAt(bits - groupFirstPosition - i);
                current.add(9 - i, second);
                solution.add(bits - groupFirstPosition - i - 1, second);
                rev.add(i, second);
            }

            comp = complement(current);
            compRev = complement(rev);

            isLead = !current.equals(comp) && !current.equals(rev) && !current.equals(compRev);
        }

        Change syncWithFluctuation() {
            final Change change = identifyChange();
            List<Boolean> aux;

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
            List<Change> candidates = new ArrayList<>(2);
            final int groupFirstPosition = groupFirstPosition();
            final boolean position1Value = readBitAt(groupFirstPosition);
            if (current.get(0) == position1Value) candidates.add(Change.NONE);
            if (rev.get(0) == position1Value) candidates.add(Change.REV);
            if (comp.get(0) == position1Value) candidates.add(Change.COMP);
            if (compRev.get(0) == position1Value) candidates.add(Change.COMP_REV);

            final int discriminatingPosition = findDiscriminatingPosition(candidates);
            final boolean discriminatingPositionValue = readBitAt(
                    discriminatingPosition < 5
                            ? discriminatingPosition
                            : bits - (9 - discriminatingPosition) - groupFirstPosition + 1);
            if (current.get(discriminatingPosition) != discriminatingPositionValue) candidates.remove(Change.NONE);
            if (rev.get(discriminatingPosition) != discriminatingPositionValue) candidates.remove(Change.REV);
            if (comp.get(discriminatingPosition) != discriminatingPositionValue) candidates.remove(Change.COMP);
            if (compRev.get(discriminatingPosition) != discriminatingPositionValue) candidates.remove(Change.COMP_REV);

            return candidates.get(0);
        }

        private int findDiscriminatingPosition(List<Change> candidates) {
            final List<Boolean> fstList = changeMap.get(candidates.get(0));
            final List<Boolean> secList = changeMap.get(candidates.get(1));

            for (int i = 1; i < fstList.size(); i++) {
                if (fstList.get(i) != secList.get(i)) {
                    return i;
                }
            }

            return 2;
        }

        public void syncSolution() {
            if (isLead) return;

            final boolean valueAtFirstPos = readBitAt(groupFirstPosition());

            if (current.get(0) == valueAtFirstPos) {
                flushToSolution(current);
            } else if (rev.get(0) == valueAtFirstPos) {
                flushToSolution(rev);
            } else if (compRev.get(0) == valueAtFirstPos) {
                flushToSolution(compRev);
            } else if (comp.get(0) == valueAtFirstPos) {
                flushToSolution(comp);
            }
        }

        private int groupFirstPosition() {
            return (groupNum - 1) * 5 + 1;
        }

        private void flushToSolution(List<Boolean> list) {
            final int firstPosition = groupFirstPosition() - 1;
            for (int i = 0; i < 5; i++) {
                solution.add(firstPosition + i, list.get(i));
                solution.add(bits - firstPosition - i - 1, list.get(9 - i));
            }
        }
    }

    private static boolean readBitAt(int position) {
        System.out.println(position);
        return STD_IN.nextInt() == 1;
    }

    public Solution(int bits) {
        this.bits = bits;
        solution = new ArrayList<>(bits);
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
            final LeadGroup leadGroup = new LeadGroup();
            leadGroup.init(groups.size() + 1);
            groups.push(leadGroup);
        } while (!groups.peek().isLead);

        for (int current = groups.size() * 5; current < bits - current; current += 4) {
            final Change change = groups.peek().syncWithFluctuation();

            switch (change) {
                case COMP_REV:
                    complement(solution);
                case REV:
                    Collections.reverse(solution);
                    break;
                case COMP:
                    complement(solution);
                    break;
            }

            for (int i = 0; i < 4; i++) {
                solution.add(current + i, readBitAt(current + i + 1));
                solution.add(bits - current - i - 1, readBitAt(bits - current - i));
            }
        }

        groups.forEach(LeadGroup::syncSolution);
        submitFinalGuess();
    }

    private void submitFinalGuess() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < bits; i++) {
            result.append(solution.get(i) ? "1" : "0");
        }

        System.out.println(result.toString());
        final String outcome = STD_IN.nextLine();

        if (!outcome.equals("Y")) {
            throw new IllegalStateException("Judge didn't answer with a Y");
        }
    }

    private static List<Boolean> complement(List<Boolean> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, !list.get(i));
        }

        return list;
    }
}