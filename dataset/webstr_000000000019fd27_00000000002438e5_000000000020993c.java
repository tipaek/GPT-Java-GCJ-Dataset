import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t1 = in.nextInt();
        for (int t = 1; t <= t1; t++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            int k = 0;
            for (int i = 0; i < n; i++) {
                k += arr[i][i];
            }

            int r = 0;
            int c = 0;

            for (int i = 0; i < n; i++) {
                int[] tmp = new int[n];
                for (int j = 0; j < n; j++) {
                    if (tmp[arr[i][j] - 1] > 0) {
                        r++;
                        break;
                    } else {
                        tmp[arr[i][j] - 1]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int[] tmp = new int[n];
                for (int j = 0; j < n; j++) {
                    if (tmp[arr[j][i] - 1] > 0) {
                        c++;
                        break;
                    } else {
                        tmp[arr[j][i] - 1]++;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }
}