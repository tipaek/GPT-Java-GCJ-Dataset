import java.io.*;

public class Solution {
    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void processMatrix(int[][] matrix, int size) {
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        for (int i = 0; i < size; i++) {
            boolean rowHasRepeat = false;
            boolean columnHasRepeat = false;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowHasRepeat) {
                    int currentNum = matrix[i][j];
                    for (int k = j + 1; k < size; k++) {
                        if (currentNum == matrix[i][k]) {
                            rowHasRepeat = true;
                            break;
                        }
                    }
                }
                if (!columnHasRepeat) {
                    int currentNum = matrix[j][i];
                    for (int k = j + 1; k < size; k++) {
                        if (currentNum == matrix[k][i]) {
                            columnHasRepeat = true;
                            break;
                        }
                    }
                }
            }
            if (rowHasRepeat) rowRepeats++;
            if (columnHasRepeat) columnRepeats++;
        }

        System.out.print(trace + " " + rowRepeats + " " + columnRepeats);
    }

    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(args[0]);
        int argIndex = 1;

        for (int i = 0; i < testCases; i++) {
            int matrixSize = Integer.parseInt(args[argIndex++]);
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = Integer.parseInt(args[argIndex++]);
                }
            }

            System.out.print("Case #" + (i + 1) + ": ");
            processMatrix(matrix, matrixSize);
            System.out.println();
        }
    }
}