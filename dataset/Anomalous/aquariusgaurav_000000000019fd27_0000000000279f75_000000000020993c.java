import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Calculating trace and checking rows and columns for duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    // Trace calculation
                    if (i == j) {
                        trace += matrix[i][j];
                    }

                    // Check for duplicates in row
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }

                    // Check for duplicates in column
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicate = true;
                    }
                }

                if (rowDuplicate) {
                    duplicateRows++;
                }
                if (colDuplicate) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}