import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        for (int i = 0; i < inputCount; i++) {
            int[] result = processInput(sc);
            System.out.println("Case #" + (i + 1) + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        sc.close();
    }

    public static int[] processInput(Scanner sc) {
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return new int[] { countRepeatedRows(matrix), countRepeatedColumns(matrix), calculateDiagonalSum(matrix) };
    }

    public static int countRepeatedRows(int[][] matrix) {
        int repeatedRows = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (hasDuplicates(matrix[i])) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }

    public static int countRepeatedColumns(int[][] matrix) {
        int repeatedColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] column = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                column[j] = matrix[j][i];
            }
            if (hasDuplicates(column)) {
                repeatedColumns++;
            }
        }
        return repeatedColumns;
    }

    public static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (value > 0 && value <= array.length && seen[value]) {
                return true;
            }
            if (value > 0 && value <= array.length) {
                seen[value] = true;
            }
        }
        return false;
    }
}