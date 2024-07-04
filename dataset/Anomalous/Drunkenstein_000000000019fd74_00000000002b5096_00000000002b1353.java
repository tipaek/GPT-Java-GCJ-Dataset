import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                out.print("Case #" + test + ": ");
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void solve() throws Exception {
        int N = in.nextInt() - 1;

        out.println();
        out.println("1 1");
        int r = 1;
        int k = 1;
        while (N > 0) {
            int next = getVal(r, k);
            if (next <= N) {
                out.println((r + 1) + " " + (k + 1));
                N -= next;
                r++;
            } else {
                N = -N;
            }
        }

        for (int i = 0; i < -N; i++) {
            out.println((r - i) + " 1");
        }
    }

    static int getVal(int row, int col) {
        return col == 0 ? 1 : row;
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
                    String str = reader.readLine();
                    if (str == null) return "";
                    tokenizer = new StringTokenizer(str);
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