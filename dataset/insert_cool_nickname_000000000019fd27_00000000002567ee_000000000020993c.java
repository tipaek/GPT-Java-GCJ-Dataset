import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int[] calc(int[][] arr, int n) {
        int[] r = new int[n + 1];
        int[][] c = new int[n][n + 1];
        int[] res = new int[3];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    res[0] += arr[i][j];
                }
                if (r[0] == 0) {
                    // not a repeating row yet
                    if (r[arr[i][j]] > 0) {
                        r[0]++;
                        res[1]++;
                    } else {
                        r[arr[i][j]]++;
                    }
                }
                if (c[j][0] == 0) {
                    // not a repeating col yet
                    if (c[j][arr[i][j]] > 0) {
                        c[j][0]++;
                        res[2]++;
                    } else {
                        c[j][arr[i][j]]++;
                    }
                }
            }
            r = new int[n + 1];
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    arr[j][k] = sc.nextInt();
                }
            }
            int[] res = calc(arr, n);
            System.out.println("Case #" + (i + 1) + " : " + res[0] + " " + res[1] + " " + res[2]);
        }
    }
}