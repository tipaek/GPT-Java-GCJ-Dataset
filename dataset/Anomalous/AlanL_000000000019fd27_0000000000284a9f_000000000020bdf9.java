import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int z = 1; z <= t; z++) {
            int n = readInt();
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(readInt(), readInt());
            }

            System.out.print("Case #" + z + ": ");
            if (assignTasks(intervals)) {
                System.out.println(getSchedule(intervals));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static boolean assignTasks(Interval[] intervals) {
        int[] a = new int[24 * 60 + 1];
        int[] b = new int[24 * 60 + 1];
        boolean first = true, second = true;
        String cur = "je";

        for (Interval interval : intervals) {
            if (cur.equals("je")) {
                if (canAssign(interval, a)) {
                    assign(interval, a);
                    interval.assignedTo = 'J';
                    first = true;
                    second = true;
                } else {
                    first = false;
                    if (second) {
                        cur = "ce";
                        continue;
                    } else {
                        return false;
                    }
                }
            } else {
                if (canAssign(interval, b)) {
                    assign(interval, b);
                    interval.assignedTo = 'C';
                    first = true;
                    second = true;
                } else {
                    second = false;
                    if (first) {
                        cur = "je";
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean canAssign(Interval interval, int[] schedule) {
        for (int j = interval.start; j < interval.end; j++) {
            if (schedule[j] != 0) {
                return false;
            }
        }
        return true;
    }

    static void assign(Interval interval, int[] schedule) {
        for (int j = interval.start; j < interval.end; j++) {
            schedule[j] = 1;
        }
    }

    static String getSchedule(Interval[] intervals) {
        StringBuilder ans = new StringBuilder();
        for (Interval interval : intervals) {
            ans.append(interval.assignedTo);
        }
        return ans.toString();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }

    static class Interval {
        int start, end;
        char assignedTo;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}