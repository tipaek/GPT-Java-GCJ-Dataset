import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix and calculate the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            // Check for row and column repetitions
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n];
                boolean[] colCheck = new boolean[n];
                for (int j = 0; j < n; j++) {
                    // Check row repetition
                    if (rowCheck[matrix[i][j] - 1]) {
                        rowRepeats++;
                        break;
                    } else {
                        rowCheck[matrix[i][j] - 1] = true;
                    }
                    
                    // Check column repetition
                    if (colCheck[matrix[j][i] - 1]) {
                        colRepeats++;
                        break;
                    } else {
                        colCheck[matrix[j][i] - 1] = true;
                    }
                }
            }

            // Output the result for the current test case
            System.out.println("Case #" + k + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}