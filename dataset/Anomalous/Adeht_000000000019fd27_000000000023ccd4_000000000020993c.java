import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowCount = 0, columnCount = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    rowCount++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    columnSet.add(matrix[i][j]);
                }
                if (columnSet.size() < n) {
                    columnCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + columnCount);
        }

        sc.close();
    }
}