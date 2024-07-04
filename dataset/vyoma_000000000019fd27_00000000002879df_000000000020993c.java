import java.util.ArrayList;
import java.util.Scanner;

public class matrixReader {
    matrixReader() {
    _input = new Scanner(System.in);
}

    /**
     * returns the next matrix as an array
     */
    int[][] getMatrix() {
        int n = Integer.parseInt(_input.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] intRow = new int[n];
            String[] strRow = _input.nextLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                intRow[j] = Integer.parseInt(strRow[j]);
            }
            matrix[i] = intRow;
        }
        return matrix;
    }

    /**
     * computes the trace of the given array matrix
     */
    int computeTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    /**
     * computes the repeats in columns in the given
     * array matrix
     */
    int computeColRepeats(int[][] matrix, int n) {
        int cols = 0;
        for (int c = 0; c < n; c++) {
            ArrayList<Integer> col = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                if (col.contains(matrix[r][c])) {
                    cols++;
                    break;
                } else {
                    col.add(matrix[r][c]);
                }
            }
        }
        return cols;
    }

    /**
     * computes the repeats in rows in the given
     * array matrix
     */
    int computeRowRepeats(int[][] matrix, int n) {
        int rows = 0;
        for (int r = 0; r < n; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                if (row.contains(matrix[r][c])) {
                    rows++;
                    break;
                } else {
                    row.add(matrix[r][c]);
                }
            }
        }
        return rows;
    }

    void computeMatrix(int t) {
        int[][] matrix = getMatrix();
        int n = matrix.length;
        int trace = computeTrace(matrix, n);
        int colRepeats = computeColRepeats(matrix, n);
        int rowRepeats = computeRowRepeats(matrix, n);
        System.out.println("Case #" + t + ": " + trace
                + " " + rowRepeats + " " + colRepeats);
    }

    private Scanner _input;

    public static void main(String[] args) {
        matrixReader m = new matrixReader();
        int t = Integer.parseInt(m._input.nextLine());
        for (int i = 1; i <= t; i++) {
            m.computeMatrix(i);
        }
    }
}
