import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowIssues = 0;
            int colIssues = 0;

            // Fill the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int expectedXor = 0;
            for (int i = 1; i <= n; i++) {
                expectedXor ^= i;
            }

            // Check each row for issues
            for (int i = 0; i < n; i++) {
                int rowXor = 0;
                for (int j = 0; j < n; j++) {
                    rowXor ^= matrix[i][j];
                }
                if (rowXor != expectedXor) {
                    rowIssues++;
                }
            }

            // Check each column for issues
            for (int i = 0; i < n; i++) {
                int colXor = 0;
                for (int j = 0; j < n; j++) {
                    colXor ^= matrix[j][i];
                }
                if (colXor != expectedXor) {
                    colIssues++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowIssues + " " + colIssues);
            caseNumber++;
        }

        scanner.close();
    }
}