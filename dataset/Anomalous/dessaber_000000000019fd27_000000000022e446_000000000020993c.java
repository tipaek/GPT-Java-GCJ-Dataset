import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class MatrixAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            // Read matrix and calculate diagonal sum
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int invalidRows = 0;
            for (int row = 0; row < size; row++) {
                if (!isValidRow(matrix, row)) {
                    invalidRows++;
                }
            }

            int invalidCols = 0;
            for (int col = 0; col < size; col++) {
                if (!isValidCol(matrix, col)) {
                    invalidCols++;
                }
            }

            System.out.println(diagonalSum + " " + invalidRows + " " + invalidCols);
        }
        scanner.close();
    }

    private static boolean isValidRow(int[][] matrix, int row) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int col = 0; col < matrix.length; col++) {
            if (!uniqueElements.add(matrix[row][col])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCol(int[][] matrix, int col) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            if (!uniqueElements.add(matrix[row][col])) {
                return false;
            }
        }
        return true;
    }
}