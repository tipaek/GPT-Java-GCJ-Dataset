import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numPeriods = scanner.nextInt();
            List<Period> periods = new ArrayList<>();

            for (int i = 1; i <= numPeriods; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                periods.add(new Period(i, start, end));
            }

            periods.sort(Comparator.comparingInt(Period::getStart));

            Set<Period> cSet = new HashSet<>();
            Set<Period> jSet = new HashSet<>();
            boolean isPossible = true;

            for (Period period : periods) {
                if (cSet.stream().noneMatch(c -> c.overlaps(period))) {
                    period.setOwner('C');
                    cSet.add(period);
                } else if (jSet.stream().noneMatch(j -> j.overlaps(period))) {
                    period.setOwner('J');
                    jSet.add(period);
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                char[] result = new char[numPeriods];
                for (Period period : periods) {
                    result[period.getIndex() - 1] = period.getOwner();
                }
                System.out.println("Case #" + testCase + ": " + new String(result));
            }
        }
    }

    static class Period {
        private final int index;
        private final int start;
        private final int end;
        private char owner;

        public Period(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public char getOwner() {
            return owner;
        }

        public void setOwner(char owner) {
            this.owner = owner;
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