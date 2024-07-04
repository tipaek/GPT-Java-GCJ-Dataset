import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTests = scanner.nextInt();

            for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
                int[][] matrix = readMatrix(scanner);
                evaluateMatrix(testIndex, matrix);
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        scanner.nextLine();
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            scanner.nextLine();
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static void evaluateMatrix(int testNumber, int[][] matrix) {
        int size = matrix.length;
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateColumns = countDuplicateColumns(matrix, size);
        int trace = calculateTrace(matrix, size);

        System.out.println("Case #" + testNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;

        for (int row = 0; row < size; row++) {
            int[] occurrences = new int[size + 1];

            for (int col = 0; col < size; col++) {
                occurrences[matrix[row][col]]++;
                if (occurrences[matrix[row][col]] > 1) {
                    duplicateRows++;
                    break;
                }
            }
        }

        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;

        for (int col = 0; col < size; col++) {
            int[] occurrences = new int[size + 1];

            for (int row = 0; row < size; row++) {
                occurrences[matrix[row][col]]++;
                if (occurrences[matrix[row][col]] > 1) {
                    duplicateColumns++;
                    break;
                }
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