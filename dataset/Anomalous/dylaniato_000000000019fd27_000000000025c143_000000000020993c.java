import java.util.Scanner;

public class Vestigium {

    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            int trace = 0;
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            int repeatedRowCount = countRepeatedRows(matrix);
            int repeatedColCount = countRepeatedCols(matrix);

            System.out.println(String.format(OUTPUT_FORMAT, caseNumber, trace, repeatedRowCount, repeatedColCount));
        }
        scanner.close();
    }

    private static int countRepeatedRows(int[][] matrix) {
        int size = matrix.length;
        int repeatedRows = 0;

        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    repeatedRows++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix) {
        int size = matrix.length;
        int repeatedCols = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    repeatedCols++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return repeatedCols;
    }
}