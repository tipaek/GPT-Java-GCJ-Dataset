import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[][] rowCheck = new int[n][n];
            int[][] colCheck = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowCheck[matrix[i][j] - 1][i]++;
                }
                for (int j = 0; j < n; j++) {
                    if (rowCheck[j][i] > 1) {
                        rowCount++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    colCheck[matrix[i][j] - 1][j]++;
                }
                for (int i = 0; i < n; i++) {
                    if (colCheck[i][j] > 1) {
                        colCount++;
                        break;
                    }
                }
            }

            System.out.println(trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}