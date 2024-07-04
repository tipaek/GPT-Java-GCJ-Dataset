import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            // Read the matrix
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, matrixSize);
            int rowDuplicates = countRowDuplicates(matrix, matrixSize);
            int colDuplicates = countColDuplicates(matrix, matrixSize);

            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowDuplicates, colDuplicates);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    duplicateRows++;
                    break;
                } else {
                    seen[matrix[row][col]] = true;
                }
            }
        }
        return duplicateRows;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    duplicateCols++;
                    break;
                } else {
                    seen[matrix[row][col]] = true;
                }
            }
        }
        return duplicateCols;
    }
}