import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// 5 Indicium
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            solve(i, n, m);
        }
    }

    public static void solve(int t, int n, int k) {
        if (k % n != 0) {
            System.out.println("Case #" + t + ": IMPOSSIBLE");
            return;
        }
        System.out.println("Case #" + t + ": POSSIBLE");
        int m = k / n;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = m;
            for (int x = i; x < n; x++, j++) {
                if (j > n) {
                    j = j % n;
                }
                res[i][x] = j;
            }
            for (int x = 0; x < i; x++, j++) {
                if (j > n) {
                    j = j % n;
                }
                res[i][x] = j;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}