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
        int testCases = readInt();
        for (int t = 1; t <= testCases; t++) {
            int n = readInt();
            StringBuilder result = new StringBuilder();
            Interval[] intervals = new Interval[n];
            int[] timeSlots = new int[1441];
            int maxOverlap = 0;

            for (int i = 0; i < n; i++) {
                int start = readInt();
                int end = readInt();
                intervals[i] = new Interval(start, end);
                for (int j = start; j < end; j++) {
                    timeSlots[j]++;
                    maxOverlap = Math.max(maxOverlap, timeSlots[j]);
                }
            }

            if (maxOverlap > 2) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                for (Interval interval : intervals) {
                    if (timeSlots[interval.start] == 1) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
                System.out.printf("Case #%d: %s\n", t, result.toString());
            }
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer;

    static String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
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
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}