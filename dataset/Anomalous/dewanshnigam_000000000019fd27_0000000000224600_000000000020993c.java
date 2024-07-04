import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading matrix values
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculating trace
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Counting rows and columns with duplicate values
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();

                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }

                if (rowSet.size() != n) {
                    duplicateRows++;
                }
                if (colSet.size() != n) {
                    duplicateCols++;
                }
            }

            // Formatting the result for the current test case
            result.append("Case #").append(caseNumber).append(": ")
                  .append(trace).append(" ")
                  .append(duplicateRows).append(" ")
                  .append(duplicateCols).append("\n");

            caseNumber++;
        }

        // Printing the final result
        System.out.println(result);
    }
}