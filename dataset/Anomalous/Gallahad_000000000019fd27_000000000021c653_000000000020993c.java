import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowDup = false;
                boolean colDup = false;

                for (int j = 0; j < n; j++) {
                    if (!rowDup && !rowSet.add(matrix[i][j])) {
                        duplicateRows++;
                        rowDup = true;
                    }
                    if (!colDup && !colSet.add(matrix[j][i])) {
                        duplicateCols++;
                        colDup = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}