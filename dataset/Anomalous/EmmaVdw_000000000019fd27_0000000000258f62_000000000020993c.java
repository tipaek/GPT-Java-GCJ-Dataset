import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowsWithRepeats = 0;
            int colsWithRepeats = 0;

            for (int r = 0; r < n; r++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int c = 0; c < n; c++) {
                    int val = scanner.nextInt();
                    matrix[r][c] = val;
                    if (r == c) {
                        trace += val;
                    }
                    if (rowCheck[val]) {
                        rowsWithRepeats++;
                        break;
                    }
                    rowCheck[val] = true;
                }
            }

            for (int c = 0; c < n; c++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int r = 0; r < n; r++) {
                    int val = matrix[r][c];
                    if (colCheck[val]) {
                        colsWithRepeats++;
                        break;
                    }
                    colCheck[val] = true;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowsWithRepeats + " " + colsWithRepeats);
        }
        scanner.close();
    }
}