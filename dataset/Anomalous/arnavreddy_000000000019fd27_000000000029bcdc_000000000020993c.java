import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }

            System.out.println("Case #" + i + ": " + calculateTrace(matrix, n) + " " + countDuplicateRows(matrix, n) + " " + countDuplicateColumns(matrix, n));
        }
    }

    private static long calculateTrace(int[][] matrix, int size) {
        long trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int rowCount = 0;

        for (int r = 0; r < size; r++) {
            boolean[] seen = new boolean[size + 1];
            for (int c = 0; c < size; c++) {
                if (seen[matrix[r][c]]) {
                    rowCount++;
                    break;
                }
                seen[matrix[r][c]] = true;
            }
        }

        return rowCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int colCount = 0;

        for (int c = 0; c < size; c++) {
            boolean[] seen = new boolean[size + 1];
            for (int r = 0; r < size; r++) {
                if (seen[matrix[r][c]]) {
                    colCount++;
                    break;
                }
                seen[matrix[r][c]] = true;
            }
        }

        return colCount;
    }
}