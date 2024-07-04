import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int duplicateRows = countDuplicateRows(matrix, matrixSize);
            int duplicateColumns = countDuplicateColumns(matrix, matrixSize);
            int trace = calculateTrace(matrix, matrixSize);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;

        for (int row = 0; row < size; row++) {
            boolean[] seen = new boolean[size + 1];
            for (int col = 0; col < size; col++) {
                if (seen[matrix[row][col]]) {
                    duplicateRows++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;

        for (int col = 0; col < size; col++) {
            boolean[] seen = new boolean[size + 1];
            for (int row = 0; row < size; row++) {
                if (seen[matrix[row][col]]) {
                    duplicateColumns++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }

        return duplicateColumns;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }
}