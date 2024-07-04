import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read matrix and calculate trace and duplicate rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicateRow = false;
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();
                    if (rowSet.contains(value)) {
                        hasDuplicateRow = true;
                    }
                    matrix[i][j] = value;
                    rowSet.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                if (hasDuplicateRow) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicateCol = false;
                for (int i = 0; i < n; i++) {
                    int value = matrix[i][j];
                    if (colSet.contains(value)) {
                        hasDuplicateCol = true;
                    }
                    colSet.add(value);
                }
                if (hasDuplicateCol) {
                    duplicateCols++;
                }
            }

            // Output the result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, duplicateRows, duplicateCols);
        }
        scanner.close();
    }
}