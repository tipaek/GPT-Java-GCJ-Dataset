import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static class Pair implements Comparable<Pair> {
        int start, end;

        public Pair(int start, int end) {
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
        public int compareTo(Pair other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Pair> intervals = new ArrayList<>();
            char[] assignments = new char[n];
            Map<String, Integer> indexMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Pair(start, end));
                indexMap.put(start + ":" + end, j);
            }

            Collections.sort(intervals);

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (Pair interval : intervals) {
                int start = interval.getStart();
                int end = interval.getEnd();
                int originalIndex = indexMap.get(start + ":" + end);

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
                out.printf("Case #%d: IMPOSSIBLE\n", i);
            } else {
                out.printf("Case #%d: %s\n", i, new String(assignments));
            }
        }
        out.flush();
    }

    private static final class FastReader {
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