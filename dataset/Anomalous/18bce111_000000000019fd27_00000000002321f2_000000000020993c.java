import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                boolean[] colCheck = new boolean[n];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (!rowHasDuplicate && rowCheck[matrix[i][j] - 1]) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    }
                    rowCheck[matrix[i][j] - 1] = true;

                    if (!colHasDuplicate && colCheck[matrix[j][i] - 1]) {
                        colRepeats++;
                        colHasDuplicate = true;
                    }
                    colCheck[matrix[j][i] - 1] = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}