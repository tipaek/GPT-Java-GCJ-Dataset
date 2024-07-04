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

            int rowDuplicates = 0;
            int colDuplicates = 0;

            // Check for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    rowDuplicates++;
                }
            }

            // Check for duplicate elements in columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicates = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicates = true;
                        break;
                    }
                }
                if (hasDuplicates) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}