import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int[][] matrix = new int[size][size];
            for (int row = 0; row < size; row++) {
                String rowData = scanner.nextLine();
                matrix[row] = parseRow(rowData, size);
            }

            int trace = calculateTrace(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateColumns = countDuplicateColumns(matrix);

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, trace, duplicateRows, duplicateColumns);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
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

    private static int countDuplicateColumns(int[][] matrix) {
        int duplicateColumns = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
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

    private static int[] parseRow(String rowData, int size) {
        int[] row = new int[size];
        Matcher matcher = Pattern.compile("\\d+").matcher(rowData);
        int index = 0;
        while (matcher.find() && index < size) {
            row[index++] = Integer.parseInt(matcher.group());
        }
        return row;
    }
}