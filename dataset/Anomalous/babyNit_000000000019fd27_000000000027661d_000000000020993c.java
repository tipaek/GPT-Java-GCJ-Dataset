import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            find(matrix);
        }
    }

    private static void find(int[][] matrix) {
        int n = matrix.length;
        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateColumns = 0;

        // Calculate the sum of the main diagonal
        for (int i = 0; i < n; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateRows++;
            }
        }

        // Check for duplicate values in columns
        for (int j = 0; j < n; j++) {
            Set<Integer> columnSet = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < n; i++) {
                if (!columnSet.add(matrix[i][j])) {
                    hasDuplicate = true;
                }
            }
            if (hasDuplicate) {
                duplicateColumns++;
            }
        }

        // Print the results
        System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateColumns);
    }
}