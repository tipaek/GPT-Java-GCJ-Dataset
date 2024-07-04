import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        // Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")));
        Solution solution = new Solution();
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            
            for (int i = 0; i < T; i++) {
                int N = scanner.nextInt();
                List<Interval> intervals = new ArrayList<>(N);
                for (int j = 0; j < N; j++) {
                    intervals.add(solution.new Interval(scanner.nextInt(), scanner.nextInt()));
                }
                intervals.sort(Comparator.comparingInt(Interval::getStart));
                
                String result = solution.assignIntervals(intervals);
                System.out.println(String.format("Case #%d: %s", (i + 1), result));
            }
        }
        scanner.close();
    }

    private String assignIntervals(List<Interval> intervals) {
        StringBuilder builder = new StringBuilder();
        Interval cameron = null;
        Interval jamie = null;

        for (Interval interval : intervals) {
            if (cameron == null || interval.getStart() >= cameron.getEnd()) {
                builder.append('C');
                cameron = interval;
            } else if (jamie == null || interval.getStart() >= jamie.getEnd()) {
                builder.append('J');
                jamie = interval;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return builder.toString();
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
    }
}