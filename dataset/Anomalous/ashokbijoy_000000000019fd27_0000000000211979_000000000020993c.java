import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int[] results = analyzeMatrix(matrix);
            System.out.println("Case #" + testCase + ": " + results[0] + " " + results[1] + " " + results[2]);
        }
        scanner.close();
    }

    public static int[] analyzeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[] { 0, 0, 0 };
        int n = matrix.length;

        int trace = 0, duplicateRows = 0, duplicateColumns = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        for (int i = 0; i < n; i++) {
            if (hasDuplicates(matrix[i])) {
                duplicateRows++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (hasDuplicates(getColumn(matrix, j))) {
                duplicateColumns++;
            }
        }

        return new int[] { trace, duplicateRows, duplicateColumns };
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : array) {
            if (set.contains(value)) {
                return true;
            }
            set.add(value);
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}