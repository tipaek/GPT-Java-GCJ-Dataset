
import java.util.Scanner;

public class Solution {
    static boolean[] check;
    static boolean[][] r;
    static boolean[][] c;
    static int[][] a;
    private static String PATTEN = "Case #%d: %s";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int p = 1; p <= t; p++) {

            int n = sc.nextInt();
            int k = sc.nextInt();
            check = new boolean[n * n + 1];
            r = new boolean[n + 1][n + 1];
            c = new boolean[n + 1][n + 1];
            a = new int[n][n];
            dfs(0, n);
            if (!check[k]) {
                System.out.println(String.format(PATTEN, p, "IMPOSSIBLE"));
            } else {
                System.out.println(String.format(PATTEN, p, "POSSIBLE"));
            }

        }
    }

    private static void dfs(int key, int n) {
        if (key >= n * n) {
            int x = 0;
            for (int i = 0; i < n; i++) {
                x = x + a[i][i];
            }
            check[x] = true;
            return;
        }
        int row = key / n;
        int column = key % n;

        for (int i = 1; i <= n; i++) {
            if ((!r[row][i]) && (!c[column][i])) {
                r[row][i] = true;
                c[column][i] = true;
                a[row][column] = i;
                dfs(key + 1, n);
                r[row][i] = false;
                c[column][i] = false;
            }
        }
    }
}