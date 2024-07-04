import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve(in));
        }
        in.close();
    }

    static String solve(Scanner in) {
        int n = in.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new Interval(in.nextInt(), in.nextInt(), i));
        }

        // sort by start time in ascending order
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        Interval j = null;
        Interval c = null;
        for (Interval i : intervals) {
            if (c == null || c.end <= i.start) {
                c = i;
                i.setWho("C");
            } else if (j == null || j.end <= i.start) {
                j = i;
                i.setWho("J");
            } else {
                // if (j.end > i.start && c.end > i.start) {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(intervals, (i1, i2) -> i1.index - i2.index);
        for (Interval i : intervals) {
            sb.append(i.who);
        }
        return sb.toString();
    }

    static class Interval {
        int start;
        int end;
        int index;
        String who; // who performed this activity

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.who = null;
        }

        void setWho(String who) {
            this.who = who;
        }
    }
}