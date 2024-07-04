import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static int[][] data;

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int T = in.nextInt();
        for (int q = 1; q <= T; q++) {
            int N = in.nextInt();
            int K = in.nextInt();
            data = new int[N][N];
            init(N);
            boolean found = false;
            if (trace(N) == K) {
                found = true;
            }
            found = row_got(N, K) || col_got(N, K) || swap_rol_and_col(N, K);
            if (!found) {
                out.println(get(q, "IMPOSSIBLE"));
            } else {
                out.println(get(q, "POSSIBLE"));
                printD(N);
            }

        }

        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static boolean swap_rol_and_col(int N, int K) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int a = 0; a < N; a++) {
                    for (int b = a + 1; b < N; b++) {
                        swap_row(i, j, N);
                        swap_col(a, b, N);
                        if (trace(N) == K) {
                            return true;
                        }
                        init(N);
                    }
                }
            }
        }
        return false;
    }

    static boolean row_got(int N, int K) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                swap_row(i, j, N);
                if (trace(N) == K) {
                    return true;
                }
                init(N);
            }
        }
        return false;
    }

    static boolean col_got(int N, int K) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                swap_col(i, j, N);
                if (trace(N) == K) {
                    return true;
                }
                init(N);
            }
        }
        return false;
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

    static void printD(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(data[i][j]);
                out.print(' ');
            }
            out.println("");
        }
    }

    static int trace(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += data[i][i];
        }
        return ans;
    }

    static void init(int n) {
        for (int i = 0; i < n; i++) {
            int k = i + 1;
            for (int j = 0; j < n; j++) {
                data[i][j] = k;
                k++;
                if (k > n) {
                    k = 1;
                }
            }
        }
    }

    static void swap_row(int r1, int r2, int n) {
        for (int i = 0; i < n; i++) {
            int temp = data[r1][i];
            data[r1][i] = data[r2][i];
            data[r2][i] = temp;
        }
    }

    static void swap_col(int r1, int r2, int n) {
        for (int i = 0; i < n; i++) {
            int temp = data[i][r1];
            data[i][r1] = data[i][r2];
            data[i][r2] = temp;
        }
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
