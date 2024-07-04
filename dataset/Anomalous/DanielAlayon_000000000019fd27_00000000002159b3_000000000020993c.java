import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;

            // Fill the matrix
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            // Check for duplicates in rows and columns
            for (int row = 0; row < n; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
                int[] column = new int[n];
                for (int col = 0; col < n; col++) {
                    column[col] = matrix[col][row];
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }

            // Calculate the sum of the diagonal
            for (int j = 0; j < n; j++) {
                diagonalSum += matrix[j][j];
            }

            // Print the result
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
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