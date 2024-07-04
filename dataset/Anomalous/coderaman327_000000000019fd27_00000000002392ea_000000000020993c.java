import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n + 1][n + 1];
            boolean[][] rowCheck = new boolean[n + 1][n + 1];
            boolean[][] colCheck = new boolean[n + 1][n + 1];
            int trace = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int element = sc.nextInt();
                    matrix[i][j] = element;

                    if (i == j) {
                        trace += element;
                    }

                    if (rowCheck[i][element]) {
                        rowCheck[i][0] = true;
                    }
                    rowCheck[i][element] = true;

                    if (colCheck[j][element]) {
                        colCheck[j][0] = true;
                    }
                    colCheck[j][element] = true;
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 1; i <= n; i++) {
                if (rowCheck[i][0]) {
                    duplicateRows++;
                }
                if (colCheck[i][0]) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        sc.close();
    }
}