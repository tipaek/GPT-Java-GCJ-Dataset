import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Vestigium solver = new Vestigium();

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        // t is number of testcases
        for(int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] arr = readIntArrays(in, n);
            boolean[][] row = new boolean[n][n+1], col = new boolean[n][n+1];
            int k = 0, r = 0, c = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {

                    if (i == j) k += arr[i][j];
                    int cur = arr[i][j];
                    if (row[i][cur] && !row[i][0]) {
                        r++;
                        row[i][0] = true;
                    }
                    if (col[j][cur] && !col[j][0]) {
                        c++;
                        col[j][0] = true;
                    }
                    row[i][cur] = true;
                    col[j][cur] = true;
                }
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, k, r, c);
        }

        int[][] readIntArrays(InputReader in, int n) {
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                arr[i] = in.readArray(n);
            }
            return arr;
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
        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readArray(int n) {
            int[] res = new int[n];
            for(int i = 0; i < n; i++) {
                res[i] = nextInt();
            }
            return res;
        }

    }
}
