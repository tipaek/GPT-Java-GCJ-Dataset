import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating the trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Counting rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowElements.add(matrix[i][j]);
                }
                if (rowElements.size() != n) {
                    duplicateRows++;
                }
            }

            // Counting columns with duplicate elements
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> columnElements = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    columnElements.add(matrix[j][i]);
                }
                if (columnElements.size() != n) {
                    duplicateColumns++;
                }
            }

            // Printing the result for the current test case
            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}