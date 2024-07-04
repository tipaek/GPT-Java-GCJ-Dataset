import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            boolean[][] rowCheck = new boolean[n][n];
            boolean[][] colCheck = new boolean[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    rowCheck[i][matrix[i][j] - 1] = true;
                    colCheck[j][matrix[i][j] - 1] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                boolean rowDuplicate = false;
                boolean colDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (!rowDuplicate && rowCheck[i][j]) {
                        rowCheck[i][j] = false;
                    } else if (!rowDuplicate) {
                        rowRepeats++;
                        rowDuplicate = true;
                    }

                    if (!colDuplicate && colCheck[i][j]) {
                        colCheck[i][j] = false;
                    } else if (!colDuplicate) {
                        colRepeats++;
                        colDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}