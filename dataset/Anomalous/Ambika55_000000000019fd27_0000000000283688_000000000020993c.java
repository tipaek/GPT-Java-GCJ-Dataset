import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scn.nextInt();
            int trace = 0;
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scn.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int j = 0; j < n; j++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int k = 0; k < n; k++) {
                    if (rowCheck[matrix[j][k]]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[j][k]] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int k = 0; k < n; k++) {
                    if (colCheck[matrix[k][j]]) {
                        duplicateCols++;
                        break;
                    }
                    colCheck[matrix[k][j]] = true;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scn.close();
    }
}