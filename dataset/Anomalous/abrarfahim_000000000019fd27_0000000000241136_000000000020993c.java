import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            // Read the matrix
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            // Calculate trace
            int trace = calculateTrace(arr, n);

            // Calculate row and column repetitions
            int rowRepetitions = countRowRepetitions(arr, n);
            int colRepetitions = countColRepetitions(arr, n);

            // Output the result
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepetitions + " " + colRepetitions);
        }
        sc.close();
    }

    private static int calculateTrace(int[][] arr, int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += arr[i][i];
        }
        return trace;
    }

    private static int countRowRepetitions(int[][] arr, int n) {
        int rowRepetitions = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[arr[i][j]]) {
                    rowRepetitions++;
                    break;
                }
                seen[arr[i][j]] = true;
            }
        }
        return rowRepetitions;
    }

    private static int countColRepetitions(int[][] arr, int n) {
        int colRepetitions = 0;
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[arr[i][j]]) {
                    colRepetitions++;
                    break;
                }
                seen[arr[i][j]] = true;
            }
        }
        return colRepetitions;
    }
}