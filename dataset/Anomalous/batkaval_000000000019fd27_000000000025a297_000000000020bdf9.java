import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfPeriods = scanner.nextInt();
            List<Period> periods = new ArrayList<>();
            for (int i = 0; i < numberOfPeriods; i++) {
                periods.add(new Period(i, scanner.nextInt(), scanner.nextInt()));
            }

            if (assignTasks(periods)) {
                StringBuilder result = new StringBuilder();
                for (Period period : periods) {
                    result.append(period.assignedTo);
                }
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean assignTasks(List<Period> periods) {
        return assignTasksRecursive(0, periods, new HashSet<>(), new HashSet<>());
    }

    private static boolean assignTasksRecursive(int index, List<Period> periods, Set<Period> cSet, Set<Period> jSet) {
        if (index == periods.size()) {
            return true;
        }
        Period currentPeriod = periods.get(index);
        if (canAssignToSet(currentPeriod, cSet)) {
            currentPeriod.assignedTo = 'C';
            cSet.add(currentPeriod);
            if (assignTasksRecursive(index + 1, periods, cSet, jSet)) {
                return true;
            }
            cSet.remove(currentPeriod);
        }
        if (canAssignToSet(currentPeriod, jSet)) {
            currentPeriod.assignedTo = 'J';
            jSet.add(currentPeriod);
            if (assignTasksRecursive(index + 1, periods, cSet, jSet)) {
                return true;
            }
            jSet.remove(currentPeriod);
        }
        return false;
    }

    private static boolean canAssignToSet(Period period, Set<Period> set) {
        return set.stream().noneMatch(existingPeriod -> existingPeriod.overlaps(period));
    }

    public static class Period {
        public final int index;
        public final int start;
        public final int end;
        public char assignedTo;

        public Period(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Period other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Period period = (Period) obj;
            return index == period.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }
}