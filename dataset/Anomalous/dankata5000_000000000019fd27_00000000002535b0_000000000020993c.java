import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution().execute();
    }

    void execute() {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int size = scanner.nextInt();
                int[][] matrix = new int[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                System.out.println("Case #" + t + ": " + processMatrix(size, matrix));
            }
        }
    }

    String processMatrix(int size, int[][] matrix) {
        int trace = calculateTrace(size, matrix);
        int repeatedRows = countRepeatedRows(size, matrix);
        int repeatedColumns = countRepeatedColumns(size, matrix);
        return trace + " " + repeatedRows + " " + repeatedColumns;
    }

    int calculateTrace(int size, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    int countRepeatedRows(int size, int[][] matrix) {
        int repeatedRows = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    int countRepeatedColumns(int size, int[][] matrix) {
        int repeatedColumns = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicates(getColumn(matrix, i))) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    boolean hasDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int value : array) {
            if (!uniqueElements.add(value)) {
                return true;
            }
        }
        return false;
    }

    int[] getColumn(int[][] matrix, int columnIndex) {
        int size = matrix.length;
        int[] column = new int[size];
        for (int i = 0; i < size; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}