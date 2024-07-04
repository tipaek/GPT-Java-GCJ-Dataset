import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0, countRow = 0, countCol = 0;

            // Read the matrix and calculate the sum of the diagonal
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }

            // Check for duplicate values in each row
            for (int i = 0; i < n; i++) {
                int[] count = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    if (++count[arr[i][j]] > 1) {
                        countRow++;
                        break;
                    }
                }
            }

            // Check for duplicate values in each column
            for (int j = 0; j < n; j++) {
                int[] count = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    if (++count[arr[i][j]] > 1) {
                        countCol++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + k + ": " + sum + " " + countRow + " " + countCol);
        }
    }
}