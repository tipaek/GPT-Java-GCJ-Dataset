import java.util.Scanner;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scan.nextInt();
        for (int testCase = 0; testCase < t; ++testCase) {
            int dia = 0;
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int row = 0;
            int col = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    arr[i][j] = scan.nextInt();
                }
                dia += arr[i][i];
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; ++i) {
                int[] rowCheck = new int[101]; // Assuming values are in the range 1-100
                for (int j = 0; j < n; ++j) {
                    if (++rowCheck[arr[i][j]] > 1) {
                        ++row;
                        break;
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int i = 0; i < n; ++i) {
                int[] colCheck = new int[101]; // Assuming values are in the range 1-100
                for (int j = 0; j < n; ++j) {
                    if (++colCheck[arr[j][i]] > 1) {
                        ++col;
                        break;
                    }
                }
            }

            // Printing the results for the current test case
            System.out.println(dia + " " + row + " " + col);
        }
    }
}