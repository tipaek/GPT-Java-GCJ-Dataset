import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scn.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scn.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            int duplicateRows = 0, duplicateCols = 0;

            for (int j = 0; j < n; j++) {
                if (hasDuplicates(matrix[j])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int k = 0; k < n; k++) {
                    col[k] = matrix[k][j];
                }
                if (hasDuplicates(col)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        Arrays.fill(seen, false);
        for (int num : array) {
            if (seen[num]) {
                return true;
            }
            seen[num] = true;
        }
        return false;
    }
}