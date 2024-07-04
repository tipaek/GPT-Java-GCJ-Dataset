import java.util.*;
import java.io.*;

class Solution {
        
    public static void main(String[] args) {
        solve();
    }
    
    public static void solve() {
        int t = readInt();
        for (int ti = 1; ti <= t; ti++) {
            long x = readLong();
            long y = readLong();
            String str = next();
            long minDistance = Integer.MAX_VALUE;
            long minTime = Integer.MAX_VALUE;
            boolean reachable = false;
            
            long initialDistance = Math.abs(x) + Math.abs(y);
            long time = 0;
            if (initialDistance <= time) {
                reachable = true;
                minDistance = initialDistance;
                minTime = time;
            }
            for (char c : str.toCharArray()) {
                switch (c) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                
                long currentDistance = Math.abs(x) + Math.abs(y);
                time++;
                
                if (currentDistance <= time) {
                    reachable = true;
                    minDistance = Math.min(currentDistance, minDistance);
                    minTime = Math.min(time, minTime);
                }
            }
            if (reachable) {
                printf("Case %d: %d\n", ti, minTime);
            } else {
                printf("Case %d: IMPOSSIBLE\n", ti);
            }
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int readInt() {
        return Integer.parseInt(next());
    }

    static long readLong() {
        return Long.parseLong(next());
    }

    static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}