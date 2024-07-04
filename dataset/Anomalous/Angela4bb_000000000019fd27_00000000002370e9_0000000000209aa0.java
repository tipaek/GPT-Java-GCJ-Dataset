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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(), k = in.nextInt();
            int[][] matrix = new int[n][n];
            boolean isValid = fillMatrix(matrix, 0, k, n, new boolean[n][n], new boolean[n][n]);

            if (!isValid) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: POSSIBLE\n", testNumber);
                printMatrix(matrix, out);
            }
        }

        private void printMatrix(int[][] matrix, PrintWriter out) {
            for (int[] row : matrix) {
                for (int num : row) {
                    out.printf("%d ", num);
                }
                out.println();
            }
        }

        private boolean fillMatrix(int[][] matrix, int index, int remainingSum, int size, boolean[][] rowUsed, boolean[][] colUsed) {
            if (remainingSum == 0 && index == size) {
                return validateAndFill(matrix, 0, 0, rowUsed, colUsed);
            }
            if (index == size) return false;

            int start = Math.max(1, remainingSum - size * (size - index - 1));
            int end = Math.min(size, remainingSum - (size - index - 1));
            for (int num = start; num <= end; num++) {
                matrix[index][index] = num;
                rowUsed[index][num - 1] = true;
                colUsed[index][num - 1] = true;
                if (fillMatrix(matrix, index + 1, remainingSum - num, size, rowUsed, colUsed)) {
                    return true;
                }
                rowUsed[index][num - 1] = false;
                colUsed[index][num - 1] = false;
            }
            return false;
        }

        private boolean validateAndFill(int[][] matrix, int row, int col, boolean[][] rowUsed, boolean[][] colUsed) {
            if (row == col) col++;
            if (col == matrix.length) {
                row++;
                col = 0;
            }
            if (row == matrix.length) return true;

            for (int num = 1; num <= matrix.length; num++) {
                if (!rowUsed[row][num - 1] && !colUsed[col][num - 1]) {
                    rowUsed[row][num - 1] = true;
                    colUsed[col][num - 1] = true;
                    matrix[row][col] = num;
                    if (validateAndFill(matrix, row, col + 1, rowUsed, colUsed)) return true;
                    rowUsed[row][num - 1] = false;
                    colUsed[col][num - 1] = false;
                }
            }
            return false;
        }
    }

    static class Schedule {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] intervals = readIntervals(in, n);
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            char[] result = new char[n];
            Arrays.fill(result, 'C');

            int cEnd = intervals[0][1], jEnd = -1;
            boolean isValid = true;
            for (int i = 1; i < n; i++) {
                if (cEnd > intervals[i][0]) {
                    if (jEnd <= intervals[i][0]) {
                        jEnd = intervals[i][1];
                        result[intervals[i][2]] = 'J';
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    cEnd = intervals[i][1];
                }
            }

            if (!isValid) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: %s\n", testNumber, String.valueOf(result));
            }
        }

        private int[][] readIntervals(InputReader in, int n) {
            int[][] intervals = new int[n][3];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
                intervals[i][2] = i;
            }
            return intervals;
        }
    }

    static class NestingDepth {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char c : s.toCharArray()) {
                int num = c - '0';
                while (num < currentDepth) {
                    result.append(")");
                    currentDepth--;
                }
                while (num > currentDepth) {
                    result.append("(");
                    currentDepth++;
                }
                result.append(c);
            }
            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }
            out.printf("Case #%d: %s\n", testNumber, result.toString());
        }
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] matrix = readMatrix(in, n);
            boolean[][] rowUsed = new boolean[n][n + 1], colUsed = new boolean[n][n + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) trace += matrix[i][j];
                    int value = matrix[i][j];
                    if (rowUsed[i][value] && !rowUsed[i][0]) {
                        rowRepeats++;
                        rowUsed[i][0] = true;
                    }
                    if (colUsed[j][value] && !colUsed[j][0]) {
                        colRepeats++;
                        colUsed[j][0] = true;
                    }
                    rowUsed[i][value] = true;
                    colUsed[j][value] = true;
                }
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, trace, rowRepeats, colRepeats);
        }

        private int[][] readMatrix(InputReader in, int n) {
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = in.readArray(n);
            }
            return matrix;
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

        public int[] readArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }
    }
}