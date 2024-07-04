import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        while (scanner.hasNext()) {
            int T = scanner.nextInt();

            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
                }

                String result = solution.assignIntervals(intervals);
                System.out.println(String.format("Case #%d: %s", (i + 1), result));
            }
        }
        scanner.close();
    }

    private String assignIntervals(List<Interval> intervals) {
        StringBuilder builder = new StringBuilder();
        List<Interval> cameron = new ArrayList<>();
        List<Interval> jamie = new ArrayList<>();

        for (Interval interval : intervals) {
            if (isOverlapping(cameron, interval) && isOverlapping(jamie, interval)) {
                return "IMPOSSIBLE";
            } else if (!isOverlapping(cameron, interval) && !isOverlapping(jamie, interval)) {
                if (cameron.size() <= jamie.size()) {
                    builder.append('C');
                    cameron.add(interval);
                } else {
                    builder.append('J');
                    jamie.add(interval);
                }
            } else if (!isOverlapping(cameron, interval) && isOverlapping(jamie, interval)) {
                builder.append('C');
                cameron.add(interval);
            } else {
                builder.append('J');
                jamie.add(interval);
            }
        }

        return builder.toString();
    }

    private static boolean isOverlapping(List<Interval> list, Interval interval) {
        return list.stream().anyMatch(item -> overlaps(item, interval));
    }

    private static boolean overlaps(Interval first, Interval second) {
        return first.getStart() < second.getEnd() && second.getStart() < first.getEnd();
    }

    class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int hashCode() {
            return 31 * start + 31 * end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Interval interval = (Interval) obj;
            return start == interval.start && end == interval.end;
        }

        @Override
        public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }
    }
}