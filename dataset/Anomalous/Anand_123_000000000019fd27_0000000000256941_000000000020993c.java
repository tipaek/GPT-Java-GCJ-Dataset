package practice;
import java.util.*;

public class CodeJam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int duplicateRows = countDuplicateRows(matrix, n);
            int duplicateCols = countDuplicateCols(matrix, n);

            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countDuplicateRows(int[][] matrix, int n) {
        int duplicateRows = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicate(matrix[i])) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countDuplicateCols(int[][] matrix, int n) {
        int duplicateCols = 0;
        for (int i = 0; i < n; i++) {
            if (hasDuplicate(getColumn(matrix, i, n))) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    private static int[] getColumn(int[][] matrix, int colIndex, int n) {
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = matrix[i][colIndex];
        }
        return column;
    }

    private static boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}