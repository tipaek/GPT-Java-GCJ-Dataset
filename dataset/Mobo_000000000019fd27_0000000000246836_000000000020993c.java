package com.gcj2020.vestigium;

public class Vestigium {

    private static class MatrixResult {
        int trace = 0;
        int nRepeatedRows = 0;
        int nRepeatedColumns = 0;
    }

    public void solve(int[][] input) {
        int nProblems = input[0][0];
        int previousSizes = 0;
        for (int problemNumber = 0; problemNumber < nProblems; problemNumber++) {
            int size = input[1 + problemNumber + previousSizes][0];

            //construct matrix to be solved
            int[][] matrixToBeSolved = new int[size][size];
            for (int row = 0; row < size; row++) {
                matrixToBeSolved[row] = input[1 + problemNumber + previousSizes + 1 + row];
            }

            previousSizes = previousSizes + size;

            MatrixResult result = solveMatrix(size, matrixToBeSolved);
            System.out
                .println("Case #" + (problemNumber + 1) + ": " + result.trace + " " + result.nRepeatedRows + " " + result.nRepeatedColumns);
        }
    }

    private MatrixResult solveMatrix(int size, int[][] matrix) {
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
