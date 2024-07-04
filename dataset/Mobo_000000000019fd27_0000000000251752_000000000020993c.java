import java.util.Scanner;

public class Solution {

    private static class MatrixResult {
        int trace = 0;
        int nRepeatedRows = 0;
        int nRepeatedColumns = 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nProblems = in.nextInt();
        for (int problemNumber = 0; problemNumber < nProblems; problemNumber++) {
            int size = in.nextInt();
            int[][] matrixToBeSolved = new int[size][size];
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrixToBeSolved[row][col] = in.nextInt();
                }
            }

            MatrixResult result = solveMatrix(size, matrixToBeSolved);
            System.out
                .println("Case #" + (problemNumber + 1) + ": " + result.trace + " " + result.nRepeatedRows + " " + result.nRepeatedColumns);
        }
    }

    private static MatrixResult solveMatrix(int size, int[][] matrix) {
        MatrixResult result = new MatrixResult();

        for (int rowAndCol = 0; rowAndCol < size; rowAndCol++) {
            result.trace = result.trace + matrix[rowAndCol][rowAndCol];

            //check in row
            int duplicateInRow = 0;
            for (int col = 0; col < (size - 1); col++) {
                int fieldToBeChecked = matrix[rowAndCol][col];
                for (int colToBeChecked = 1; colToBeChecked < (size - col); colToBeChecked++) {
                    if (fieldToBeChecked == matrix[rowAndCol][col + colToBeChecked]) {
                        duplicateInRow = 1;
                        break;
                    }
                }
                if (duplicateInRow == 1) {
                    break;
                }
            }

            //check in col
            int duplicateInCol = 0;
            for (int row = 0; row < (size - 1); row++) {
                int fieldToBeChecked = matrix[row][rowAndCol];
                for (int rowToBeChecked = 1; rowToBeChecked < (size - row); rowToBeChecked++) {
                    if (fieldToBeChecked == matrix[row + rowToBeChecked][rowAndCol]) {
                        duplicateInCol = 1;
                        break;
                    }
                }
                if (duplicateInCol == 1) {
                    break;
                }
            }

            result.nRepeatedRows = result.nRepeatedRows + duplicateInRow;
            result.nRepeatedColumns = result.nRepeatedColumns + duplicateInCol;
        }

        return result;
    }
}
