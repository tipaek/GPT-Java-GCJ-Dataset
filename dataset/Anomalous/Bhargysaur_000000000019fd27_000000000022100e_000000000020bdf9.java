import java.util.*;

public class Solution {
    private static class Interval {
        final int start;
        final int end;
        String person = "";

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start, o2.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }

            List<Interval> sortedIntervals = new ArrayList<>(intervals);
            Collections.sort(sortedIntervals, new IntervalComparator());

            Interval cameron = null;
            Interval jamie = null;
            StringBuilder result = new StringBuilder();
            Map<Interval, Integer> intervalIndexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                intervalIndexMap.put(intervals.get(i), i);
            }

            for (Interval interval : sortedIntervals) {
                if (cameron == null || cameron.end <= interval.start) {
                    result.append("C");
                    int index = intervalIndexMap.get(interval);
                    intervals.get(index).person = "C";
                    cameron = intervals.get(index);
                } else if (jamie == null || jamie.end <= interval.start) {
                    result.append("J");
                    int index = intervalIndexMap.get(interval);
                    intervals.get(index).person = "J";
                    jamie = intervals.get(index);
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}