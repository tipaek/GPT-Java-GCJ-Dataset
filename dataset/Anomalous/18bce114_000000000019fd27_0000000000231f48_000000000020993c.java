import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            boolean[] rowCheck, colCheck;
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Reading matrix and calculating trace
            for (int i = 0; i < n; i++) {
                rowCheck = new boolean[n];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[matrix[i][j] - 1] = true;
                }
            }

            // Checking for column repeats
            for (int j = 0; j < n; j++) {
                colCheck = new boolean[n];
                for (int i = 0; i < n; i++) {
                    if (colCheck[matrix[i][j] - 1]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[matrix[i][j] - 1] = true;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}