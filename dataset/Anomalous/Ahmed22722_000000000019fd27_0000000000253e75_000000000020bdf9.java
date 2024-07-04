import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            TreeMap<Integer, Integer> intervals = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                intervals.put(in.nextInt(), in.nextInt());
            }

            StringBuilder schedule = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (var entry : intervals.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();

                if (start >= cameronEnd) {
                    schedule.append('C');
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    schedule.append('J');
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                out.printf("Case #%d: IMPOSSIBLE\n", i);
            } else {
                out.printf("Case #%d: %s\n", i, schedule.toString());
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
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}