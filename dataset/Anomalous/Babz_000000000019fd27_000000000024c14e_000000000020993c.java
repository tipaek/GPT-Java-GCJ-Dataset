import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseNumber = in.nextInt();

        for (int test = 1; test <= testCaseNumber; test++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            processTestCase(test, size, matrix);
        }
        in.close();
    }

    private static void processTestCase(int testCase, int size, int[][] matrix) {
        int trace = calculateTrace(matrix, size);
        int duplicateRows = countDuplicateRows(matrix, size);
        int duplicateColumns = countDuplicateColumns(matrix, size);

        System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            if (hasDuplicate(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicate(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}