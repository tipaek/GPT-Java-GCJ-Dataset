import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int test = 1; test <= numTests; test++) {
            int matrixSize = in.nextInt();
            int [][] matrix = new int[matrixSize][matrixSize];

            // Populate Matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int trace = getMatrixTrace(matrix);
            int latinSquareRow = getLatinSquareRows(matrix, true);
            int latinSquareColumn = getLatinSquareRows(matrix, false);
            System.out.printf("Case #%s: %s %s %s", test, trace, latinSquareRow, latinSquareColumn);
            System.out.println();
        }
    }

    public static int getMatrixTrace(int[][] matrix) {
        int trace = 0;
        for (int index = 0; index < matrix.length; index++)
            trace += matrix[index][index];

        return trace;
    }

    public static int getLatinSquareRows(int[][] matrix, boolean isRow) {
        HashSet<Integer> rowMapping = new HashSet<>();
        int latinRows = 0;
        for (int row = 0; row < matrix.length; row++) {
            rowMapping.clear();
            for (int col = 0; col < matrix.length; col++) {
                int val;
                if (isRow)
                    val = matrix[row][col];
                else
                    val = matrix[col][row];

                if (!rowMapping.contains(val))
                    rowMapping.add(val);
                else {
                    latinRows++;
                    break;
                }
            }
        }
        return latinRows;
    }
}