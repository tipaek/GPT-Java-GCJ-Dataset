import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Indicium solver = new Indicium();

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

    static class Indicium {
        int[][] final_res;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), k = in.nextInt();
            int[] arr = new int[n];
            boolean valid = permute(arr, 0, n, k, new boolean[n + 1]);

            if (!valid) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: POSSIBLE\n", testNumber);
                printArray(final_res, out);
            }
        }

        void deepPrint(int[][] arr) {
            System.out.println("printing new ");
            for(int[] a : arr) {
                System.out.println(Arrays.toString(a));
            }
        }

        boolean permute(int[] arr, int i, int n, int k, boolean[] used) {
            if (i == n) {
                // finished permute
                int[][] ls = initLatinSquare(arr);
                if (permuteLatinSquare(ls, new int[n], new boolean[n], 0, k)) {
                    return true;
                }
                return false;
            }

            for(int num = 1; num <= n; num++) {
                if (used[num]) continue;
                used[num] = true;
                arr[i] = num;
                if(permute(arr, i + 1, n, k, used)) return true;
                used[num] = false;
            }
            return false;
        }

        void printArray(int[][] arr, PrintWriter out) {
            for(int[] a : arr) {
                for(int n : a) {
                    out.printf("%d ", n);
                }
                out.print("\n");
            }
        }
        int[][] initLatinSquare(int[] a) {
            int n = a.length;
            int[][] res = new int[n][n];
            res[0] = a;
            for(int i = 1; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int idx = (i + j) % n;
                    res[i][j] = a[idx];
                }
            }
            return res;
        }

        boolean permuteLatinSquare(int[][] ls, int[] index, boolean[] used, int r, int k) {
            if (r == ls.length) {
                if (k == 0) {
                    final_res = generateLatinSquare(ls, index);
                    return true;
                }
                return false;
            }
            //if (k < (ls.length - r) || k > ls.length*(ls.length-r)) return false;

            for(int i = 0; i < ls.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                index[r] = i;
                if (permuteLatinSquare(ls, index, used, r + 1, k - ls[i][r])) {
                    return true;
                }
                used[i] = false;
            }
            return false;
        }

        int[][] generateLatinSquare(int[][] ls, int[] index) {
            int n = ls.length;
            int[][] res = new int[n][n];
            for(int i = 0; i < n; i++) {
                res[i] = ls[index[i]];
            }
            return res;
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
