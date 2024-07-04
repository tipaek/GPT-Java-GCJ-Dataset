import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] trace = new int[t];
        int[] rowRepeats = new int[t];
        int[] colRepeats = new int[t];

        for (int i = 0; i < t; i++) {
            int dimension = sc.nextInt();
            int[][] matrix = new int[dimension][dimension];
            boolean[] rowCheck;
            boolean[] colCheck;

            // Initialize trace, rowRepeats, and colRepeats for the current test case
            trace[i] = 0;
            rowRepeats[i] = 0;
            colRepeats[i] = 0;

            // Read the matrix and calculate the trace and row repeats
            for (int j = 0; j < dimension; j++) {
                rowCheck = new boolean[dimension];
                for (int k = 0; k < dimension; k++) {
                    matrix[j][k] = sc.nextInt();
                    if (j == k) {
                        trace[i] += matrix[j][k];
                    }
                    if (rowCheck[matrix[j][k] - 1]) {
                        rowRepeats[i]++;
                        break;
                    } else {
                        rowCheck[matrix[j][k] - 1] = true;
                    }
                }
            }

            // Calculate column repeats
            for (int j = 0; j < dimension; j++) {
                colCheck = new boolean[dimension];
                for (int k = 0; k < dimension; k++) {
                    if (colCheck[matrix[k][j] - 1]) {
                        colRepeats[i]++;
                        break;
                    } else {
                        colCheck[matrix[k][j] - 1] = true;
                    }
                }
            }
        }

        // Print the results for each test case
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowRepeats[i] + " " + colRepeats[i]);
        }
    }
}