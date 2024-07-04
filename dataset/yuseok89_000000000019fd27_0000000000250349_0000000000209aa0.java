import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static boolean isPossible = false;
    public static boolean[][] chk1;
    public static boolean[][] chk2;
    public static int[][] A;

    private static void rec(int idx, int n, int k, int sum) {
        if (idx >= n * n) {
            if (sum == k) {
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

            return;
        }

        if (isPossible) {
            return;
        }

        int r = idx / n;
        int c = idx % n;

        for (int num = 1; num <= n; ++num) {
            if (!chk1[r][num] && !chk2[c][num]) {
                A[r][c] = num;
                chk1[r][num] = chk2[c][num] = true;

                rec(idx + 1, n, k, sum + (r == c ? num : 0));

                chk1[r][num] = chk2[c][num] = false;
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

            A = new int [n][n];
            chk1 = new boolean[n][n + 1];
            chk2 = new boolean[n][n + 1];

            rec(0, n, k, 0);

            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
