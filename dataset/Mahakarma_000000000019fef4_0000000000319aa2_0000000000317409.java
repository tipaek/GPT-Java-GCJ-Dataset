import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        solve();
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static void solve() {
        int t = in.nextInt();
        for (int q = 1; q <= t; q++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String route = in.next();
            int x = 0;
            int y = 0;
            int ans = Integer.MAX_VALUE;
            int count = 0;
            for (int i = 0; i < route.length(); i++) {
                if (route.charAt(i) == 'S') {
                    Y--;
                }
                if (route.charAt(i) == 'N') {
                    Y++;
                }
                if (route.charAt(i) == 'E') {
                    X++;
                }
                if (route.charAt(i) == 'W') {
                    X--;
                }
                count++;
                if (count >= count(x, y, X, Y)) {
                    ans = Math.min(ans, count);
                }
            }
            if (ans == Integer.MAX_VALUE) {
                out.println(get(q, "IMPOSSIBLE"));
            } else {
                out.println(get(q, ans));
            }
        }
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

    static int count(int x, int y, int X, int Y) {
        return Math.abs(x - X) + Math.abs(y - Y);
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

        public int[] readAllInts(int n) {
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public int[] readAllInts(int n, int s) {
            int[] p = new int[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextInt();
            }
            return p;
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
