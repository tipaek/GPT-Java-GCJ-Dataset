import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int T = scanner.nextInt();
        int caseNumber = 0;
        while (caseNumber++ < T) {
            final int N = scanner.nextInt();

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            MatrixData data = compute(matrix);

            System.out.println(
                    String.format(
                            "Case #%d: %d %d %d", caseNumber, data.trace, data.repRows, data.repCols
                    )
            );
        }
    }

    private static MatrixData compute(int[][] matrix) {
        int trace = trace(matrix);
        int repRows = rows(matrix);
        int repCols = cols(matrix);

        return new MatrixData(trace, repRows, repCols);
    }

    private static int rows(int[][] matrix) {
        int rows = 0;
        for (int r = 0; r < matrix.length; r++) {
            Set<Integer> vals = new HashSet<>();
            for (int c = 0; c < matrix[0].length; c++) {
                if (vals.contains(matrix[r][c])) {
                    ++rows;
                    break;
                }
                vals.add(matrix[r][c]);
            }
        }
        return rows;
    }

    private static int cols(int[][] matrix) {
        int cols = 0;
        for (int c = 0; c < matrix[0].length; c++) {
            Set<Integer> vals = new HashSet<>();
            for (int r = 0; r < matrix.length; r++) {
                if (vals.contains(matrix[r][c])) {
                    ++cols;
                    break;
                }
                vals.add(matrix[r][c]);
            }
        }
        return cols;
    }

    private static int trace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static class MatrixData {
        int trace;
        int repRows;
        int repCols;

        public MatrixData(int trace, int repRows, int repCols) {
            this.trace = trace;
            this.repRows = repRows;
            this.repCols = repCols;
        }
    }
}
