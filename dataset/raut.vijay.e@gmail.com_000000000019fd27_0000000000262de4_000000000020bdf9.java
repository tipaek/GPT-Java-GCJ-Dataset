import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + end;
            result = prime * result + start;
            return result;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Interval other = (Interval) obj;
            if (end != other.end) {
                return false;
            }
            if (start != other.start) {
                return false;
            }
            return true;
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
            final List<Interval> sortedIntervals = new ArrayList<>(intervals);
            Collections.sort(sortedIntervals);
            // System.out.println(String.format("Case #%d: ORIG :: %s", index + 1, intervals));
            // System.out.println(String.format("Case #%d: SORTED :: %s", index + 1, intervals));
            System.out
                .println(String.format("Case #%d: %s", index + 1, identifyCombinations(intervals, sortedIntervals)));
            // System.out.println();
        }
    }

    private static String identifyCombinations(final List<Interval> intervals, final List<Interval> sortedIntervals) {
        Interval lastCInterval = null;
        Interval lastJInterval = null;

        final Map<Interval, Character> referenceMap = new HashMap<>(sortedIntervals.size());

        referenceMap.put(sortedIntervals.get(0), 'C');
        lastCInterval = sortedIntervals.get(0);

        for (int index = 1; index < sortedIntervals.size(); index++) {
            final Interval interval = sortedIntervals.get(index);
            if (!lastCInterval.overlaps(interval)) {
                lastCInterval = interval;
                referenceMap.put(interval, 'C');
                continue;
            }

            if (null == lastJInterval) {
                lastJInterval = interval;
                referenceMap.put(interval, 'J');
                continue;
            }

            if (lastJInterval.overlaps(interval)) {
                return "IMPOSSIBLE";
            }

            lastJInterval = interval;
            referenceMap.put(interval, 'J');
        }

        final StringBuilder result = new StringBuilder(sortedIntervals.size());
        for (final Interval interval : intervals) {
            result.append(referenceMap.get(interval));
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
