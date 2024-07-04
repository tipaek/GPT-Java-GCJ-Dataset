import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int t = readInt();
        for (int ti = 1; ti <= t; ti++) {
            long x = readLong();
            long y = readLong();
            String str = readNext();
            long minTime = Long.MAX_VALUE;
            boolean reached = false;

            long initialDist = Math.abs(x) + Math.abs(y);
            if (initialDist == 0) {
                reached = true;
                minTime = 0;
            }

            for (int time = 1; time <= str.length(); time++) {
                char c = str.charAt(time - 1);
                switch (c) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                long currentDist = Math.abs(x) + Math.abs(y);
                if (currentDist <= time) {
                    reached = true;
                    minTime = Math.min(minTime, time);
                }
            }

            if (reached) {
                System.out.printf("Case %d: %d\n", ti, minTime);
            } else {
                System.out.printf("Case %d: IMPOSSIBLE\n", ti);
            }
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static String readNext() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    private static int readInt() {
        return Integer.parseInt(readNext());
    }

    private static long readLong() {
        return Long.parseLong(readNext());
    }
}