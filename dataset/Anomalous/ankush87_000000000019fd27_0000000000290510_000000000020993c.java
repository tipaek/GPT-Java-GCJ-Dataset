import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
        String[] answers = new String[numberOfTestCases];

        for (int testCaseInstance = 0; testCaseInstance < numberOfTestCases; testCaseInstance++) {
            int matrixSize = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] rowDuplicateCount = new int[matrixSize][matrixSize];
            int[][] columnDuplicateCount = new int[matrixSize][matrixSize];

            int diagonalSum = 0;
            int rowRepeatCount = 0;
            int columnRepeatCount = 0;

            for (int row = 0; row < matrixSize; row++) {
                String[] rowValues = bufferedReader.readLine().split(" ");
                for (int col = 0; col < matrixSize; col++) {
                    int value = Integer.parseInt(rowValues[col]);
                    matrix[row][col] = value;
                    rowDuplicateCount[row][value - 1]++;
                    columnDuplicateCount[col][value - 1]++;
                    if (row == col) {
                        diagonalSum += value;
                    }
                }
            }

            for (int row = 0; row < matrixSize; row++) {
                if (hasDuplicates(rowDuplicateCount[row])) {
                    rowRepeatCount++;
                }
            }

            for (int col = 0; col < matrixSize; col++) {
                if (hasDuplicates(getColumn(columnDuplicateCount, col))) {
                    columnRepeatCount++;
                }
            }

            answers[testCaseInstance] = diagonalSum + " " + rowRepeatCount + " " + columnRepeatCount;
        }

        for (int i = 0; i < numberOfTestCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + answers[i]);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        for (int count : array) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int col) {
        int[] column = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            column[row] = matrix[row][col];
        }
        return column;
    }
}