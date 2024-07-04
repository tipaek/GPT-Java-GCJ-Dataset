import java.util.*;
import java.io.*;

class Solution {
    static class Interval {
        int start, end, index;
        
        public Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        solve();
    }
    
    public static void solve() {
        int t = readInt();
        for (int ti = 1; ti <= t; ti++) {
            int n = readInt();
            char[] result = new char[n];
            Interval[] intervals = new Interval[n];
            int[] timeSlots = new int[1441];
            int maxOverlap = 0;
            
            for (int i = 0; i < n; i++) {
                int start = readInt();
                int end = readInt();
                intervals[i] = new Interval(start, end, i);
                for (int j = start; j < end; j++) {
                    timeSlots[j]++;
                }
            }
            
            for (int i = 0; i < 1441; i++) {
                maxOverlap = Math.max(maxOverlap, timeSlots[i]);
            }
            
            if (maxOverlap > 2) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", ti);
            } else {
                char[] current = new char[1441];
                Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
                
                for (Interval interval : intervals) {
                    if (current[interval.start] == 'C') {
                        result[interval.index] = 'J';
                        for (int j = interval.start; j < interval.end; j++) {
                            current[j] = 'J';
                        }
                    } else {
                        result[interval.index] = 'C';
                        for (int j = interval.start; j < interval.end; j++) {
                            current[j] = 'C';
                        }
                    }
                }
                
                System.out.printf("Case #%d: %s\n", ti, new String(result));
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
    
    static double readDouble() {
        return Double.parseDouble(next());
    }
    
    static String readLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}