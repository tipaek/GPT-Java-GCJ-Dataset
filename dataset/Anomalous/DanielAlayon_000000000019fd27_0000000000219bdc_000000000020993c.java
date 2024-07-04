import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long caseCount = scanner.nextLong();

        for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
            int matrixSize = scanner.nextInt();
            long[][] matrix = new long[matrixSize][matrixSize];

            // Fill the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextLong();
                }
            }

            long diagonalSum = 0;
            long rowDuplicates = 0;
            long colDuplicates = 0;

            for (int index = 0; index < matrixSize; index++) {
                if (hasDuplicates(matrix[index])) {
                    rowDuplicates++;
                }

                long[] column = new long[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    column[row] = matrix[row][index];
                }

                if (hasDuplicates(column)) {
                    colDuplicates++;
                }

                diagonalSum += matrix[index][index];
            }

            // Print the result for the current case
            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static boolean hasDuplicates(long[] array) {
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