import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {
            processCase(i + 1);
        }
    }

    private static void processCase(int caseNumber) {
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        populateMatrix(matrix);
        int traceValue = calculateTrace(matrix);

        int repeatingRows = countRepeatingRows(matrix);
        int repeatingColumns = countRepeatingColumns(matrix);

        printResult(caseNumber, traceValue, repeatingRows, repeatingColumns);
    }

    private static void populateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatingRows(int[][] matrix) {
        int repeatingRows = 0;
        for (int[] row : matrix) {
            if (hasRepeatingElements(row)) {
                repeatingRows++;
            }
        }
        return repeatingRows;
    }

    private static int countRepeatingColumns(int[][] matrix) {
        int repeatingColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (hasRepeatingElements(extractColumn(matrix, i))) {
                repeatingColumns++;
            }
        }
        return repeatingColumns;
    }

    private static boolean hasRepeatingElements(int[] array) {
        HashSet<Integer> seenElements = new HashSet<>();
        for (int element : array) {
            if (!seenElements.add(element)) {
                return true;
            }
        }
        return false;
    }

    private static int[] extractColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }

    private static void printResult(int caseNumber, int trace, int repeatingRows, int repeatingColumns) {
        System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatingRows, repeatingColumns);
    }
}