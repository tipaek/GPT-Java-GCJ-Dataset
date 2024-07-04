import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for (int k = 0; k < t; ++k) {
            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;
            int n = scan.nextInt();

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = scan.nextInt();
                }
                diagonalSum += matrix[i][i];
            }

            for (int i = 0; i < n; ++i) {
                boolean[] rowCheck = new boolean[101];
                for (int j = 0; j < n; ++j) {
                    if (rowCheck[matrix[i][j]]) {
                        duplicateRows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            for (int i = 0; i < n; ++i) {
                boolean[] colCheck = new boolean[101];
                for (int j = 0; j < n; ++j) {
                    if (colCheck[matrix[j][i]]) {
                        duplicateCols++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println(diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }
}