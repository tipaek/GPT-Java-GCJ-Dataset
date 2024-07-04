package vestigium;

import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt(); // number of cases

        for (int i = 1; i <= T; ++i) {
            int N = input.nextInt(); // size of matrix
            int trace = 0; // trace of the matrix
            int rowRepeats = 0; // rows with repeated numbers
            int colRepeats = 0; // columns with repeated numbers

            int[][] matrix = new int[N][N];

            // Read matrix values and calculate trace
            for (int row = 0; row < N; row++) {
                boolean[] rowCheck = new boolean[N + 1];
                boolean rowHasDuplicates = false;

                for (int col = 0; col < N; col++) {
                    matrix[row][col] = input.nextInt();

                    // Calculate trace
                    if (row == col) {
                        trace += matrix[row][col];
                    }

                    // Check for duplicate in row
                    if (!rowHasDuplicates) {
                        if (rowCheck[matrix[row][col]]) {
                            rowRepeats++;
                            rowHasDuplicates = true;
                        } else {
                            rowCheck[matrix[row][col]] = true;
                        }
                    }
                }
            }

            // Check for duplicate in columns
            for (int col = 0; col < N; col++) {
                boolean[] colCheck = new boolean[N + 1];
                boolean colHasDuplicates = false;

                for (int row = 0; row < N; row++) {
                    if (!colHasDuplicates) {
                        if (colCheck[matrix[row][col]]) {
                            colRepeats++;
                            colHasDuplicates = true;
                        } else {
                            colCheck[matrix[row][col]] = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        input.close();
    }
}