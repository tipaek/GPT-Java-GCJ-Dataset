import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCaseCount; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // consume the remaining line
                }
            }

            System.out.println(generateResult(matrix, i + 1));
        }

        scanner.close();
    }

    private static String generateResult(int[][] matrix, int caseNumber) {
        int trace = calculateTrace(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateCols = countDuplicateColumns(matrix);

        return String.format("Case #%d: %d %d %d", caseNumber, trace, duplicateRows, duplicateCols);
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRowCount = 0;
        for (int[] row : matrix) {
            HashSet<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            for (int value : row) {
                if (!seen.add(value)) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColCount = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            HashSet<Integer> seen = new HashSet<>();
            boolean hasDuplicate = false;
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                duplicateColCount++;
            }
        }
        return duplicateColCount;
    }
}