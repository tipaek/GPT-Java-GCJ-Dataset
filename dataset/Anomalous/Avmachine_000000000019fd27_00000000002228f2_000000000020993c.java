import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
            }

            System.out.println("Case #" + x + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}