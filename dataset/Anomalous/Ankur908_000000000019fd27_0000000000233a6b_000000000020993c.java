import java.util.*;

public class CodeJam1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate trace and row/column duplicates
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDuplicate = false;
                boolean colDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicate = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colDuplicate = true;
                    }
                }

                if (rowDuplicate) {
                    rowCount++;
                }
                if (colDuplicate) {
                    colCount++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}