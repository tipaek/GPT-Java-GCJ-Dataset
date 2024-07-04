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
            String result = solve(sb, 0, x, y, 0, 0);
            System.out.println("Case #" + tt + ": " + (result == null ? "IMPOSSIBLE" : result));
        }
    }

    private static String solve(StringBuilder sb, int place, int x, int y, int px, int py) {

        if (x == px && y == py) {
            return sb.toString();
        }
        if (place > 8) {
            return null;
        }

        int jump = (int) Math.pow(2, place);
        sb.append('N');
        String rN = solve(sb, place + 1, x, y, px, py + jump);
        sb.deleteCharAt(place);
        sb.append('S');
        String rS = solve(sb, place + 1, x, y, px, py - jump);
        sb.deleteCharAt(place);
        sb.append('E');
        String rE = solve(sb, place + 1, x, y, px + jump, py);
        sb.deleteCharAt(place);
        sb.append('W');
        String rW = solve(sb, place + 1, x, y, px - jump, py);
        sb.deleteCharAt(place);

        int min = Integer.MAX_VALUE;
        String res = null;
        if (rN != null) {
            if (rN.length() < min) {
                min = rN.length();
                res = rN;
            }
        }
        if (rS != null) {
            if (rS.length() < min) {
                min = rS.length();
                res = rS;
            }
        }
        if (rE != null) {
            if (rE.length() < min) {
                min = rE.length();
                res = rE;
            }
        }
        if (rW != null) {
            if (rW.length() < min) {
                min = rW.length();
                res = rW;
            }
        }
        return res;
    }
}
