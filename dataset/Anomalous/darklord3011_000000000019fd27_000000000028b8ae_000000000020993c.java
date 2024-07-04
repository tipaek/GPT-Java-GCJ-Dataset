import java.util.Scanner;
import java.util.HashSet;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int rowCount = 0;
            int colCount = 0;
            int trace = 0;

            // Calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }
                }
                if (rowDuplicate) {
                    rowCount++;
                }
                trace += matrix[i][i];
            }

            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicate = true;
                    }
                }
                if (colDuplicate) {
                    colCount++;
                }
            }

            // Output the results for the current test case
            System.out.println("Case #" + (t + 1) + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}