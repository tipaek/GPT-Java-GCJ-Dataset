import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int sum = 0, rowDuplicates = 0, colDuplicates = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                sum += matrix[i][i];
            }

            // Check for row duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() < n) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    colSet.add(matrix[j][i]);
                }
                if (colSet.size() < n) {
                    colDuplicates++;
                }
            }

            // Print the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", testCase, sum, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }
}