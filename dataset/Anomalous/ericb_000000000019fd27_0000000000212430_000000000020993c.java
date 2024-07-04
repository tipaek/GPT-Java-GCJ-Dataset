import java.util.*;

public class Solution {
    private static int testCases;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            output.append(runTestCase(i + 1));
        }

        System.out.println(output);
    }

    private static String runTestCase(int caseNumber) {
        int size = scanner.nextInt();
        scanner.nextLine();
        int[][] values = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                values[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        return String.format("Case #%d: %d %d %d%n", caseNumber, calcTrace(values), countDuplicateRows(values), countDuplicateColumns(values));
    }

    private static int calcTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;

        for (int col = 0; col < matrix.length; col++) {
            int[] columnValues = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                columnValues[row] = matrix[row][col];
            }
            if (hasDuplicates(columnValues)) {
                duplicateColumns++;
            }
        }

        return duplicateColumns;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;

        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateRows++;
            }
        }

        return duplicateRows;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return true;
            }
        }
        return false;
    }
}