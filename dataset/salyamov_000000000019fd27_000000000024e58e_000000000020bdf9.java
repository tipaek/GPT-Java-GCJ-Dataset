import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        try (BufferedReader stream = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(stream.readLine());

            for (int testCase = 1; testCase <= testCases; ++testCase) {
                Period[] periods = solution.readPeriods(stream);
                String result = solution.test(testCase, periods);
                solution.outputResult(result);
            }
        }
    }

    private void outputResult(String result) {
        System.out.println(result);
    }

    private Period[] readPeriods(BufferedReader reader) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        Period[] periods = new Period[count];
        for (int i = 0; i < count; i++) {
            String[] values = reader.readLine().split(" ");
            periods[i] = new Period(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
        }
        return periods;
    }

    String test(final int testCase, final Period[] periods) {
        return String.format("Case #%s: %s", testCase, test(periods));
    }

    private String test(final Period[] periods) {
        Map<Period, Integer> map = getPeriodIndexMap(periods);

        Arrays.sort(periods, Comparator.comparingInt(p -> p.end));

        int cameronEnd = 0;
        int jamieEnd = 0;

        char[] schedule = new char[periods.length];
        for (Period period : periods) {
            char person;
            if (cameronEnd <= period.start) {
                person = 'C';
                cameronEnd = period.end;
            } else if (jamieEnd <= period.start) {
                person = 'J';
                jamieEnd = period.end;
            } else {
                return "IMPOSSIBLE";
            }
            schedule[map.get(period)] = person;
        }

        StringBuilder result = new StringBuilder();
        for (char person : schedule) {
            result.append(person);
        }
        return result.toString();
    }

    private Map<Period, Integer> getPeriodIndexMap(Period[] periods) {
        Map<Period, Integer> map = new IdentityHashMap<>();
        for (int i = 0; i < periods.length; i++) {
            Period period = periods[i];
            map.put(period, i);
        }
        return map;
    }

    static class Period {
        private final int start;
        private final int end;

        Period(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + ']';
        }
    }
}
