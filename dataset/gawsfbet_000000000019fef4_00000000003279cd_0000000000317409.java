import java.util.*;
import java.io.*;

public class Solution {

    public static int testCase(int theirX, int theirY, char[] m) {
        int ans = 0, i = 0;
        int myX = 0, myY = 0;

        while (i < m.length && !(myX == theirX && myY == theirY)) {
            int diffX = Math.abs(theirX - myX), diffY = Math.abs(theirY - myY);

            if (theirX > myX && theirY > myY) {//NE
                if (m[i] == 'N' || m[i] == 'W') myY++;
                else myX++;
            } else if (theirX < myX && theirY > myY) {//NW
                if (m[i] == 'N' || m[i] == 'E') myY++;
                else myX--;
            } else if (theirX > myX && theirY < myY) {//SE
                if (m[i] == 'S' || m[i] == 'W') myY--;
                else myX++;
            } else if (theirX < myX && theirY < myY) {//SW
                if (m[i] == 'S' || m[i] == 'E') myY--;
                else myX--;
            } else if (theirX == myX) {
                if (theirY > myY) {//N
                    if (m[i] == 'E') myX++;
                    else if (m[i] == 'W') myX--;
                    else if (m[i] == 'N' || (m[i] == 'S' && diffY > 1)) myY++;
                } else {//S
                    if (m[i] == 'E') myX++;
                    else if (m[i] == 'W') myX--;
                    else if (m[i] == 'S' || (m[i] == 'N' && diffY > 1)) myY++;
                }
            } else if (theirY == myY) {
                if (theirX > myX) {//E
                    if (m[i] == 'N') myY++;
                    else if (m[i] == 'S') myY--;
                    else if (m[i] == 'E' || (m[i] == 'W' && diffX > 1)) myX++;
                } else {//W
                    if (m[i] == 'N') myY++;
                    else if (m[i] == 'S') myY--;
                    else if (m[i] == 'W' || (m[i] == 'E' && diffX > 1)) myX++;
                }
            }


            if (m[i] == 'N') theirY++;
            else if (m[i] == 'S') theirY--;

            if (m[i] == 'E') theirX++;
            else if (m[i] == 'W') theirX--;

            i++;
            ans++;
        }

        return !(myX == theirX && myY == theirY) && i == m.length ? -1 : ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t0 = 1; t0 <= t; ++t0) {
            int x = in.nextInt(), y = in.nextInt();
            String m = in.next();

            int ans = testCase(x, y, m.toCharArray());

            //System.out.println(x+ " " + y + " " + m);
            System.out.println(String.format("Case %s: %s", t0, ans == -1 ? "IMPOSSIBLE" : Integer.toString(ans)));
        }
    }
}
