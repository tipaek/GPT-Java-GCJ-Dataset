import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        String[] results = new String[numOfCases];

        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);
            int diagonalSum = calculateDiagonalSum(matrix, n);

            results[i] = "Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int row = 0; row < n; row++) {
            boolean[] seen = new boolean[n + 1];
            for (int col = 0; col < n; col++) {
                if (seen[matrix[row][col]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int col = 0; col < n; col++) {
            boolean[] seen = new boolean[n + 1];
            for (int row = 0; row < n; row++) {
                if (seen[matrix[row][col]]) {
                    duplicateCols++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return duplicateCols;
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int diagonalSum = 0;
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }
        return diagonalSum;
    }
}