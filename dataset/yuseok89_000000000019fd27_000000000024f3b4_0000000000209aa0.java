import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isPossible = false;
    public static boolean[][] chk1;
    public static boolean[][] chk2;
    public static int[][] A;

    private static void rec(int idx, int n) {
        if (idx >= n * n) {
            isPossible = true;

            System.out.println("POSSIBLE");

            for (int r = 0; r < n; ++r) {
                for (int c = 0; c < n; ++c) {
                    System.out.print(A[r][c]);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

        if (isPossible) {
            return;
        }

        int r = idx / n;
        int c = idx % n;

        if (r == c) {
            rec(idx + 1, n);
        } else {
            for (int num = 1; num <= n; ++num) {
                if (!chk1[r][num] && !chk2[c][num]) {
                    A[r][c] = num;
                    chk1[r][num] = chk2[c][num] = true;

                    rec(idx + 1, n);

                    chk1[r][num] = chk2[c][num] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int test = 1; test <= T; ++test) {
            int n = in.nextInt();
            int k = in.nextInt();

            isPossible = false;

            System.out.print("Case #" + test + ": ");

            for (int di = 1 ; di <= n && !isPossible; ++di) {

                int di2 = k - di * (n - 1);

                if (1 <= di2 && di2 <= n) {
                    A = new int [n][n];
                    chk1 = new boolean[n][n + 1];
                    chk2 = new boolean[n][n + 1];

                    for (int i = 0; i < n - 1; ++i) {
                        A[i][i] = di;
                        chk1[i][di] = true;
                        chk2[i][di] = true;
                    }

                    A[n - 1][n - 1] = di2;
                    chk1[n - 1][di2] = true;
                    chk2[n - 1][di2] = true;

                    rec(0, n);
                }
            }

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
