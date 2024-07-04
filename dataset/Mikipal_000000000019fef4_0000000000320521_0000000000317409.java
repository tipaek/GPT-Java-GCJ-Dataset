
import java.util.*;
import java.io.*;

public class Solution {

    static int cc = 1;
    static int x, y;
    static char moves[];

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            x = in.nextInt();
            y = in.nextInt();
            moves = in.nextLine().toCharArray();

            cc = i;
            solve();
        }
    }

    static void solve() {
        int movest = 1;
        boolean found = false;
        point me = new point(x, y);
        point path[] = getPath();
        for (int i = 1; i<path.length; i++) {
            point p = path[i];
            //System.out.println(p.x + ", " + p.y);

            if ((false ? (Math.abs(me.x - p.x) > Math.abs(me.y - p.y)) : (Math.abs(me.x - p.x) >= Math.abs(me.y - p.y)))) {
                //System.out.println("horiz");
                if (p.x > me.x) {
                    me.x++;
                } else if (p.x == me.x) {

                } else {
                    me.x--;
                }
            } else {
                //System.out.println("vert");
                if (p.y > me.y) {
                    me.y++;
                } else if (p.y == me.y) {

                } else {
                    me.y--;
                }
            }
            
            if ((me.x == p.x) && (me.y == p.y)) {
                System.out.println("Case #" + cc + ": " + movest);
                found = true;
                break;
            }
            

            //System.out.println("ME: " + me.x + ", " + me.y);

            movest++;

        }

        if (!found) {
            System.out.println("Case #" + cc + ": IMPOSSIBLE");
        }

    }

    static point[] getPath() {
        point res[] = new point[moves.length];
        int added = 0;
        point cur = new point(0, 0);
        for (char c : moves) {
            switch (c) {
                case 'S':
                    cur.y++;
                    break;
                case 'N':
                    cur.y--;
                    break;
                case 'W':
                    cur.x--;
                    break;
                case 'E':
                    cur.x++;
                    break;
            }
            res[added] = new point(cur.x, cur.y);
            added++;
        }
        return res;
    }

    public static class point {

        public int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
