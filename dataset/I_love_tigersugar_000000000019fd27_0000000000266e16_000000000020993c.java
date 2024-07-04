import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Van Hanh Pham <skyvn97> <vanhanh.pham@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] arr = new int[n][];
            for (int i = 0; i < n; i++) arr[i] = IOUtils.readIntArray(in, n, 0);

            int trace = 0;
            for (int i = 0; i < n; i++) trace += arr[i][i];

            int numRow = 0, numCol = 0;
            for (int i = 0; i < n; i++) {
                boolean[] used = new boolean[n + 1];
                Arrays.fill(used, false);
                for (int j = 0; j < n; j++) {
                    if (used[arr[i][j]]) {
                        numRow++;
                        break;
                    }
                    used[arr[i][j]] = true;
                }

                Arrays.fill(used, false);
                for (int j = 0; j < n; j++) {
                    if (used[arr[j][i]]) {
                        numCol++;
                        break;
                    }
                    used[arr[j][i]] = true;
                }
            }

            out.printf("Case #%d: %d %d %d\n", testNumber, trace, numRow, numCol);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextString() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String next() {
            return nextString();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

    }

    static class IOUtils {
        public static int[] readIntArray(InputReader in, int size, int start) {
            int[] res = new int[start + size];
            for (int i = start; i < start + size; i++)
                res[i] = in.nextInt();
            return res;
        }

    }
}

