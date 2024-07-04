import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            // Reading matrix and calculating trace
            for (int row = 0; row < n; row++) {
                boolean[] rowCheck = new boolean[101];
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (rowCheck[matrix[row][col]]) {
                        rowRepeats++;
                        rowCheck[matrix[row][col]] = false; // Avoid counting multiple duplicates
                    } else {
                        rowCheck[matrix[row][col]] = true;
                    }
                }
            }

            // Checking for column repeats
            for (int col = 0; col < n; col++) {
                boolean[] colCheck = new boolean[101];
                for (int row = 0; row < n; row++) {
                    if (colCheck[matrix[row][col]]) {
                        colRepeats++;
                        colCheck[matrix[row][col]] = false; // Avoid counting multiple duplicates
                    } else {
                        colCheck[matrix[row][col]] = true;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scanner.close();
    }
}