import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int repeatedRows = countRepeatedRows(matrix, n);
            int repeatedColumns = countRepeatedColumns(matrix, n);

            System.out.println("Case #" + caseIndex + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }

        scanner.close();
    }

    private static int calculateTrace(int[][] matrix, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int row = 0; row < n; row++) {
            if (hasDuplicates(matrix[row])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int repeatedColumns = 0;
        for (int col = 0; col < n; col++) {
            int[] columnArray = new int[n];
            for (int row = 0; row < n; row++) {
                columnArray[row] = matrix[row][col];
            }
            if (hasDuplicates(columnArray)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}