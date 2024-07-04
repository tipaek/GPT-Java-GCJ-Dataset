import java.util.*;
import java.io.*;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int duplicateRowsCount = countDuplicateRows(matrix, size);
            int duplicateColumnsCount = countDuplicateColumns(matrix, size);
            int trace = calculateTrace(matrix, size);

            System.out.println("Case #" + testCase + ": " + trace + " " + duplicateRowsCount + " " + duplicateColumnsCount);
        }
    }

    private static int countDuplicateRows(int[][] matrix, int size) {
        int duplicateRowsCount = 0;

        for (int i = 0; i < size; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRowsCount++;
            }
        }

        return duplicateRowsCount;
    }

    private static int countDuplicateColumns(int[][] matrix, int size) {
        int duplicateColumnsCount = 0;

        for (int j = 0; j < size; j++) {
            int[] column = new int[size];
            for (int i = 0; i < size; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                duplicateColumnsCount++;
            }
        }

        return duplicateColumnsCount;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;

        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        return trace;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();

        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }

        return false;
    }
}