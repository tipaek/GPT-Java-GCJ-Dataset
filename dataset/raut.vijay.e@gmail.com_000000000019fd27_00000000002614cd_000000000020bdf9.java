import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static class Interval implements Comparable<Interval> {
        private final int start;
        private final int end;

        public Interval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(final Interval o) {
            return o.start < this.end;
        }

        @Override
        public int compareTo(final Interval o) {
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", start, end);
        }
    }

    public static void main(final String[] args) {
        final List<List<Interval>> testCases = parseInput();
        for (int index = 0; index < testCases.size(); index++) {
            final List<Interval> intervals = testCases.get(index);
            Collections.sort(intervals);
            // System.out.println(String.format("Case #%d: %s", index + 1, intervals));
            System.out.println(String.format("Case #%d: %s", index + 1, identifyCombinations(testCases.get(index))));
        }
    }

    private static String identifyCombinations(final List<Interval> intervals) {
        final List<Interval> cIntervals = new ArrayList<>();
        final List<Interval> jIntervals = new ArrayList<>();

        final StringBuilder result = new StringBuilder(intervals.size());
        cIntervals.add(intervals.get(0));
        result.append('C');

        for (int index = 1; index < intervals.size(); index++) {
            final Interval interval = intervals.get(index);
            if (!cIntervals.get(cIntervals.size() - 1).overlaps(interval)) {
                cIntervals.add(interval);
                result.append('C');
                continue;
            }

            if (jIntervals.isEmpty()) {
                jIntervals.add(interval);
                result.append('J');
                continue;
            }

            if (jIntervals.get(jIntervals.size() - 1).overlaps(interval)) {
                return "IMPOSSIBLE";
            }

            jIntervals.add(interval);
            result.append('J');
        }

        return result.toString();
    }

    private static List<List<Interval>> parseInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            String readLine = scanner.nextLine();
            final int numTestCases = Integer.parseInt(readLine);

            final List<List<Interval>> testCases = new ArrayList<>(numTestCases);
            for (int index = 0; index < numTestCases && null != (readLine = scanner.nextLine()); index++) {

                final int numIntervals = Integer.parseInt(readLine);

                final List<Interval> intervals = new ArrayList<>(numIntervals);
                for (int pos = 0; pos < numIntervals; pos++) {
                    readLine = scanner.nextLine();
                    final String[] inputs = readLine.split("\\s+");
                    intervals.add(new Interval(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
                }

                testCases.add(intervals);
            }

            return testCases;
        }
    }
}
