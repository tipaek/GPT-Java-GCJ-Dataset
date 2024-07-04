import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<Period> periods = new ArrayList<>();
            int numPeriods = scanner.nextInt();
            for (int i = 1; i <= numPeriods; i++) {
                periods.add(new Period(i, scanner.nextInt(), scanner.nextInt()));
            }

            Set<Period> cameronSet = new HashSet<>();
            Set<Period> jamieSet = new HashSet<>();

            if (schedulePossible(0, periods, cameronSet, jamieSet)) {
                StringBuilder result = new StringBuilder();
                for (Period period : periods) {
                    result.append(period.assignedPerson);
                }
                System.out.println("Case #" + caseNum + ": " + result);
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean schedulePossible(int index, List<Period> periods, Set<Period> cameronSet, Set<Period> jamieSet) {
        if (index == periods.size()) {
            return true;
        }
        Period currentPeriod = periods.get(index);
        if (canAssign(currentPeriod, cameronSet)) {
            currentPeriod.assignedPerson = 'C';
            cameronSet.add(currentPeriod);
            if (schedulePossible(index + 1, periods, cameronSet, jamieSet)) {
                return true;
            }
            cameronSet.remove(currentPeriod);
        }
        if (canAssign(currentPeriod, jamieSet)) {
            currentPeriod.assignedPerson = 'J';
            jamieSet.add(currentPeriod);
            if (schedulePossible(index + 1, periods, cameronSet, jamieSet)) {
                return true;
            }
            jamieSet.remove(currentPeriod);
        }
        return false;
    }

    private static boolean canAssign(Period currentPeriod, Set<Period> assignedSet) {
        return assignedSet.stream().noneMatch(period -> period.overlaps(currentPeriod));
    }

    public static class Period {
        public final int id;
        public final int start;
        public final int end;
        public char assignedPerson;

        public Period(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Period other) {
            return (this.start < other.end && this.end > other.start);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Period period = (Period) obj;
            return id == period.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}