
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Periklis Ntanasis <pntanasis@gmail.com>
 */
public class Solution {

    public static void main(String[] args) {
        List<Case> cases = readCases();
        int i = 1;
        for (Case c : cases) {
            System.out.println("Case #" + (i++) + ": " + solve(c));
        }
    }

    static class Case {

        public long x;
        public long y;

    }

    static List<Case> readCases() {
        List<Case> cases = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Case c = new Case();
            c.x = in.nextLong();
            c.y = in.nextLong();
            cases.add(c);
        }
        return cases;
    }

    static public String solve(Case c) {
        long tx = Math.abs(c.x), ty = Math.abs(c.y);
        if (tx != 0 && ty != 0
                && (tx % 2 == 0 && ty % 2 == 0
                || tx % 2 == 1 && ty % 2 == 1)) {
            return "IMPOSSIBLE";
        }
        String s = "";
        long maxSteps = tx + ty;
        for (long i = 0, p = 0; p <= maxSteps; i++) {
            long j = (long) Math.pow(2, i);
            p = (long) (p + j);
            if (p == 1) {
                if (tx % 2 == 1) {
                    s = c.x < 0 || ty == 0 ? "E" : "W";
                    tx = c.x < 0 || ty == 0 ? tx - 1 : tx + 1;
                } else if (ty % 2 == 1) {
                    s = c.y < 0 || tx == 0 ? "N" : "S";
                    ty = c.y < 0 || tx == 0? ty - 1 : ty + 1;
                }
                continue;
            }
            if (tx == j) {
                if (c.x > 0) {
                    s += "E";
                } else {
                    s += "W";
                }
                tx = 0;
            } else if (ty == j) {
                if (c.y > 0) {
                    s += "N";
                } else {
                    s += "S";
                }
                ty = 0;
            } else if (tx != 0 && tx <= j && Math.abs(tx - j) < Math.abs(ty - j)) {
                s += tx - j > 0 ? "E" : "W";
                tx = tx > 0 ? tx + j : tx - j;
            } else if (ty != 0 && ty < j && Math.abs(ty - j) < Math.abs(tx - j)) {
                s += ty - j > 0 ? "N" : "S";
                ty = ty > 0 ? ty + j : ty - j;
            }
        }
        return s;
    }

}
