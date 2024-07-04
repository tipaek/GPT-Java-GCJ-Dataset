import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                    }
                }
                if (rowHasDuplicate) {
                    rowDuplicates++;
                }
            }

            // Check for column duplicates
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                    }
                }
                if (colHasDuplicate) {
                    colDuplicates++;
                }
            }

            // Print result for the current test case
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, colDuplicates);
        }
        scanner.close();
    }
}