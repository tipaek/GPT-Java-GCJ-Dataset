import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")));
        Solution solution = new Solution();

        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>(N);
                for (int j = 0; j < N; j++) {
                    intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
                }

                String result = assignIntervals(intervals);
                System.out.println(String.format("Case #%d: %s", (i + 1), result));
            }
        }
        scanner.close();
    }

    private static String assignIntervals(List<Interval> intervals) {
        List<Interval> cameron = new ArrayList<>();
        List<Interval> jamie = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

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
            } else if (isOverlapping(cameron, interval) && !isOverlapping(jamie, interval)) {
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
        public String toString() {
            return "[start=" + start + ", end=" + end + "]";
        }

        @Override
        public int hashCode() {
            return 587 * start + 997 * end;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object instanceof Interval) {
                Interval other = (Interval) object;
                return this.start == other.getStart() && this.end == other.getEnd();
            }
            return false;
        }
    }
}