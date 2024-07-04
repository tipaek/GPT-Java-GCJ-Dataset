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
            intervals.add(new Interval(in.nextInt(), in.nextInt()));
        }
        // sort by start time in ascending order
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        StringBuilder sb = new StringBuilder();
        Interval j = null;
        Interval c = null;
        for (Interval i : intervals) {
            if (j == null) {
                j = i;
                sb.append('J');
            } else if (c == null) {
                c = i;
                sb.append('C');
            } else {
                if (j.end > i.start && c.end > i.start) {
                    return "IMPOSSIBLE";
                }
                if (j.end <= i.start) {
                    j = i;
                    sb.append('J');
                } else {
                    c = i;
                    sb.append('C');
                }
            }
        }
        return sb.toString();
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}