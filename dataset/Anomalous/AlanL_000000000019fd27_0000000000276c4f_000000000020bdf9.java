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
            Integer[][] intervals = new Integer[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = readInt();
                intervals[i][1] = readInt();
            }
            System.out.print("Case #" + z + ": ");
            String result = scheduleIntervals(intervals);
            System.out.println(result);
        }
    }

    static String scheduleIntervals(Integer[][] intervals) {
        boolean canAssign = true;
        String current = "J";
        StringBuilder assignment = new StringBuilder();
        int endJ = 0, startJ = Integer.MAX_VALUE;
        int endC = 0, startC = Integer.MAX_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            if (current.equals("J")) {
                if (endJ <= intervals[i][0]) {
                    endJ = intervals[i][1];
                    if (startJ == Integer.MAX_VALUE) startJ = intervals[i][0];
                    assignment.append("J");
                } else if (startJ >= intervals[i][1]) {
                    startJ = intervals[i][0];
                    assignment.append("J");
                } else {
                    current = "C";
                    i--;
                    continue;
                }
            } else {
                if (endC <= intervals[i][0]) {
                    endC = intervals[i][1];
                    if (startC == Integer.MAX_VALUE) startC = intervals[i][0];
                    assignment.append("C");
                } else if (startC >= intervals[i][1]) {
                    startC = intervals[i][0];
                    assignment.append("C");
                } else {
                    current = "J";
                    i--;
                    continue;
                }
            }
        }

        if (!canAssign) return "IMPOSSIBLE";
        return assignment.toString();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(input.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
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
}