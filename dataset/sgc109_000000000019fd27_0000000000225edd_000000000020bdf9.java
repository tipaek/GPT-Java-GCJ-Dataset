import javax.swing.*;
import java.util.*;
import java.io.*;

public class Solution {

    private static class Interval implements Comparable<Interval> {
        int start, end;
        int id;

        Interval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(start, o.start);
        }
    }

    private static void assignIntervals(Interval[] intervals, char[] roleOf, char person) {
        int end = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (roleOf[intervals[i].id] != 0 || intervals[i].start < end) continue;

            roleOf[intervals[i].id] = person;
            end = intervals[i].end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tc = 1; tc <= T; tc++) {
            int N = in.nextInt();

            Interval[] intervals = new Interval[N];
            char[] roleOf = new char[N];

            for (int i = 0; i < N; i++) {
                int s = in.nextInt();
                int e = in.nextInt();

                intervals[i] = new Interval(s, e, i);
            }

            Arrays.sort(intervals);

            assignIntervals(intervals, roleOf, 'C');
            assignIntervals(intervals, roleOf, 'J');

            boolean isPossible = true;
            for (char ch : roleOf) {
                if (ch == 0) {
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + tc + ": " + (isPossible ? new String(roleOf) : "IMPOSSIBLE"));
        }
    }
}