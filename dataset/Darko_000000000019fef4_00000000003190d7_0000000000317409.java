import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        String dirs = "NESW";
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            char[] p = sc.next().toCharArray();
            String ans = "IMPOSSIBLE";
            for (int i = 0; i < p.length; i++) {
                int dir = dirs.indexOf(p[i]);
                x += dx[dir];
                y += dy[dir];
                int d = Math.abs(x) + Math.abs(y);
                if (d <= i + 1) {
                    ans = Integer.toString(i + 1);
                    break;
                }
            }

            System.out.printf("Case #%d: %s\n", tc, ans);
        }
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
