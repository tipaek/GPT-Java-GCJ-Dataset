//package codejam.y2020.qualification;

import java.util.Scanner;

public class Solution {
    class Output {
        int trace;
        int repeatedRows;
        int repeatedColumns;

        public Output(int trace, int repeatedRows, int repeatedColumns) {
            this.trace = trace;
            this.repeatedRows = repeatedRows;
            this.repeatedColumns = repeatedColumns;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            Output output = solution.printTraceAndComputeRepeated(N, matrix);
            System.out.println("Case #" + i + ": " + output.trace + " " + output.repeatedRows + " " + output.repeatedColumns);
        }
    }

    private Output printTraceAndComputeRepeated(int N, int[][] matrix) {
        int repeatedRows = 0;
        int repeatedColumns = 0;
        int trace = computeTrace(N, matrix);

        boolean[][] rowExists = new boolean[N][N + 1];
        boolean[][] colExists = new boolean[N][N + 1];
        boolean[] isRepeatRow = new boolean[N];
        boolean[] isRepeatCol = new boolean[N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int value = matrix[row][col];
                if (!isRepeatRow[row]) {
                    if (rowExists[row][value]) {
                        isRepeatRow[row] = true;
                        repeatedRows++;
                    } else {
                        rowExists[row][value] = true;
                    }
                }
                if (!isRepeatCol[col]) {
                    if (colExists[col][value]) {
                        isRepeatCol[col] = true;
                        repeatedColumns++;
                    } else {
                        colExists[col][value] = true;
                    }
                }
            }
        }
        return new Output(trace, repeatedRows, repeatedColumns);

    }

    private int computeTrace(int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
}
