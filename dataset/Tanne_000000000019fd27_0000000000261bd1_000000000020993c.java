import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // initiating the base variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            int a = 0;
            int row = 0;
            int col = 0;
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int temp = scan.nextInt();
                    if (j == k) a += temp;
                    arr[j][k] = temp;
                }
            }
            for (int j = 0; j < n; j++) {
                boolean[] tmp = new boolean[n];
                for (int k = 0; k < n; k++) {
                    if (tmp[arr[j][k] - 1]) {
                        row++;

                    } else {
                        tmp[arr[j][k] - 1] = true;
                    }
                    if (tmp[arr[k][j] - 1]) {
                        col++;

                    } else {
                        tmp[arr[k][j] - 1] = true;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + a + " " + row + " " + col);
        }
    }
}
