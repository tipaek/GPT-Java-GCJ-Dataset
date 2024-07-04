import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int m = 1; m <= t; m++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0, count1 = 0, count2 = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }

            // Checking for duplicates in columns and rows
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean[] colCheck = new boolean[n + 1];

                for (int j = 0; j < n; j++) {
                    // Check for duplicates in the row
                    if (rowCheck[arr[i][j]]) {
                        count1++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;

                    // Check for duplicates in the column
                    if (colCheck[arr[j][i]]) {
                        count2++;
                        break;
                    }
                    colCheck[arr[j][i]] = true;
                }
            }

            System.out.println("Case #" + m + ": " + sum + " " + count1 + " " + count2);
        }

        sc.close();
    }
}