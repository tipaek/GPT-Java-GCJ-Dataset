import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Indicium solver = new Indicium();
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        // Number of test cases
        for (int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Indicium {
        int[][] finalResult;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), k = in.nextInt();
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
                int[][] latinSquare = initializeLatinSquare(arr);
                return generateLatinSquarePermutations(latinSquare, new int[n], new boolean[n], 0, k);
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

        int[][] initializeLatinSquare(int[] arr) {
            int n = arr.length;
            int[][] square = new int[n][n];
            square[0] = arr.clone();
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = arr[(i + j) % n];
                }
            }
            return square;
        }

        boolean generateLatinSquarePermutations(int[][] latinSquare, int[] indices, boolean[] used, int row, int k) {
            int n = latinSquare.length;
            if (row == n) {
                if (k == 0) {
                    finalResult = createLatinSquare(latinSquare, indices);
                    return true;
                }
                return false;
            }
            if (k < (n - row) || k > n * (n - row)) return false;

            for (int i = 0; i < n; i++) {
                if (used[i]) continue;
                used[i] = true;
                indices[row] = i;
                if (generateLatinSquarePermutations(latinSquare, indices, used, row + 1, k - latinSquare[i][row])) {
                    return true;
                }
                used[i] = false;
            }
            return false;
        }

        int[][] createLatinSquare(int[][] latinSquare, int[] indices) {
            int n = latinSquare.length;
            int[][] result = new int[n][n];
            for (int i = 0; i < n; i++) {
                result[i] = latinSquare[indices[i]].clone();
            }
            return result;
        }

        void printMatrix(int[][] matrix, PrintWriter out) {
            for (int[] row : matrix) {
                for (int num : row) {
                    out.printf("%d ", num);
                }
                out.println();
            }
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

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