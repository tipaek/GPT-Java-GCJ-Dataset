import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int test = 1; test <= t; test++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            int diagonalSum = 0;

            // Check for duplicate rows and calculate diagonal sum
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        rowHasDuplicate = true;
                    }
                    rowCheck[matrix[i][j]] = true;
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
                if (rowHasDuplicate) {
                    duplicateRows++;
                }
            }

            // Check for duplicate columns
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean colHasDuplicate = false;
                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        colHasDuplicate = true;
                    }
                    colCheck[matrix[j][i]] = true;
                }
                if (colHasDuplicate) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + test + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
        in.close();
    }
}