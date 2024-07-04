import java.util.Scanner;

public class Solution {

    public static long calculateProduct(int n) {
        long product = 1L;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0, rowIssues = 0, colIssues = 0;
            int expectedSum = (n * (n + 1)) / 2;
            long expectedProduct = calculateProduct(n);
            int[][] matrix = new int[n][n];

            // Fill the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check rows and columns
            for (int i = 0; i < n; i++) {
                int rowSum = 0, colSum = 0;
                long rowProduct = 1L, colProduct = 1L;
                for (int j = 0; j < n; j++) {
                    rowSum += matrix[i][j];
                    rowProduct *= matrix[i][j];
                    colSum += matrix[j][i];
                    colProduct *= matrix[j][i];
                }
                if (rowSum != expectedSum || rowProduct != expectedProduct) {
                    rowIssues++;
                }
                if (colSum != expectedSum || colProduct != expectedProduct) {
                    colIssues++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowIssues + " " + colIssues);
        }
    }
}