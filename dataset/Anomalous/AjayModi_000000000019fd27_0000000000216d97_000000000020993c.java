import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicate = true;
                        break;
                    }
                }
                if (rowHasDuplicate) {
                    rowRepeats++;
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colHasDuplicate = true;
                        break;
                    }
                }
                if (colHasDuplicate) {
                    colRepeats++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}