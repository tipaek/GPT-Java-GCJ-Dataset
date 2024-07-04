import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            SquareMatrix squareMatrix = new SquareMatrix(matrixSize, matrix);
            squareMatrix.getCount();
            int trace = squareMatrix.calculateDiagonal();
            System.out.println("Case #" + (t+1) + ": " + trace + " " + squareMatrix.rowCount + " " + squareMatrix.columnCount);
        }
    }


    public static class SquareMatrix {
        private int matrixSize;
        private int[][] matrixValues;
        public int rowCount = 0;
        public int columnCount = 0;

        public SquareMatrix(int number, int[][] matrix) {
            this.matrixSize = number;
            this.matrixValues = matrix;
        }

        public int calculateDiagonal() {
            // diagonal elements are where i = j;
            int trace = 0;
            for (int i = 0; i < matrixSize; i++) {
                trace += matrixValues[i][i];
            }
            return trace;
        }

        public void getCount() {
            for (int i = 0; i < matrixSize; i++) {
                boolean[] row = new boolean[matrixSize+1];
                boolean[] column = new boolean[matrixSize+1];
                boolean rowRepeated = false;
                boolean columnRepeated = false;
                for (int j = 0; j < matrixSize; j++) {
                    if (row[matrixValues[i][j]]) {
                        rowRepeated = true;
                    } else {
                        row[matrixValues[i][j]] = true;
                    }
                    if (column[matrixValues[j][i]]) {
                        columnRepeated = true;
                    } else {
                        column[matrixValues[j][i]] = true;
                    }
                }
                if (rowRepeated) {
                    rowCount++;
                }
                if (columnRepeated) {
                    columnCount++;
                }
            }
        }

    }
}
