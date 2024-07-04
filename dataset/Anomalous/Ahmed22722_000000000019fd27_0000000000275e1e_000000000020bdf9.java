import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static class Interval implements Comparable<Interval> {
        int start, end;

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
        public int compareTo(Interval other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            char[] assignments = new char[n];
            Map<String, Integer> indexMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Interval(start, end));
                indexMap.put(start + "," + end, i);
            }

            Collections.sort(intervals);

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (Interval interval : intervals) {
                int start = interval.getStart();
                int end = interval.getEnd();
                int originalIndex = indexMap.get(start + "," + end);

                if (start >= cameronEnd) {
                    assignments[originalIndex] = 'C';
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    assignments[originalIndex] = 'J';
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                out.printf("Case #%d: %s\n", testCase, new String(assignments));
            }
        }
        out.flush();
    }

    private static class FastReader {
        private BufferedReader reader;
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