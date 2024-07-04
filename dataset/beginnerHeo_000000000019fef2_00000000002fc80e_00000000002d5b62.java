import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Solution
 *
 * @author dongyoung
 * @since 2020-04-04
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();// Scanner has functions to read ints, longs, strings, chars, etc.Unknown webhook
        for (int i = 1; i <= t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Problem problem = new Problem(x, y);
            problem.solve("", 0, 0, 1, 0);
            String res = problem.result;
            if (res == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + res);
            }
        }
    }

    static class Problem {
        static int[] dx = { -1, 1, 0, 0 };
        static int[] dy = { 0, 0, 1, -1 };
        static List<String> dir = Arrays.asList("W", "E", "N", "S");
        int gx;
        int gy;
        String result = null;

        public Problem(int x, int y) {
            this.gx = x;
            this.gy = y;
        }

        public void solve(String result, int x, int y, int j, int ac) {
            if (gx == x && gy == y) {
                this.result = result;
                return;
            }
            if (ac >= Math.abs(gx) + Math.abs(gy)) {
                return;
            }
            for (int i = 0; i < 4; i++) {
                int jc = jumpCnt(j);
                int nx = x + dx[i] * jc;
                int ny = y + dy[i] * jc;
                // if (isPossible(nx, ny)) {
                    StringBuilder next = new StringBuilder(result);
                    next.append(dir.get(i));
                    solve(next.toString(), nx, ny, j + 1, ac + jc);
                // }
            }
        }

        private boolean isPossible(int nx, int ny) {
            return Math.abs(nx) <= Math.abs(gx) && Math.abs(ny) <= Math.abs(gy);
        }

        private int jumpCnt(int i) {
            return 1 << (i - 1);
        }
    }
}
