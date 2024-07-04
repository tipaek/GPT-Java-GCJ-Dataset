import java.util.Scanner;
import java.util.*;

public class Solution {

    public static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static final String BIG = "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for(int u=1; u <= t; u++) {

            int x = input.nextInt();
            int y = input.nextInt();

            int xDist = x - 0;
            int yDist = y - 0;
            String out = "";

            if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
                out = IMPOSSIBLE;
            } else {

                out = choose("", 0, 0, 0, x, y, -1);

                if (BIG.equals(out)) out = IMPOSSIBLE;
            }
            System.out.println("Case #" + u + ": " + out);
        }
    }

    public static String choose(String curStr, int x, int y, int level, int tx, int ty, int type) {
        int add = 1 << level;
        //if (level > 16) return curStr;
        //System.out.println(curStr + " : " + level);
        boolean xFound = false;
        boolean yFound = false;
        if (tx == x) xFound = true;
        if (ty == y) yFound = true;
        if (tx == x && ty == y) return curStr;

        if ((tx < 0 && (x < tx || x > -tx) || tx > 0 && (x > tx || x < -tx))) return BIG;
        if ((ty < 0 && (y < ty || y > -ty)) || ty > 0 && (y > ty || y < -ty)) return BIG;

        ArrayList<String> minChecks = new ArrayList<String>();
        if (!yFound) {
            String y1 = choose(curStr + "S", x, y - add, level + 1 , tx, ty, 1);
            String y2 = choose(curStr + "N", x, y + add, level + 1, tx, ty, 2);
            minChecks.add(y1);
            minChecks.add(y2);
        }

        if (!xFound) {
            String x1 = choose(curStr + "E", x + add, y, level + 1, tx, ty, 3);
            String x2 = choose(curStr + "W", x - add, y, level + 1, tx, ty, 4);
            minChecks.add(x1);
            minChecks.add(x2);
        }
        return minStr(minChecks);
    }

    public static String minStr(ArrayList<String> s) {

        int minLen = s.get(0).length();
        String minS = s.get(0);
        for(int i=1; i < s.size(); i++) {
            if (s.get(i).length() < minLen) {
                minLen = s.get(i).length();
                minS = s.get(i);
            }
        }

        return minS;
    }
    public static boolean isPowerOf2(int x) {
        return x!=0 && ((x&(x-1)) == 0);
    }

    public static int getPower(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}