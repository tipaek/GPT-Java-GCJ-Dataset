import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            int sum = 0, row = 0;
            for (int i = 0; i < n; i++) {
                boolean[] b = new boolean[n+1];
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                    if (b[arr[i][j]]) {
                        b[0] = true;
                    }
                    b[arr[i][j]] = true;
                }
                if (b[0]) row++;
            }

            int col = 0;
            for (int i = 0; i < n; i++) {
                boolean[] b = new boolean[n+1];
                for (int j = 0; j < n; j++) {
                    if (b[arr[j][i]]) {
                        b[0] = true;
                    }
                    b[arr[j][i]] = true;
                }
                if (b[0]) col++;
            }
            System.out.println("Case #" + tt + ": " + sum + " " + row + " " + col);
        }
    }
}
