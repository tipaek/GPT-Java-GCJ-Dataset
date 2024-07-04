import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int t = in.nextInt();
        for (int q = 1; q <= t; q++) {
            int n = in.nextInt();
            int[][] data = new int[n][n];
            int tr = 0;
            int r = 0;
            int c = 0;
            Set<Integer> seen;
            boolean row = false;
            for (int i = 0; i < n; i++) {
                seen = new HashSet<>();
                row = false;
                for (int j = 0; j < n; j++) {
                    data[i][j] = in.nextInt();
                    if (seen.contains(data[i][j])) {
                        row = true;
                    }
                    seen.add(data[i][j]);
                }
                if (row) {
                    r++;
                }
                tr += data[i][i];
            }
            boolean col = false;
            for (int i = 0; i < n; i++) {
                seen = new HashSet<>();
                col = false;
                for (int j = 0; j < n; j++) {
                    if (seen.contains(data[j][i])) {
                        col = true;
                    }
                    seen.add(data[j][i]);
                }
                if (col) {
                    c++;
                }
            }
            out.println(get(q, tr, r, c));
        }
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
