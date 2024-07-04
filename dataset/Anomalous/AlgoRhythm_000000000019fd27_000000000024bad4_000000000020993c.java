import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            long trace = 0;
            int repeatedRows = 0, repeatedCols = 0;
            int[] rowSums = new int[matrixSize];
            int[] colSums = new int[matrixSize];
            int expectedSum = (matrixSize * (matrixSize + 1)) / 2;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    rowSums[row] += matrix[row][col];
                    colSums[col] += matrix[row][col];
                }
            }

            for (int index = 0; index < matrixSize; index++) {
                if (rowSums[index] != expectedSum) {
                    repeatedRows++;
                }
                if (colSums[index] != expectedSum) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + caseIndex + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}