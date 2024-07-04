import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(int x, int y, char[] m) {
        int ans = 0, i = 0;

        for (i = 0; i < Math.min(x, m.length); i++) {
            if (m[i] == 'N') y++;
            else if (m[i] == 'S') y--;

            ans++;
        }

        if (ans < x) return -1;

        int myY = 0;

        while (myY != y) {
            if (i == m.length) return -1;

            if (y > myY) {
                if (y - myY > 1) myY++;

                if (m[i] == 'N') y++;
                else if (m[i] == 'S') y--;

                ans++;
                i++;
            } else if (y < myY) {
                if (myY - y > 1) myY--;

                if (m[i] == 'N') y++;
                else if (m[i] == 'S') y--;

                ans++;
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int x = in.nextInt(), y = in.nextInt();
            String m = in.next();

            int ans = testCase(x, y, m.toCharArray());

            System.out.println(String.format("Case %s: %s", t0, ans == -1 ? "IMPOSSIBLE" : Integer.toString(ans)));
        }
    }
}
