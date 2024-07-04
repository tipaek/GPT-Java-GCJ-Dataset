import java.util.Scanner;

class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long numberOfCases = sc.nextLong();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int matrixSize = sc.nextInt();
            long[][] matrix = new long[matrixSize][matrixSize];

            // Fill the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = sc.nextLong();
                }
            }

            long diagonalSum = 0;
            long duplicateRows = 0;
            long duplicateCols = 0;

            for (int i = 0; i < matrixSize; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
                long[] column = new long[matrixSize];
                for (int j = 0; j < matrixSize; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            // Sum the main diagonal
            for (int i = 0; i < matrixSize; i++) {
                diagonalSum += matrix[i][i];
            }

            // Print the result
            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
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