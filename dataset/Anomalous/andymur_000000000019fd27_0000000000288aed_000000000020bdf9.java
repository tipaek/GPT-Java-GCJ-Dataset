import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testIndex = 0; testIndex < testCount; testIndex++) {
                int periodCount = Integer.parseInt(scanner.nextLine());
                List<Period> periods = new ArrayList<>();

                for (int periodIndex = 0; periodIndex < periodCount; periodIndex++) {
                    periods.add(Period.parse(scanner.nextLine()));
                }

                System.out.println(String.format("Case #%d: %s", testIndex + 1, assignTasks(periods)));
            }
        }
    }

    private static String assignTasks(List<Period> periods) {
        StringBuilder result = new StringBuilder();
        List<Period> cameronPeriods = new ArrayList<>();
        List<Period> jamiePeriods = new ArrayList<>();

        for (Period period : periods) {
            if (isNonOverlapping(period, cameronPeriods)) {
                cameronPeriods.add(period);
                result.append(CAMERON);
            } else if (isNonOverlapping(period, jamiePeriods)) {
                jamiePeriods.add(period);
                result.append(JAMIE);
            } else {
                return IMPOSSIBLE;
            }
        }

        return result.toString();
    }

    private static boolean isNonOverlapping(Period newPeriod, List<Period> existingPeriods) {
        for (Period period : existingPeriods) {
            if (period.overlaps(newPeriod)) {
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

        public boolean overlaps(Period other) {
            return this.start < other.end && other.start < this.end;
        }

        public static Period parse(String periodStr) {
            String[] parts = periodStr.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            return new Period(start, end);
        }

        @Override
        public String toString() {
            return "Period{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
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
    }
}