import java.util.Scanner;

public class Solution {

    public static long computeProduct(int n) {
        long product = 1L;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int diagonalSum = 0, invalidRows = 0, invalidColumns = 0;
            int expectedSum = (n * (n + 1)) / 2;
            long expectedProduct = computeProduct(n);
            int[][] matrix = new int[n][n];

            // Reading matrix and calculating diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            // Checking rows and columns
            for (int i = 0; i < n; i++) {
                int rowSum = 0, columnSum = 0;
                long rowProduct = 1L, columnProduct = 1L;
                for (int j = 0; j < n; j++) {
                    rowSum += matrix[i][j];
                    rowProduct *= matrix[i][j];
                    columnSum += matrix[j][i];
                    columnProduct *= matrix[j][i];
                }
                if (rowSum != expectedSum || rowProduct != expectedProduct) {
                    invalidRows++;
                }
                if (columnSum != expectedSum || columnProduct != expectedProduct) {
                    invalidColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, diagonalSum, invalidRows, invalidColumns);
        }

        scanner.close();
    }
}