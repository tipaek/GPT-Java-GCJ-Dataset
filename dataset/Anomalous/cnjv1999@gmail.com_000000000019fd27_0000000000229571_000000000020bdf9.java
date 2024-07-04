import java.util.*;
import java.io.*;

class Solution {
    static class Interval {
        int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int t = readInt();
        for (int ti = 1; ti <= t; ti++) {
            int n = readInt();
            StringBuilder result = new StringBuilder();
            Interval[] intervals = new Interval[n];
            int[] time = new int[1441];
            int maxOverlap = 0;

            for (int i = 0; i < n; i++) {
                int start = readInt(), end = readInt();
                intervals[i] = new Interval(start, end);
                for (int j = start; j < end; j++) {
                    time[j]++;
                    maxOverlap = Math.max(maxOverlap, time[j]);
                }
            }

            if (maxOverlap > 2) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", ti);
            } else {
                for (Interval interval : intervals) {
                    if (time[interval.start] == 2) {
                        result.append("J");
                    } else {
                        result.append("C");
                    }
                    time[interval.start]--;
                }
                System.out.printf("Case #%d: %s\n", ti, result.toString());
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