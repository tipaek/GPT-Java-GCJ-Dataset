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
            String input = in.next();
            StringBuilder b = new StringBuilder();

            int openPar = 0;
            for (char c : input.toCharArray()) {
                int value = Character.getNumericValue(c);
                if (value == 0) {
                    if (openPar > 0) {
                        close(openPar, b);
                        openPar = 0;
                    }
                } else {
                    if (value >= openPar) {
                        open(value - openPar, b);
                    } else {
                        close(openPar - value, b);
                    }
                    openPar = value;
                }
                b.append(value);
            }
            close(openPar, b);

            out.print("Case #" + t + ": ");
            out.println(b.toString());
            out.println();
        }
        out.close();
    }

    private void open(int par, StringBuilder b) {
        for (int i = 0; i < par; i++) {
            b.append("(");
        }
    }

    private void close(int par, StringBuilder b) {
        for (int i = 0; i < par; i++) {
            b.append(")");
        }
    }

    public static void main(String[] args) {
        Solution p = new Solution();
        p.resolve();
    }
}
