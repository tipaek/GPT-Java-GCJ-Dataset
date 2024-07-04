import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testCase = 1; testCase <= testCount; testCase++) {
                int periodCount = Integer.parseInt(scanner.nextLine());
                List<Period> periods = new ArrayList<>();

                for (int i = 0; i < periodCount; i++) {
                    periods.add(Period.fromString(scanner.nextLine()));
                }

                String result = assignTasks(periods);
                System.out.printf("Case #%d: %s%n", testCase, result);
            }
        }
    }

    private static String assignTasks(List<Period> periods) {
        StringBuilder assignment = new StringBuilder(periods.size());
        List<Period> cameronSchedule = new ArrayList<>();
        List<Period> jamieSchedule = new ArrayList<>();

        for (Period period : periods) {
            if (isNonOverlapping(period, cameronSchedule)) {
                cameronSchedule.add(period);
                assignment.append(CAMERON);
            } else if (isNonOverlapping(period, jamieSchedule)) {
                jamieSchedule.add(period);
                assignment.append(JAMIE);
            } else {
                return IMPOSSIBLE;
            }
        }

        return assignment.toString();
    }

    private static boolean isNonOverlapping(Period newPeriod, List<Period> schedule) {
        for (Period existingPeriod : schedule) {
            if (newPeriod.overlapsWith(existingPeriod)) {
                return false;
            }
        }
        return true;
    }

    private static class Period {
        private final int start;
        private final int end;

        private Period(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Period fromString(String periodString) {
            String[] parts = periodString.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            return new Period(start, end);
        }

        public boolean overlapsWith(Period other) {
            return (this.start < other.end) && (other.start < this.end);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Period period = (Period) obj;
            return start == period.start && end == period.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "Period{" + "start=" + start + ", end=" + end + '}';
        }
    }
}