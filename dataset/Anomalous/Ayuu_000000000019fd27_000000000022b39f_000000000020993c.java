import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int m = 1; m <= t; m++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0;
            int count1 = 0, count2 = 0;

            // Reading the matrix and calculating the diagonal sum
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }

            // Checking for duplicate values in columns
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        count1++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Checking for duplicate values in rows
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        count2++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            System.out.println("Case #" + m + ": " + sum + " " + count1 + " " + count2);
        }

        sc.close();
    }
}