import java.util.Scanner;

public class Vestigium {

    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            int trace = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);

            System.out.printf(OUTPUT_FORMAT, caseNumber, trace, repeatedRows, repeatedCols);
            System.out.println();
        }
    }

    private static int countRepeatedRows(int[][] matrix) {
        int size = matrix.length;
        int repeatedRows = 0;

        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    repeatedRows++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return repeatedRows;
    }

    private static int countRepeatedCols(int[][] matrix) {
        int size = matrix.length;
        int repeatedCols = 0;

        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    repeatedCols++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        return repeatedCols;
    }
}