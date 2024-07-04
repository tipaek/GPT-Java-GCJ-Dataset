import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < testCases; i++) {
                int numPeriods = Integer.parseInt(scanner.nextLine());
                List<Period> periods = new ArrayList<>();
                for (int j = 0; j < numPeriods; j++) {
                    periods.add(Period.parse(scanner.nextLine()));
                }
                System.out.println(String.format("Case #%d: %s", i + 1, assignPeriods(periods)));
            }
        }
    }

    private static String assignPeriods(Collection<Period> periods) {
        StringBuilder result = new StringBuilder(periods.size());
        Queue<Period> sortedPeriods = new PriorityQueue<>(Comparator.comparingInt(p -> p.start));
        sortedPeriods.addAll(periods);

        List<Period> cameronPeriods = new ArrayList<>();
        List<Period> jamiePeriods = new ArrayList<>();
        Map<Period, String> assignment = new HashMap<>(periods.size());

        for (Period period : sortedPeriods) {
            if (isNonOverlapping(period, cameronPeriods)) {
                cameronPeriods.add(period);
                assignment.put(period, CAMERON);
            } else if (isNonOverlapping(period, jamiePeriods)) {
                jamiePeriods.add(period);
                assignment.put(period, JAMIE);
            } else {
                return IMPOSSIBLE;
            }
        }

        for (Period period : periods) {
            result.append(assignment.get(period));
        }
        return result.toString();
    }

    private static boolean isNonOverlapping(Period period, Collection<Period> existingPeriods) {
        for (Period existing : existingPeriods) {
            if (existing.overlapsWith(period)) {
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

        public boolean overlapsWith(Period other) {
            return (this.start < other.end && this.end > other.start);
        }

        public static Period parse(String input) {
            String[] tokens = input.split(" ");
            return new Period(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Period period = (Period) o;
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