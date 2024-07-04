import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    // TODO: do not forget
    private static final int READ_FROM_FILE = 0;
    private static final int WRITE_TO_FILE = 0;
    private static final String INPUT_FILE = "input.txt";
    //    private static final String INPUT_FILE = "A-large.in";
    private static final String OUTPUT_FILE = "A-large.out";

    private void run(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m[][] = new int[n][n];

        int r = 0, c = 0, k = 0;
        for (int i = 0; i < n; ++i) {
            int mask[] = new int[n + 1];
            int dup = 0;
            for (int j = 0; j < n; ++j) {
                int cur = in.nextInt();
                m[i][j] = cur;
                if (mask[cur] == 0)
                    mask[cur] = 1;
                else
                    dup = 1;
            }
            r += dup;
        }

        for (int i = 0; i < n; ++i)
            k += m[i][i];

        for (int i = 0; i < n; ++i) {
            int mask[] = new int[n + 1];
            int dup = 0;
            for (int j = 0; j < n; ++j) {
                int cur = m[j][i];
                if (mask[cur] == 0)
                    mask[cur] = 1;
                else
                    dup = 1;
            }
            c += dup;
        }

        out.print(String.format("%d %d %d", k, r, c));
    }

    public static void main(String[] args) {
        InputReader in;
        PrintWriter out;
        try {
            if (READ_FROM_FILE == 1) {
                in = new InputReader(new FileInputStream(INPUT_FILE));
            } else {
                in = new InputReader(System.in);
            }
            if (WRITE_TO_FILE == 1) {
                out = new PrintWriter(OUTPUT_FILE);
            } else {
                out = new PrintWriter(System.out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Solution solution = new Solution();
        int cases = in.nextInt();
        for(int i = 1; i <= cases; ++i) {
            out.print("Case #" + i + ": ");
            solution.run(in, out);
            out.println();
        }

        out.flush();
        out.close();
    }

    private static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextCharacter() {
            return next().charAt(0);
        }
    }
}