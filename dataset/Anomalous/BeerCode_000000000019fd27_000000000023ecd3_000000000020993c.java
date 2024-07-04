import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating trace (sum of diagonal elements)
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int targetSum = (n + 1) * n / 2;
            int rowViolations = 0, colViolations = 0;

            // Checking rows
            for (int i = 0; i < n; i++) {
                int rowSum = 0;
                boolean isValidRow = true;
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    rowSum += matrix[i][j];
                }
                if (rowSum != targetSum || rowSet.size() != n) {
                    rowViolations++;
                }
            }

            // Checking columns
            for (int j = 0; j < n; j++) {
                int colSum = 0;
                boolean isValidCol = true;
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    colSet.add(matrix[i][j]);
                    colSum += matrix[i][j];
                }
                if (colSum != targetSum || colSet.size() != n) {
                    colViolations++;
                }
            }

            // Output result for the current test case
            System.out.println("Case #" + t + ": " + trace + " " + rowViolations + " " + colViolations);
        }
    }
}