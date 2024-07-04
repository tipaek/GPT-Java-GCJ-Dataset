import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

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

    private void resolve() {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);

        PrintStream out = System.out;

        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();

            String[] P = new String[N];
            for (int i = 0; i < N; i++) {
                P[i] = in.next();
            }
            // System.out.println(Arrays.toString(P));

            // Test 1
            boolean hasValidPattern = true;
            String selectedPattern = null;
            for (int i = 1; i < N; i++) {
                String current = P[i];
                String previous = selectedPattern == null ? P[i - 1] : selectedPattern;

                int n1 = current.length() - 1;
                int n2 = previous.length() - 1;

                while (n1 >= 0 && n2 >= 0) {
                    if (current.charAt(n1) != previous.charAt(n2)) {
                        if (current.charAt(n1) == '*' || previous.charAt(n2) == '*') {
                            String selected = current;
                            if (previous.length() > selected.length()) {
                                selected = previous;
                            }
                            selected = selected.substring(1);
                            if (selectedPattern == null || selected.length() > selectedPattern.length()) {
                                selectedPattern = selected;
                            }
                        } else {
                            hasValidPattern = false;
                        }
                        break;
                    }
                    n1--;
                    n2--;
                }

            }

            out.print("Case #" + t + ": ");
            out.print(hasValidPattern ? selectedPattern : "*");
            out.println();
        }
        out.close();
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        p.resolve();
    }
}
