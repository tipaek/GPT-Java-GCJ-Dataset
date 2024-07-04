import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            // Calculate the trace
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            // Check for duplicate values in rows
            int duplicateRows = 0;
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            // Check for duplicate values in columns
            int duplicateColumns = 0;
            for (int j = 0; j < size; j++) {
                int[] column = new int[size];
                for (int i = 0; i < size; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateColumns++;
                }
            }

            // Print the result
            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, duplicateRows, duplicateColumns);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        int size = array.length;
        boolean[] seen = new boolean[size];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}