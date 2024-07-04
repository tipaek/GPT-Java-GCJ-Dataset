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
        for (int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Indicium {
        int[][] finalResult;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            boolean valid = generatePermutations(arr, 0, n, k, new boolean[n + 1]);

            if (!valid) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: POSSIBLE\n", testNumber);
                printMatrix(finalResult, out);
            }
        }

        boolean generatePermutations(int[] arr, int index, int n, int k, boolean[] used) {
            if (index == n) {
                int[][] latinSquare = createLatinSquare(arr);
                return findValidLatinSquare(latinSquare, new int[n], new boolean[n], 0, k);
            }

            for (int num = 1; num <= n; num++) {
                if (used[num]) continue;
                used[num] = true;
                arr[index] = num;
                if (generatePermutations(arr, index + 1, n, k, used)) return true;
                used[num] = false;
            }
            return false;
        }

        void printMatrix(int[][] matrix, PrintWriter out) {
            for (int[] row : matrix) {
                for (int value : row) {
                    out.printf("%d ", value);
                }
                out.println();
            }
        }

        int[][] createLatinSquare(int[] array) {
            int n = array.length;
            int[][] latinSquare = new int[n][n];
            latinSquare[0] = array.clone();
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    latinSquare[i][j] = array[(i + j) % n];
                }
            }
            return latinSquare;
        }

        boolean findValidLatinSquare(int[][] latinSquare, int[] index, boolean[] used, int row, int k) {
            if (row == latinSquare.length) {
                if (k == 0) {
                    finalResult = buildLatinSquare(latinSquare, index);
                    return true;
                }
                return false;
            }

            for (int i = 0; i < latinSquare.length; i++) {
                if (used[i]) continue;
                used[i] = true;
                index[row] = i;
                if (findValidLatinSquare(latinSquare, index, used, row + 1, k - latinSquare[i][row])) {
                    return true;
                }
                used[i] = false;
            }
            return false;
        }

        int[][] buildLatinSquare(int[][] latinSquare, int[] index) {
            int n = latinSquare.length;
            int[][] result = new int[n][n];
            for (int i = 0; i < n; i++) {
                result[i] = latinSquare[index[i]];
            }
            return result;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
}