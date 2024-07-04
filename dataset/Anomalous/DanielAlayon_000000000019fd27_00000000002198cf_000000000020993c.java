import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long cases = scanner.nextLong();

        for (int i = 0; i < cases; i++) {
            int size = scanner.nextInt();
            long[][] matrix = new long[size][size];
            long diagonalSum = 0;
            long rowDuplicates = 0;
            long columnDuplicates = 0;

            // Fill matrix
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextLong();
                }
            }

            // Check for duplicates and calculate diagonal sum
            for (int j = 0; j < size; j++) {
                if (hasDuplicates(matrix[j])) {
                    rowDuplicates++;
                }

                long[] column = new long[size];
                for (int k = 0; k < size; k++) {
                    column[k] = matrix[k][j];
                }

                if (hasDuplicates(column)) {
                    columnDuplicates++;
                }

                diagonalSum += matrix[j][j];
            }

            // Print result
            System.out.println("Case #" + (i + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
    }

    private static boolean hasDuplicates(long[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}