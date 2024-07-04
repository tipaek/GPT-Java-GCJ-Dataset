import java.util.*;
import java.io.*;

// Qualification Round 2020: Problem C - Parenting Partnering
//
public class Solution {
    private static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int compareTo(Interval other) {
            return start - other.start;
        }

        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }

    public static String solve(int N, Interval[] intervals) {
        Arrays.sort(intervals);
        Interval[] assign = new Interval[2];
        assign[0] = new Interval(0, 0, -1);
        assign[1] = new Interval(0, 0, -1);
        char[] turns = new char[]{'C', 'J'};
        char[] res = new char[N];
        outer: for (Interval cur : intervals) {
            for (int i = 0; i < 2; i++) {
                if (cur.start >= assign[i].end) {
                    assign[i] = cur;
                    res[assign[i].index] = turns[i];
                    continue outer;
                }
            }
            return null;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Scanner in =
            new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            out.format("Case #%d: ", i);
            printResult(in, out);
        }
    }

    private static void printResult(Scanner in, PrintStream out) {
        int N = in.nextInt();
        Interval[] intervals = new Interval[N];
        for (int i = 0; i < N; i++) {
            intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
        }
        String res = solve(N, intervals);
        out.println((res == null) ? "IMPOSSIBLE" : res);
    }
}
