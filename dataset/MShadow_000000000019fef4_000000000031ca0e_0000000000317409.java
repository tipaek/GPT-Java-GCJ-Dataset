import java.util.Scanner;

public class Solution {

    static String dirS = "EWSN";
    static int[][] dirA = {{1,0},{-1,0},{0,-1},{0,1}};

    private static String solve(int x, int y, String s) {
        if (x == 0 && y == 0) return "0";
        if (x < 0) {
            x = -x;
            s.replace('E', 'X');
            s.replace('W', 'E');
            s.replace('X', 'W');
        }
        if (y < 0) {
            y = -y;
            s.replace('N', 'X');
            s.replace('S', 'N');
            s.replace('X', 'S');
        }

        int xx = x, yy = y, sum;
        int[] next;
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i-1);
            next = walk(xx, yy, ch);
            xx = next[0];
            yy = next[1];
            sum = Math.abs(next[0]) + Math.abs(next[1]);
            if (sum <= i) {
                return String.valueOf(i);
            }
        }

        return "IMPOSSIBLE";
    }

    private static int[] walk(int x, int y, char ch) {
        int idx = dirS.indexOf(ch);
        int[] dir = dirA[idx];
        int[] res = new int[2];
        res[0] = x + dir[0];
        res[1] = y + dir[1];
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            System.out.println("Case #" + ks + ": " + solve(x, y, s));
        }
    }
}