import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            int[] standardArray = new int[n];
            for (int j = 0; j < n; j++) {
                standardArray[j] = j + 1;
            }

            int trace = 0;
            int rowIssues = 0;
            int colIssues = 0;

            for (int j = 0; j < n; j++) {
                int[] row = new int[n];
                for (int k = 0; k < n; k++) {
                    mat[j][k] = in.nextInt();
                    row[k] = mat[j][k];
                    if (j == k) {
                        trace += mat[j][k];
                    }
                }

                Arrays.sort(row);
                if (!Arrays.equals(row, standardArray)) {
                    rowIssues++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int k = 0; k < n; k++) {
                    col[k] = mat[k][j];
                }

                Arrays.sort(col);
                if (!Arrays.equals(col, standardArray)) {
                    colIssues++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowIssues + " " + colIssues);
        }

        in.close();
    }
}