import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C solver = new C();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int R = in.nextInt();
            int C = in.nextInt();
            int[][] field = new int[R][C];
            long ans = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    field[i][j] = in.nextInt();
                    ans += field[i][j];
                }
            }
            long lastSum = ans;
            while (true) {
                field = next(field);
                long sum = 0;
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        sum += field[i][j];
                    }
                }
                if (sum == lastSum) {
                    break;
                }
                lastSum = sum;
                ans += sum;
            }
            out.println("Case #" + testNumber + ": " + ans);
        }

        int[][] next(int[][] prev) {
            int[][] res = new int[prev.length][prev[0].length];
            int[][] sum = new int[prev.length][prev[0].length];
            int[][] nonZero = new int[prev.length][prev[0].length];
            for (int i = 0; i < prev.length; i++) {
                for (int j = 0; j < prev[i].length; j++) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (prev[k][j] > 0) {
                            sum[i][j] += prev[k][j];
                            nonZero[i][j]++;
                            break;
                        }
                    }
                    for (int k = i + 1; k < prev.length; k++) {
                        if (prev[k][j] > 0) {
                            sum[i][j] += prev[k][j];
                            nonZero[i][j]++;
                            break;
                        }
                    }
                    for (int k = j - 1; k >= 0; k--) {
                        if (prev[i][k] > 0) {
                            sum[i][j] += prev[i][k];
                            nonZero[i][j]++;
                            break;
                        }
                    }
                    for (int k = j + 1; k < prev[i].length; k++) {
                        if (prev[i][k] > 0) {
                            sum[i][j] += prev[i][k];
                            nonZero[i][j]++;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < prev.length; i++) {
                for (int j = 0; j < prev[i].length; j++) {
                    if (prev[i][j] * nonZero[i][j] >= sum[i][j]) {
                        res[i][j] = prev[i][j];
                    }
                }
            }
            return res;
        }

    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer stt;

        public InputReader(InputStream stream) {

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() {

            try {

                return reader.readLine();

            } catch (IOException e) {

                return null;

            }

        }

        public String next() {

            while (stt == null || !stt.hasMoreTokens()) {

                stt = new StringTokenizer(nextLine());

            }

            return stt.nextToken();

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

    }
}

