import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfCase = in.nextInt();
        String[] results = new String[numOfCase];

        for (int i = 0; i < numOfCase; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = in.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int j = 0; j < n; j++) {
                trace += matrix[j][j];
            }

            for (int row = 0; row < n; row++) {
                if (hasDuplicates(matrix[row])) {
                    duplicateRows++;
                }
            }

            for (int col = 0; col < n; col++) {
                int[] column = new int[n];
                for (int row = 0; row < n; row++) {
                    column[row] = matrix[row][col];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            results[i] = "Case #" + (i + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}