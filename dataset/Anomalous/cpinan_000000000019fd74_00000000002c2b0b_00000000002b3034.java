import java.io.*;
import java.util.StringTokenizer;

public class Solution {

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

    private void solve() {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            String[] patterns = new String[N];
            for (int i = 0; i < N; i++) {
                patterns[i] = in.next();
            }

            boolean isValidPattern = true;
            String longestPattern = null;
            for (int i = 1; i < N; i++) {
                String current = patterns[i];
                String previous = longestPattern == null ? patterns[i - 1] : longestPattern;

                int indexCurrent = current.length() - 1;
                int indexPrevious = previous.length() - 1;

                while (indexCurrent >= 0 && indexPrevious >= 0) {
                    if (current.charAt(indexCurrent) != previous.charAt(indexPrevious)) {
                        if (current.charAt(indexCurrent) == '*' || previous.charAt(indexPrevious) == '*') {
                            String selected = current.length() > previous.length() ? current : previous;
                            selected = selected.substring(1);
                            if (longestPattern == null || selected.length() > longestPattern.length()) {
                                longestPattern = selected;
                            }
                        } else {
                            isValidPattern = false;
                        }
                        break;
                    }
                    indexCurrent--;
                    indexPrevious--;
                }
            }

            out.print("Case #" + t + ": ");
            out.print(isValidPattern ? longestPattern : "*");
            out.println();
        }
        out.close();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}