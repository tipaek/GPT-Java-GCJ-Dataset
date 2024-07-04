import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Fill the matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check rows and columns for duplicates and calculate diagonal sum
            for (int j = 0; j < size; j++) {
                if (hasDuplicates(matrix[j])) {
                    duplicateRows++;
                }

                int[] column = new int[size];
                for (int k = 0; k < size; k++) {
                    column[k] = matrix[k][j];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }

                diagonalSum += matrix[j][j];
            }

            // Print the result
            System.out.printf("Case #%d: %d %d %d%n", (i + 1), diagonalSum, duplicateRows, duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}