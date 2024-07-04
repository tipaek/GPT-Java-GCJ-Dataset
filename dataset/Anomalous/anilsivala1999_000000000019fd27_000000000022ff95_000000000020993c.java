import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int expectedSum = (n * (n + 1)) / 2;
            int trace = 0, rowIssues = 0, colIssues = 0;

            // Reading the matrix and calculating the trace and row sums
            for (int row = 0; row < n; row++) {
                int rowSum = 0;
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    rowSum += matrix[row][col];
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
                if (rowSum != expectedSum) {
                    rowIssues++;
                }
            }

            // Calculating the column sums
            for (int col = 0; col < n; col++) {
                int colSum = 0;
                for (int row = 0; row < n; row++) {
                    colSum += matrix[row][col];
                }
                if (colSum != expectedSum) {
                    colIssues++;
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + rowIssues + " " + colIssues);
        }

        scanner.close();
    }
}