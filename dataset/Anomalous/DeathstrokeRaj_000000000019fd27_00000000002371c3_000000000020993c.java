import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int z = 1; z <= t; z++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];

            int trace = 0, rowCount = 0, colCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    // Check row
                    if (rowCheck[matrix[i][j]]) {
                        if (!rowFlags[i]) {
                            rowCount++;
                            rowFlags[i] = true;
                        }
                    } else {
                        rowCheck[matrix[i][j]] = true;
                    }

                    // Check column
                    if (colCheck[matrix[j][i]]) {
                        if (!colFlags[i]) {
                            colCount++;
                            colFlags[i] = true;
                        }
                    } else {
                        colCheck[matrix[j][i]] = true;
                    }
                }
            }

            System.out.println("Case #" + z + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}