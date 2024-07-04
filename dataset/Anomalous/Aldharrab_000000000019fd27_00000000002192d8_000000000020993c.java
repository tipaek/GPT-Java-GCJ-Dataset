import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numberOfMatrices = scnr.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            analyzeMatrix(scnr, i + 1);
        }
        scnr.close();
    }

    private static void analyzeMatrix(Scanner scnr, int currMatrix) {
        int matrixSize = scnr.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowRepeat = 0;
        int colRepeat = 0;

        // Read the matrix
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scnr.nextInt();
            }
        }

        // Calculate trace and repetitions
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];

            boolean[] rowCheck = new boolean[matrixSize + 1];
            boolean[] colCheck = new boolean[matrixSize + 1];

            for (int j = 0; j < matrixSize; j++) {
                if (rowCheck[matrix[i][j]]) {
                    rowRepeat++;
                    break;
                }
                rowCheck[matrix[i][j]] = true;
            }

            for (int j = 0; j < matrixSize; j++) {
                if (colCheck[matrix[j][i]]) {
                    colRepeat++;
                    break;
                }
                colCheck[matrix[j][i]] = true;
            }
        }

        System.out.printf("Case #%d: %d %d %d%n", currMatrix, trace, rowRepeat, colRepeat);
    }
}