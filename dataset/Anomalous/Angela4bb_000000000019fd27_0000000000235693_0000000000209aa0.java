import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Indicium solver = new Indicium();
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] matrix = new int[n][n];
            if (generateMatrix(matrix, 0, k, n)) {
                out.printf("Case #%d: POSSIBLE\n", testNumber);
                printMatrix(matrix, out);
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            }
        }

        private boolean generateMatrix(int[][] matrix, int index, int remainingSum, int size) {
            if (remainingSum == 0 && index == size) {
                return isValidMatrix(matrix, size);
            }
            if (remainingSum == 0 || index == size) return false;

            for (int num = 1; num <= size; num++) {
                matrix[index][index] = num;
                if (generateMatrix(matrix, index + 1, remainingSum - num, size)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isValidMatrix(int[][] matrix, int size) {
            boolean[][] rowCheck = new boolean[size][size];
            boolean[][] colCheck = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                rowCheck[i][matrix[i][i] - 1] = true;
                colCheck[i][matrix[i][i] - 1] = true;
            }

            return fillMatrix(matrix, 0, 0, rowCheck, colCheck);
        }

        private boolean fillMatrix(int[][] matrix, int row, int col, boolean[][] rowCheck, boolean[][] colCheck) {
            if (row == col) col++;
            if (col == matrix.length) {
                row++;
                col = 0;
            }
            if (row == matrix.length) return true;

            for (int num = 1; num <= matrix.length; num++) {
                if (!rowCheck[row][num - 1] && !colCheck[col][num - 1]) {
                    rowCheck[row][num - 1] = true;
                    colCheck[col][num - 1] = true;
                    matrix[row][col] = num;
                    if (fillMatrix(matrix, row, col + 1, rowCheck, colCheck)) return true;
                    rowCheck[row][num - 1] = false;
                    colCheck[col][num - 1] = false;
                }
            }
            return false;
        }

        private void printMatrix(int[][] matrix, PrintWriter out) {
            for (int[] row : matrix) {
                for (int num : row) {
                    out.printf("%d ", num);
                }
                out.println();
            }
        }
    }

    static class Schedule {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] intervals = readIntervals(in, n);
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            char[] result = new char[n];
            Arrays.fill(result, 'C');

            int cEnd = intervals[0][1];
            int jEnd = -1;
            boolean possible = true;

            for (int i = 1; i < n; i++) {
                if (cEnd > intervals[i][0]) {
                    if (jEnd <= intervals[i][0]) {
                        jEnd = intervals[i][1];
                        result[intervals[i][2]] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    cEnd = intervals[i][1];
                }
            }

            if (!possible) {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            } else {
                out.printf("Case #%d: %s\n", testNumber, new String(result));
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
                while (num > currentDepth) {
                    result.append('(');
                    currentDepth++;
                }
                while (num < currentDepth) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(c);
            }
            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            out.printf("Case #%d: %s\n", testNumber, result.toString());
        }
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] matrix = readMatrix(in, n);
            boolean[][] rowCheck = new boolean[n][n + 1];
            boolean[][] colCheck = new boolean[n][n + 1];

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = matrix[i][j];
                    if (i == j) trace += value;
                    if (rowCheck[i][value]) rowRepeats++;
                    if (colCheck[j][value]) colRepeats++;
                    rowCheck[i][value] = true;
                    colCheck[j][value] = true;
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
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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