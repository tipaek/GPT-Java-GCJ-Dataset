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
            int sum = in.nextInt();
            int[][] resultMatrix = new int[n][n];

            if (generateMatrix(n, sum, 0, new int[n][n], resultMatrix)) {
                out.println("Case #" + testNumber + ": POSSIBLE");
                for (int[] row : resultMatrix) {
                    for (int val : row) {
                        out.print(val + " ");
                    }
                    out.println();
                }
            } else {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            }
        }

        private boolean generateMatrix(int n, int sum, int currentIndex, int[][] tempMatrix, int[][] resultMatrix) {
            if (currentIndex == n) {
                return sum == 0 && solvePuzzle(tempMatrix, n, 0, 0, resultMatrix);
            }

            for (int i = 1; i <= n; i++) {
                tempMatrix[currentIndex][currentIndex] = i;
                if (generateMatrix(n, sum - i, currentIndex + 1, tempMatrix, resultMatrix)) {
                    return true;
                }
                tempMatrix[currentIndex][currentIndex] = 0;
            }
            return false;
        }

        private boolean solvePuzzle(int[][] matrix, int n, int row, int col, int[][] resultMatrix) {
            if (row == n) return true;
            if (col == n) return solvePuzzle(matrix, n, row + 1, 0, resultMatrix);
            if (row == col) return solvePuzzle(matrix, n, row, col + 1, resultMatrix);

            for (int i = 1; i <= n; i++) {
                matrix[row][col] = i;
                if (isValidHorizontal(matrix, n, row) && isValidVertical(matrix, n, col)) {
                    if (solvePuzzle(matrix, n, row, col + 1, resultMatrix)) {
                        for (int r = 0; r < n; r++) {
                            System.arraycopy(matrix[r], 0, resultMatrix[r], 0, n);
                        }
                        return true;
                    }
                }
                matrix[row][col] = 0;
            }
            return false;
        }

        private boolean isValidHorizontal(int[][] matrix, int n, int row) {
            Set<Integer> seen = new HashSet<>();
            for (int val : matrix[row]) {
                if (val != 0 && !seen.add(val)) return false;
            }
            return true;
        }

        private boolean isValidVertical(int[][] matrix, int n, int col) {
            Set<Integer> seen = new HashSet<>();
            for (int[] row : matrix) {
                if (row[col] != 0 && !seen.add(row[col])) return false;
            }
            return true;
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