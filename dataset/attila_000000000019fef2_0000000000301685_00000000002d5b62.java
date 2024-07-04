//package codejam2020b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int ttt = Integer.parseInt(sc.readLine());
        for (int tt = 1; tt <= ttt; tt++) {
            String[] line = sc.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            StringBuilder sb = new StringBuilder();
            boolean result = solve(sb, x, y);
            System.out.println("Case #" + tt + ": " + (result ? sb.toString() : "IMPOSSIBLE"));
        }
    }

    private static boolean solve(StringBuilder sb, long x, long y) {

        if (x == 0 && y == 1) {
            sb.append('N');
            return true;
        }
        if (x == 0 && y == -1) {
            sb.append('S');
            return true;
        }
        if (x == 1 && y == 0) {
            sb.append('E');
            return true;
        }
        if (x == -1 && y == 0) {
            sb.append('W');
            return true;
        }

        if (x == 0 && y == 0) {
            return true;
        }
        if ((x % 2 == 1 || x % 2 == -1) && (y % 2 == 1 || y % 2 == -1)) {
            return false;
        }
        if (x % 2 == 0 && y % 2 == 0) {
            return false;
        }

        if (x % 2 == 1 || x % 2 == -1) {
            // EW
            sb.append("W");
            boolean ok = solve(sb, (x + 1) / 2, y / 2);
            if (ok) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("E");
            ok = solve(sb, (x - 1) / 2, y / 2);
            if (ok) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            return false;
        }

        if (y % 2 == 1 || y % 2 == -1) {
            // NS
            sb.append("S");
            boolean ok = solve(sb, x / 2, (y + 1) / 2);
            if (ok) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("N");
            ok = solve(sb, x / 2, (y - 1) / 2);
            if (ok) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            return false;
        }

        throw new IllegalStateException("??");
    }
}
