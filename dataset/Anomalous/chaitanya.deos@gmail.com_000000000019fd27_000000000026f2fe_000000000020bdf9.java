import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("test.in")))) {
            Solution solution = new Solution();
            while (scanner.hasNext()) {
                int T = scanner.nextInt();
                for (int i = 0; i < T; i++) {
                    int N = scanner.nextInt();
                    List<Interval> intervals = new ArrayList<>(N);
                    for (int j = 0; j < N; j++) {
                        intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
                    }
                    intervals.sort(Comparator.comparingInt(Interval::getStart));

                    String result = assignIntervals(intervals);
                    System.out.println(String.format("Case #%d: %s", (i + 1), result));
                }
            }
        }
    }

    private static String assignIntervals(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return "IMPOSSIBLE";
        }

        Interval cameron = intervals.get(0);
        Interval jamie = intervals.get(1);
        StringBuilder builder = new StringBuilder("JC");

        for (int k = 2; k < intervals.size(); k++) {
            Interval interval = intervals.get(k);
            if (interval.getStart() >= cameron.getEnd()) {
                builder.append('C');
                cameron = interval;
            } else if (interval.getStart() >= jamie.getEnd()) {
                builder.append('J');
                jamie = interval;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return builder.toString();
    }

    static class Interval {
        private final int start;
        private final int end;

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