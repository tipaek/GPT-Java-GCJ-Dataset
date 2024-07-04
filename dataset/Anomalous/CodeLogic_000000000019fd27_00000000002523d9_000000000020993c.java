import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, maxRowDuplicates = 0, maxColDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Calculate maximum row duplicates
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                int rowDuplicates = 0;
                for (int j = 0; j < n; j++) {
                    rowMap.put(matrix[i][j], rowMap.getOrDefault(matrix[i][j], 0) + 1);
                }
                for (int count : rowMap.values()) {
                    if (count > 1) {
                        rowDuplicates += count;
                    }
                }
                maxRowDuplicates = Math.max(maxRowDuplicates, rowDuplicates);
            }

            // Calculate maximum column duplicates
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                int colDuplicates = 0;
                for (int j = 0; j < n; j++) {
                    colMap.put(matrix[j][i], colMap.getOrDefault(matrix[j][i], 0) + 1);
                }
                for (int count : colMap.values()) {
                    if (count > 1) {
                        colDuplicates += count;
                    }
                }
                maxColDuplicates = Math.max(maxColDuplicates, colDuplicates);
            }

            result.append("Case #").append(caseNum).append(": ")
                  .append(trace).append(" ")
                  .append(maxRowDuplicates).append(" ")
                  .append(maxColDuplicates).append("\n");
        }

        System.out.println(result.toString());
        scanner.close();
    }
}