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
        InputReader in = new InputReader(System.in);
        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            String[] patterns = new String[N];

            for (int i = 0; i < N; i++) {
                patterns[i] = in.next();
            }

            boolean isValidPattern = true;
            String finalPattern = null;

            for (int i = 1; i < N; i++) {
                String current = patterns[i];
                String previous = finalPattern == null ? patterns[i - 1] : finalPattern;

                int currentIndex = current.length() - 1;
                int previousIndex = previous.length() - 1;

                while (currentIndex >= 0 && previousIndex >= 0) {
                    if (current.charAt(currentIndex) != previous.charAt(previousIndex)) {
                        if (current.charAt(currentIndex) == '*' || previous.charAt(previousIndex) == '*') {
                            String longerPattern = current.length() > previous.length() ? current : previous;
                            longerPattern = longerPattern.substring(1);
                            if (finalPattern == null || longerPattern.length() > finalPattern.length()) {
                                finalPattern = longerPattern;
                            }
                        } else {
                            isValidPattern = false;
                        }
                        break;
                    }
                    currentIndex--;
                    previousIndex--;
                }
            }

            out.print("Case #" + t + ": ");
            out.print(isValidPattern ? finalPattern : "*");
            out.println();
        }
        out.close();
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}