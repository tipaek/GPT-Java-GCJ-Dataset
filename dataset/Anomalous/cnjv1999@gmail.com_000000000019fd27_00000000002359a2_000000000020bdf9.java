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
        int testCases = readInt();
        for (int t = 1; t <= testCases; t++) {
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
                    maxOverlap = Math.max(maxOverlap, timeSlots[j]);
                }
            }

            if (maxOverlap > 2) {
                printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                char[] schedule = new char[1441];
                Arrays.sort(intervals, Comparator.comparingInt((Interval iv) -> iv.start).thenComparingInt(iv -> iv.end));

                for (Interval interval : intervals) {
                    boolean assignedToC = false;
                    for (int i = interval.start; i < interval.end && !assignedToC; i++) {
                        if (schedule[i] == 'C') {
                            assignedToC = true;
                        }
                    }
                    if (assignedToC) {
                        result[interval.index] = 'J';
                        for (int i = interval.start; i < interval.end; i++) {
                            schedule[i] = 'J';
                        }
                    } else {
                        result[interval.index] = 'C';
                        for (int i = interval.start; i < interval.end; i++) {
                            schedule[i] = 'C';
                        }
                    }
                }
                printf("Case #%d: %s\n", t, new String(result));
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

    static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}