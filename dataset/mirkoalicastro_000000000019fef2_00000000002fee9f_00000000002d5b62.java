import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String...args) {
        final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int testCases = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String sol = solve(x, y);
            sb.append("Case #").append(i).append(": ").append(sol).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static String solve(int x, int y) {
        StringBuilder sb = new StringBuilder();
        int modx = x % 2;
        int mody = y % 2;
        if (Math.abs(modx) == Math.abs(mody))
            return IMPOSSIBLE;
        sb.append(bruteforce(x, y));
        return sb.toString();
    }

    private static String bruteforce(int x, int y) {
        StringBuilder sb = new StringBuilder();
        boolean invx = Math.abs(x) != x;
        boolean invy = Math.abs(y) != y;
        int dx = Math.abs(x);
        int dy = Math.abs(y);
        int curx = 0;
        int cury = 0;
        int jump = 1;
        while (Math.abs(dx-curx) > 1 && Math.abs(dy-cury) > 1) {
            jump = 2*jump;
            if (jump+curx > dx+1 || jump+cury > dy+1)
                return IMPOSSIBLE;
            if (dx-curx+jump > dy-cury+jump) {
                sb.append('N');
                cury += jump;
            } else {
                sb.append('E');
                curx += jump;
            }
        }
        while (dx-curx > 1) {
            jump = 2*jump;
            if (jump+curx > dx+1)
                return IMPOSSIBLE;
            sb.append('E');
            curx += jump;
        }
        while (dy-cury > 1) {
            jump = 2*jump;
            if (jump+cury > dy+1)
                return IMPOSSIBLE;
            sb.append('N');
            cury += jump;
        }
        if (dx-curx > 1 && dy-cury > 1)
            return IMPOSSIBLE;
        String sol = sb.toString();
        if (invx)
            sol = sol.replaceAll("E", "W");
        if (invy)
            sol = sol.replaceAll("N", "S");
        if (dx-curx != 0) {
            if (curx < dx) {
                sol = (x > 0 ? 'E' : 'W') + sol;
            } else {
                sol = (x > 0 ? 'W' : 'E') + sol;
            }
        }
        if (dy-cury != 0) {
            if (cury < dy) {
                sol = (y > 0 ? 'N' : 'S') + sol;
            } else {
                sol = (y > 0 ? 'S' : 'N') + sol;
            }
        }
        return sol;
    }

}