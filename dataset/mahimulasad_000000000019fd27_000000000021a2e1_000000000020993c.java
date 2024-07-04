import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        int test;
        Scanner in = new Scanner(System.in);
        test = in.nextInt();

        for (int t = 1; t <= test; t++) {
            int n = in.nextInt();
            int[][] ar = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ar[i][j] = in.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum+= ar[i][i];
            }
            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                int[] track = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    if (track[ar[i][j]] != 0) {
                        r++;
                        break;
                    } else {
                        track[ar[i][j]]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int[] track = new int[n + 1];
                for (int j = 0; j < n; j++) {
                    if (track[ar[j][i]] != 0) {
                        c++;
                        break;
                    } else {
                        track[ar[j][i]]++;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", t, sum, r, c));
        }
    }
}
