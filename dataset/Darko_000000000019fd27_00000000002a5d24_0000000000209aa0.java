import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private void work() {
        m = new HashMap<>();
        for (int i = 2; i <= 5; i++) gen(i);
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (n > 5 || k < n || k > n * n) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
                continue;
            }

            if (!m.get(n).containsKey(k)) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", tc);
            } else {
                System.out.printf("Case #%d: POSSIBLE\n", tc);
                print(n, m.get(n).get(k));
            }
        }
        sc.close();
    }

    private void print(int n, int[][] b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] a;
    private Map<Integer, Map<Integer, int[][]>> m;

    private void gen(int n) {
        a = new int[n][n];
        m.put(n, new HashMap<>());
        go(n, 0, 0);
    }

    private void go(int n, int r, int c) {
        if (c == n) {
            go(n, r + 1, 0);
            return;
        }

        if (r == n) {
            int t = 0;
            for (int i = 0; i < n; i++) t += a[i][i];
            if (!m.get(n).containsKey(t)) {
                int[][] b = new int[n][n];
                for (int i = 0; i < n; i++) System.arraycopy(a[i], 0, b[i], 0, n);
                m.get(n).put(t, b);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            boolean used = false;
            for (int j = 0; j < c && !used; j++) {
                if (a[r][j] == i) {
                    used = true;
                }
            }

            for (int j = 0; j < r && !used; j++) {
                if (a[j][c] == i) {
                    used = true;
                }
            }

            if (!used) {
                a[r][c] = i;
                go(n, r, c + 1);
            }
        }
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
