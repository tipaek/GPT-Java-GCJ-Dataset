import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numberOfMatrices = scnr.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            analyzeMatrix(scnr, i + 1);
        }
    }

    private static void analyzeMatrix(Scanner scnr, int caseNumber) {
        int matrixSize = scnr.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Read the matrix and calculate trace
        for (int i = 0; i < matrixSize; i++) {
            boolean[] rowCheck = new boolean[matrixSize + 1];
            boolean rowHasRepeat = false;
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scnr.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (rowCheck[matrix[i][j]]) {
                    rowHasRepeat = true;
                }
                rowCheck[matrix[i][j]] = true;
            }
            if (rowHasRepeat) {
                rowRepeats++;
            }
        }

        // Check for column repeats
        for (int j = 0; j < matrixSize; j++) {
            boolean[] colCheck = new boolean[matrixSize + 1];
            boolean colHasRepeat = false;
            for (int i = 0; i < matrixSize; i++) {
                if (colCheck[matrix[i][j]]) {
                    colHasRepeat = true;
                }
                colCheck[matrix[i][j]] = true;
            }
            if (colHasRepeat) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}