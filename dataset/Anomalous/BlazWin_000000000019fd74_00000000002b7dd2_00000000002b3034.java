import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = in.nextInt();
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class PatternMatching {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            String[] patterns = new String[n];
            String prefix = "";
            String suffix = "";

            for (int i = 0; i < n; i++) {
                patterns[i] = in.next();
                String s = patterns[i];
                int firstAsterisk = s.indexOf('*');
                int lastAsterisk = s.lastIndexOf('*');

                if (firstAsterisk > prefix.length()) {
                    prefix = s.substring(0, firstAsterisk);
                }
                if (s.length() - lastAsterisk - 1 > suffix.length()) {
                    suffix = s.substring(lastAsterisk + 1);
                }
            }

            for (String pattern : patterns) {
                if (!pattern.startsWith(prefix.replace('*', ' ')) || !pattern.endsWith(suffix.replace('*', ' '))) {
                    out.println(String.format("Case #%d: *", testNumber));
                    return;
                }
            }

            StringBuilder result = new StringBuilder(prefix);
            for (String pattern : patterns) {
                int firstAsterisk = pattern.indexOf('*');
                int lastAsterisk = pattern.lastIndexOf('*');
                result.append(pattern, firstAsterisk + 1, lastAsterisk);
            }
            result.append(suffix);

            out.println(String.format("Case #%d: %s", testNumber, result.toString()));
        }
    }

    static class InputReader {

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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