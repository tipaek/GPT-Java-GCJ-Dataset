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
        int T = scanner.nextInt();

        Comparator<Interval> intervalComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return Integer.compare(o1.end, o2.end);
                }
                return Integer.compare(o1.start, o2.start);
            }
        };

        for (int t = 1; t <= T; t++) {
            List<Interval> intervals = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }

            List<Interval> originalIntervals = new ArrayList<>(intervals);
            Collections.sort(intervals, intervalComparator);

            int endJ = 0, endC = 0;
            StringBuilder result = new StringBuilder();
            Map<Interval, String> assignmentMap = new HashMap<>();

            for (Interval interval : intervals) {
                if (interval.start >= endJ) {
                    endJ = interval.end;
                    assignmentMap.put(interval, "J");
                } else if (interval.start >= endC) {
                    endC = interval.end;
                    assignmentMap.put(interval, "C");
                } else {
                    assignmentMap = null;
                    break;
                }
            }

            if (assignmentMap == null) {
                result.append("IMPOSSIBLE");
            } else {
                for (Interval interval : originalIntervals) {
                    result.append(assignmentMap.get(interval));
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}