import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            long diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Process the matrix
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowSet.size() < n) {
                    duplicateRows++;
                }
                if (colSet.size() < n) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}