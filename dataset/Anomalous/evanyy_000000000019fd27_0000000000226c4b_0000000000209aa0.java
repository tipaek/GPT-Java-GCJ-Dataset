import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] matrix = generateMatrix(n, k);
            if (matrix == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                printMatrix(matrix);
            }
        }
    }

    private static int[][] generateMatrix(int n, int k) {
        int maxAttempts = 2000000;
        Random random = new Random();
        int[][] matrix = new int[n][n];
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            fillMatrix(matrix, n, random);
            if (isValidMatrix(matrix, n, k)) {
                return matrix;
            }
        }
        return null;
    }

    private static void fillMatrix(int[][] matrix, int n, Random random) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1 + random.nextInt(n);
            }
        }
    }

    private static boolean isValidMatrix(int[][] matrix, int n, int k) {
        return trace(matrix, n) == k && countRepeatedRows(matrix, n) == 0 && countRepeatedColumns(matrix, n) == 0;
    }

    private static int trace(int[][] matrix, int n) {
        int traceSum = 0;
        for (int i = 0; i < n; i++) {
            traceSum += matrix[i][i];
        }
        return traceSum;
    }

    private static int countRepeatedRows(int[][] matrix, int n) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    private static int countRepeatedColumns(int[][] matrix, int n) {
        int repeatedColumns = 0;
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
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

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}