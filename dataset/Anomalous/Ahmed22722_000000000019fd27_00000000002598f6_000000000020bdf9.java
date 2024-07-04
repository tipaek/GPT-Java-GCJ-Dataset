import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static class Interval implements Comparable<Interval> {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        int testCases = in.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Interval(start, end));
            }
            Collections.sort(intervals);

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder();

            for (Interval interval : intervals) {
                if (interval.start >= cameronEnd) {
                    schedule.append('C');
                    cameronEnd = interval.end;
                } else if (interval.start >= jamieEnd) {
                    schedule.append('J');
                    jamieEnd = interval.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append(String.format("Case #%d: IMPOSSIBLE\n", t));
            } else {
                result.append(String.format("Case #%d: %s\n", t, schedule));
            }
        }

        out.print(result);
        out.flush();
    }

    private static class FastReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}