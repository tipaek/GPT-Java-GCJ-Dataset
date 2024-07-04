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
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            TreeMap<Integer, Integer> schedule = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                schedule.put(in.nextInt(), in.nextInt());
            }

            StringBuilder assignment = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;

            for (var entry : schedule.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();

                if (start >= cameronEnd) {
                    assignment.append('C');
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    assignment.append('J');
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append(String.format("Case #%d: IMPOSSIBLE\n", i));
            } else {
                result.append(String.format("Case #%d: %s\n", i, assignment));
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