import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, repeatedRows = 0, repeatedCols = 0;

            // Read the matrix and calculate the trace
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }

            // Check for repeated elements in rows and columns
            for (int i = 0; i < size; i++) {
                if (hasRepeatedElements(matrix[i])) {
                    repeatedRows++;
                }
                if (hasRepeatedElements(getColumn(matrix, i))) {
                    repeatedCols++;
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }

    private static boolean hasRepeatedElements(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
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