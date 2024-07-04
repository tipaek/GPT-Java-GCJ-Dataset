import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            for (int testCase = 0; testCase < testCases; testCase++) {
                int numOfPeriods = Integer.parseInt(scanner.nextLine());
                List<Period> periods = new ArrayList<>();
                for (int i = 0; i < numOfPeriods; i++) {
                    periods.add(Period.parse(scanner.nextLine()));
                }
                System.out.printf("Case #%d: %s%n", testCase + 1, assignTasks(periods));
            }
        }
    }

    private static String assignTasks(List<Period> periods) {
        StringBuilder result = new StringBuilder(periods.size());
        Queue<Period> sortedPeriods = new PriorityQueue<>(Comparator.comparingInt(p -> p.start));
        sortedPeriods.addAll(periods);

        List<Period> cameronSchedule = new ArrayList<>();
        List<Period> jamieSchedule = new ArrayList<>();
        Map<Period, String> assignments = new HashMap<>(periods.size());

        for (Period period : sortedPeriods) {
            if (isAssignable(period, jamieSchedule)) {
                jamieSchedule.add(period);
                assignments.put(period, JAMIE);
            } else if (isAssignable(period, cameronSchedule)) {
                cameronSchedule.add(period);
                assignments.put(period, CAMERON);
            } else {
                return IMPOSSIBLE;
            }
        }

        for (Period period : periods) {
            result.append(assignments.get(period));
        }
        return result.toString();
    }

    private static boolean isAssignable(Period newPeriod, List<Period> schedule) {
        for (Period existingPeriod : schedule) {
            if (existingPeriod.intersects(newPeriod)) {
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

        public static Period parse(String input) {
            String[] parts = input.split(" ");
            return new Period(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }

        public boolean intersects(Period other) {
            return this.start < other.end && other.start < this.end;
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