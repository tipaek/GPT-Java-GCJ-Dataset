import java.util.*;

public class Solution {

    public static void main(String[] args) {
        performCalculations();
    }

    public static void performCalculations() {
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

            int trace = calculateTrace(matrix, matrixSize);
            int repeatedRows = countRepeatedRows(matrix, matrixSize);
            int repeatedColumns = countRepeatedColumns(matrix, matrixSize);

            System.out.println("Case #" + caseNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int size) {
        int repeatedRows = 0;

        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasRepeats = false;

            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    hasRepeats = true;
                }
            }

            if (hasRepeats) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int size) {
        int repeatedColumns = 0;

        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            boolean hasRepeats = false;

            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    hasRepeats = true;
                }
            }

            if (hasRepeats) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }
}