import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] matrix;

    public static int countDuplicateRows() {
        int duplicateRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean rowHasDuplicates = false;
            for (int j = 0; j < matrix.length && !rowHasDuplicates; j++) {
                for (int k = 0; k < j; k++) {
                    if (matrix[i][j] == matrix[i][k]) {
                        rowHasDuplicates = true;
                        duplicateRows++;
                        break;
                    }
                }
            }
        }
        return duplicateRows;
    }

    public static int countDuplicateCols() {
        int duplicateCols = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean colHasDuplicates = false;
            for (int j = 0; j < matrix.length && !colHasDuplicates; j++) {
                for (int k = 0; k < j; k++) {
                    if (matrix[j][i] == matrix[k][i]) {
                        colHasDuplicates = true;
                        duplicateCols++;
                        break;
                    }
                }
            }
        }
        return duplicateCols;
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0;
            matrix = new int[n][n];

            // Fill the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = countDuplicateRows();
            int duplicateCols = countDuplicateCols();

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}