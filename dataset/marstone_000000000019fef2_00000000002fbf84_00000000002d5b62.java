import java.util.Scanner;

/**
 * Pattern Matching (5pts, 5pts, 18pts)
 */
public class Solution {

    public static char[] DS = new char[] { 'E', 'S', 'W', 'N' };

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String result = null;
            for(char dir : DS) {
                String next = jump(1, dir, 1, 0, 0, X, Y);
                if(null != next) {
                    // possible & shorter
                    if(null == result || result.length() > next.length()) {
                        result = next;
                    }
                }
            }
            System.out.format("Case #%d: %s\n", t, null == result ? "IMPOSSIBLE" : result);
        }
    }

    static String jump(int r, char d, int s, int x, int y, int X, int Y) {
        if(r > 32) {
            return null;
        }
        // jump
        switch (d) {
            case 'E':
                x += s;
                break;
            case 'W':
                x -= s;
                break;
            case 'S':
                y -= s;
                break;
            case 'N':
                y += s;
                break;
        }
        int xd = Math.abs(x - X);
        int yd = Math.abs(y - Y);
        // success
        if(xd == 0 && yd == 0) {
            return Character.toString(d);
        }

        s = s << 1;
        int s2 = s << 1;
        // impossible
        if((xd != 0 && xd != s && xd < s2) || (yd != 0 && yd != s && yd < s2)) {
            return null;
        }
        // recursive
        String result = null;
        for(char dir : DS) {
            if(xd == 0 && (dir == 'E' || dir == 'W')) {
                continue;
            }
            if(yd == 0 && (dir == 'N' || dir == 'S')) {
                continue;
            }
            String next = jump(r + 1, dir, s, x, y, X, Y);
            if(null != next) {
                // possible & shorter
                if(null == result || result.length() > next.length()) {
                    result = next;
                }
            }
        }
        return null == result ? null : d + result;
    }

}
