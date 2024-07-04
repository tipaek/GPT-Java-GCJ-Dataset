import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int crossSum = 0;
            int[][] matrix = new int[t][t];
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Read the matrix and calculate the cross diagonal sum
            for (int row = 0; row < t; row++) {
                for (int col = 0; col < t; col++) {
                    matrix[row][col] = scanner.nextInt();
                    if (row == col) {
                        crossSum += matrix[row][col];
                    }
                }
            }

            // Check for repeated numbers in rows and columns
            for (int row = 0; row < t; row++) {
                boolean[] rowCheck = new boolean[t + 1];
                boolean[] colCheck = new boolean[t + 1];
                boolean rowHasRepeat = false;
                boolean colHasRepeat = false;

                for (int col = 0; col < t; col++) {
                    // Check rows
                    if (rowCheck[matrix[row][col]]) {
                        rowHasRepeat = true;
                    } else {
                        rowCheck[matrix[row][col]] = true;
                    }

                    // Check columns
                    if (colCheck[matrix[col][row]]) {
                        colHasRepeat = true;
                    } else {
                        colCheck[matrix[col][row]] = true;
                    }
                }

                if (rowHasRepeat) {
                    repeatedRows++;
                }
                if (colHasRepeat) {
                    repeatedCols++;
                }
            }

            System.out.println(crossSum + " " + repeatedRows + " " + repeatedCols);
        }

        scanner.close();
    }
}