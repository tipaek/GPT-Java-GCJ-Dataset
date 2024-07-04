import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int targetSum = in.nextInt();
            int[][] resultMatrix = new int[n][n];

            if (generateMatrix(n, targetSum, 0, new int[n][n], resultMatrix)) {
                out.println("Case #" + testNumber + ": POSSIBLE");
                for (int[] row : resultMatrix) {
                    for (int value : row) {
                        out.print(value + " ");
                    }
                    out.println();
                }
            } else {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            }
        }

        private boolean generateMatrix(int n, int sum, int row, int[][] currentMatrix, int[][] resultMatrix) {
            if (row == n) {
                if (sum == 0) {
                    return solvePuzzle(currentMatrix, n, 0, 0, resultMatrix);
                }
                return false;
            }

            for (int i = 1; i <= n; i++) {
                currentMatrix[row][row] = i;
                if (generateMatrix(n, sum - i, row + 1, currentMatrix, resultMatrix)) {
                    return true;
                }
                currentMatrix[row][row] = 0;
            }

            return false;
        }

        private boolean solvePuzzle(int[][] matrix, int n, int row, int col, int[][] resultMatrix) {
            if (row == n) return true;
            if (col == n) return solvePuzzle(matrix, n, row + 1, 0, resultMatrix);
            if (row == col) return solvePuzzle(matrix, n, row, col + 1, resultMatrix);

            for (int i = 1; i <= n; i++) {
                matrix[row][col] = i;
                if (isValidRow(matrix, n, row) && isValidColumn(matrix, n, col)) {
                    if (solvePuzzle(matrix, n, row, col + 1, resultMatrix)) {
                        copyMatrix(matrix, resultMatrix, n);
                        return true;
                    }
                }
                matrix[row][col] = 0;
            }

            return false;
        }

        private boolean isValidRow(int[][] matrix, int n, int row) {
            Set<Integer> seen = new HashSet<>();
            for (int value : matrix[row]) {
                if (value != 0 && !seen.add(value)) return false;
            }
            return true;
        }

        private boolean isValidColumn(int[][] matrix, int n, int col) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (matrix[i][col] != 0 && !seen.add(matrix[i][col])) return false;
            }
            return true;
        }

        private void copyMatrix(int[][] source, int[][] destination, int n) {
            for (int i = 0; i < n; i++) {
                System.arraycopy(source[i], 0, destination[i], 0, n);
            }
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