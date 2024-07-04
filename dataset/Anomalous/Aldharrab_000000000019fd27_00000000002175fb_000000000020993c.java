import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try {
            Scanner scnr = new Scanner(System.in);
            int numberOfMatrices = scnr.nextInt();

            for (int i = 0; i < numberOfMatrices; i++) {
                analyzeMatrix(scnr, i + 1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeMatrix(Scanner scnr, int currMatrix) {
        int matrixSize = scnr.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int traceSize = 0;
        int columnRepeat = 0;
        int rowRepeat = 0;

        // Reading the matrix and calculating row repeats
        for (int i = 0; i < matrixSize; i++) {
            boolean rowHasRepeat = false;
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scnr.nextInt();
                if (!rowHasRepeat) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[i][k] == matrix[i][j]) {
                            rowHasRepeat = true;
                            rowRepeat++;
                        }
                    }
                }
            }
        }

        // Calculating trace and column repeats
        for (int j = 0; j < matrixSize; j++) {
            boolean colHasRepeat = false;
            for (int i = 0; i < matrixSize; i++) {
                if (i == j) {
                    traceSize += matrix[i][j];
                }
                if (!colHasRepeat) {
                    for (int k = 0; k < i; k++) {
                        if (matrix[k][j] == matrix[i][j]) {
                            colHasRepeat = true;
                            columnRepeat++;
                        }
                    }
                }
            }
        }

        System.out.println("Case #" + currMatrix + ": " + traceSize + " " + columnRepeat + " " + rowRepeat);
    }
}