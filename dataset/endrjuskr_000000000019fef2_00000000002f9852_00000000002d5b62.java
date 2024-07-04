import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = in.nextInt();
            int y = in.nextInt();

            StringBuilder bld = dfs(new StringBuilder(), x, y, 0, 0, 1);
            if(bld == null) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            } else {
                System.out.println(String.format("Case #%d: %s", t, bld.toString()));
            }

        }
    }

    public static StringBuilder dfs(StringBuilder w, int x, int y, int cx, int cy, int c) {
        if (x == cx && y == cy) {
            return w;
        }

        if(c > (Math.abs(2 * x) + Math.abs(2 * y))) return null;

        StringBuilder res = null;
        StringBuilder bld = new StringBuilder(w);
        bld.append('E');
        bld = dfs(bld, x, y, cx + c, cy, c * 2);
        if (bld != null && (res == null || res.length() > bld.length())) { res = bld; }
        bld = new StringBuilder(w);
        bld.append('W');
        bld = dfs(bld, x, y, cx - c, cy, c * 2);
        if (bld != null && (res == null || res.length() > bld.length())) { res = bld; }
        bld = new StringBuilder(w);
        bld.append('N');
        bld = dfs(bld, x, y, cx, cy+c, c * 2);
        if (bld != null && (res == null || res.length() > bld.length())) { res = bld; }
        bld = new StringBuilder(w);
        bld.append('S');
        bld = dfs(bld, x, y, cx, cy - c, c * 2);
        if (bld != null && (res == null || res.length() > bld.length())) { res = bld; }

        return res;
    }
}