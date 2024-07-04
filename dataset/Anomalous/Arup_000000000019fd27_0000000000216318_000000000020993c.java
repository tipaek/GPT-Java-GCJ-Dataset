import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numberOfCases = stdin.nextInt();

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int matrixSize = stdin.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read in the matrix.
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = stdin.nextInt();
                }
            }

            // Calculate the trace of the matrix.
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrix[i][i];
            }

            // Count rows with repeated elements.
            int rowsWithRepeats = 0;
            for (int row = 0; row < matrixSize; row++) {
                if (hasRepeats(matrix[row])) {
                    rowsWithRepeats++;
                }
            }

            // Count columns with repeated elements.
            int colsWithRepeats = 0;
            for (int col = 0; col < matrixSize; col++) {
                int[] column = new int[matrixSize];
                for (int row = 0; row < matrixSize; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasRepeats(column)) {
                    colsWithRepeats++;
                }
            }

            // Output the result for the current case.
            System.out.println("Case #" + caseIndex + ": " + trace + " " + rowsWithRepeats + " " + colsWithRepeats);
        }
    }

    private static boolean hasRepeats(int[] array) {
        int length = array.length;
        int[] frequency = new int[length];
        for (int value : array) {
            frequency[value - 1]++;
            if (frequency[value - 1] > 1) {
                return true;
            }
        }
        return false;
    }
}