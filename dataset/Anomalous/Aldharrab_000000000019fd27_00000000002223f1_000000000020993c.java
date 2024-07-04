import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfMatrices = scanner.nextInt();

        for (int i = 0; i < numberOfMatrices; i++) {
            analyzeMatrix(scanner, i + 1);
        }

        scanner.close();
    }

    private static void analyzeMatrix(Scanner scanner, int matrixIndex) {
        int matrixSize = scanner.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        // Read the matrix
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Calculate the trace
        for (int i = 0; i < matrixSize; i++) {
            trace += matrix[i][i];
        }

        // Check for repeated elements in rows
        for (int i = 0; i < matrixSize; i++) {
            if (hasDuplicates(matrix[i])) {
                rowRepeats++;
            }
        }

        // Check for repeated elements in columns
        for (int j = 0; j < matrixSize; j++) {
            int[] column = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                colRepeats++;
            }
        }

        System.out.println("Case #" + matrixIndex + ": " + trace + " " + colRepeats + " " + rowRepeats);
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}