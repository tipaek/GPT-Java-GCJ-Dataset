import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            analyzeMatrix(scanner, i + 1);
        }
    }

    private static void analyzeMatrix(Scanner scanner, int caseNumber) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowRepeats = 0;
        int columnRepeats = 0;

        for (int i = 0; i < matrixSize; i++) {
            boolean rowHasRepeat = false;
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (!rowHasRepeat) {
                    for (int k = 0; k < j; k++) {
                        if (matrix[i][k] == matrix[i][j]) {
                            rowHasRepeat = true;
                            rowRepeats++;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < matrixSize; j++) {
            boolean columnHasRepeat = false;
            for (int i = 0; i < matrixSize; i++) {
                if (!columnHasRepeat) {
                    for (int k = 0; k < i; k++) {
                        if (matrix[k][j] == matrix[i][j]) {
                            columnHasRepeat = true;
                            columnRepeats++;
                        }
                    }
                }
            }
        }

        System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + columnRepeats);
    }
}