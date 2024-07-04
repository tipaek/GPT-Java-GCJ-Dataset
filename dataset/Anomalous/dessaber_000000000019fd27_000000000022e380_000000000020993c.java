import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            
            // Read matrix and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int invalidRows = 0;
            int invalidCols = 0;

            // Check rows for duplicates
            for (int i = 0; i < n; i++) {
                if (!isUnique(matrix[i])) {
                    invalidRows++;
                }
            }

            // Check columns for duplicates
            for (int i = 0; i < n; i++) {
                if (!isUnique(getColumn(matrix, i))) {
                    invalidCols++;
                }
            }

            System.out.println(diagonalSum + " " + invalidRows + " " + invalidCols);
        }
    }

    // Helper method to check if an array has all unique elements
    private static boolean isUnique(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

    // Helper method to extract a column from a 2D array
    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}