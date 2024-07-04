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
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = readInt();
            StringBuilder result = new StringBuilder();
            Interval[] intervals = new Interval[n];
            int[] timeSlots = new int[1441];
            int maxOverlap = 0;

            for (int i = 0; i < n; i++) {
                int start = readInt();
                int end = readInt();
                intervals[i] = new Interval(start, end, i);

                for (int t = start; t < end; t++) {
                    timeSlots[t]++;
                    maxOverlap = Math.max(maxOverlap, timeSlots[t]);
                }
            }

            if (maxOverlap > 2) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                char[] schedule = new char[1441];
                for (Interval interval : intervals) {
                    boolean assignedToC = false;

                    for (int t = interval.start; t < interval.end && !assignedToC; t++) {
                        if (schedule[t] == 'C') {
                            assignedToC = true;
                        }
                    }

                    if (assignedToC) {
                        result.append("J");
                        for (int t = interval.start; t < interval.end; t++) {
                            schedule[t] = 'J';
                        }
                    } else {
                        result.append("C");
                        for (int t = interval.start; t < interval.end; t++) {
                            schedule[t] = 'C';
                        }
                    }
                }
                System.out.printf("Case #%d: %s\n", testCase, result.toString());
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() {
        while (st == null || !st.hasMoreTokens()) {
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