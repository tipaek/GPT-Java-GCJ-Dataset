import java.util.*;

public class Solution {

    public static class Interval {
        public int start;
        public int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " " + end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        Comparator<Interval> intervalComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return Integer.compare(o1.end, o2.end);
                }
                return Integer.compare(o1.start, o2.start);
            }
        };

        for (int t = 1; t <= testCases; t++) {
            List<Interval> intervals = new ArrayList<>();
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            Collections.sort(intervals, intervalComparator);

            int endJ = 0;
            int endC = 0;
            StringBuilder schedule = new StringBuilder();

            for (Interval interval : intervals) {
                if (interval.start >= endJ) {
                    endJ = interval.end;
                    schedule.append("J");
                } else if (interval.start >= endC) {
                    endC = interval.end;
                    schedule.append("C");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + schedule.toString());
        }
    }
}