import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new BufferedInputStream(System.in)
        )) {
            int testNumbers = strToInt(scanner.nextLine());
            for (int testNumber = 0 ; testNumber < testNumbers; testNumber++) {
                int periods = strToInt(scanner.nextLine());
                List<Period> data = new ArrayList<>();

                for (int periodNumber = 0; periodNumber < periods; periodNumber++) {
                    data.add(Period.of(scanner.nextLine()));
                }

                System.out.println(String.format("Case #%d: %s", testNumber + 1 , solution(data)));
            }
        }
    }

    private static String solution(List<Period> periods) {
        StringBuilder result = new StringBuilder(periods.size());
        List<Period> jamiePeriods = new ArrayList<>();
        List<Period> cameronPeriods = new ArrayList<>();

        for (Period currentPeriod: periods) {
            if (canBeAdded(currentPeriod, jamiePeriods)) {
                jamiePeriods.add(currentPeriod);
                result.append(JAMIE);
            } else if (canBeAdded(currentPeriod, cameronPeriods)) {
                cameronPeriods.add(currentPeriod);
                result.append(CAMERON);
            } else {
                return IMPOSSIBLE;
            }
        }

        return result.toString();
    }

    private static boolean canBeAdded(Period period, Collection<Period> periods) {
        for (Period existedPeriod: periods) {
            if (existedPeriod.intersect(period)) {
                return false;
            }
        }
        return true;
    }

    private static int strToInt(String string) {
        return Integer.parseInt(string);
    }

    private static class Period {
        public static Period EMPTY = new Period(-1, -1);

        private final int start;
        private final int end;

        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean intersect(Period period) {
            if (period.start >= this.start && period.start < this.end) {
                return true;
            }

            return this.start >= period.start && this.start < period.end;
        }

        private static Period of(String period) {
            String[] startAndEnd = period.split(" ");
            return new Period(strToInt(startAndEnd[0]), strToInt(startAndEnd[1]));
        }

        @Override
        public String toString() {
            return "Period{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Period period = (Period) o;
            return start == period.start &&
                    end == period.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}
