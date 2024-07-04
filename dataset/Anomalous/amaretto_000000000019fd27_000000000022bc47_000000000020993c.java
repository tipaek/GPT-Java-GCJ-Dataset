import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Checking for duplicate elements in rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateRows++;
                }
            }

            // Checking for duplicate elements in columns
            for (int i = 0; i < n; i++) {
                HashSet<Integer> columnSet = new HashSet<>();
                boolean hasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        hasDuplicate = true;
                        break;
                    }
                }
                if (hasDuplicate) {
                    duplicateColumns++;
                }
            }

            System.out.println("Case #" + test + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }

        scanner.close();
    }
}