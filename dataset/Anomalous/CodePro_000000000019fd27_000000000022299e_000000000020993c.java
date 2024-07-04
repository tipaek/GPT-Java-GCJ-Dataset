import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCases = in.nextInt();
        String[] results = new String[numOfCases];

        for (int i = 0; i < numOfCases; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateColumns = countDuplicateColumns(matrix, n);

            results[i] = String.format("Case #%d: %d %d %d", i + 1, trace, duplicateRows, duplicateColumns);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int row = 0; row < n; row++) {
            if (hasDuplicates(matrix[row])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateColumns(int[][] matrix, int n) {
        int duplicateColumns = 0;
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}