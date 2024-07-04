import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }


    private static String solve(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();
        Deque<P> q = new ArrayDeque<>();
        q.add(new P(0,0, null));
        long step = 1;
        P target = null;
        boolean found = false;
        while (!found && step < 1000) {
            int sz = q.size();
            while (sz-- > 0) {
                P cur = q.poll();
                long[][] ds = {{step,0},{-step,0},{0,step},{0,-step}};
                for (long[] d : ds) {
                    if (cur.x+d[0] == n && cur.y+d[1] == m) {
                        found = true;
                        target = new P(cur.x+d[0] , cur.y+d[1], cur);
                    } else {
                        q.offer(new P(cur.x+d[0] , cur.y+d[1], cur));
                    }
                }
            }
            step <<= 1;
        }
        if (target == null) return "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder();
        do {
            long xd = target.x - target.prev.x;
            long yd = target.y - target.prev.y;
            if (xd != 0) {
                sb.append(xd > 0 ? "E" : "W");
            } else {
                sb.append(yd > 0 ? "N" : "S");
            }
            target = target.prev;
        } while (target.prev != null);
        return sb.reverse().toString();
    }

    static class P {
        long x = 0;
        long y = 0;
        P prev = null;
        public P(long x, long y, P prev) {
            this.x = x;
            this.y = y;
            this.prev = prev;
        }

    }
}