import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int x = 1; x <= t; x++) {
            int trace = 0;
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            // Read matrix and calculate trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int repeatedRows = 0;
            int repeatedCols = 0;

            // Check for repeated rows
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    repeatedRows++;
                }
            }

            // Check for repeated columns
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }
}