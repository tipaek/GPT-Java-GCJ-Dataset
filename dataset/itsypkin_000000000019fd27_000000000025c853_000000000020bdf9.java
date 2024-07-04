import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author itsypkin
 * @since 04.04.20
 */
public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

//        4
//        3
//        360 480
//        420 540
//        600 660

//        System.out.println(t);

        for (int k = 1; k <= t; ++k) {

            List<Interval> intervals = new ArrayList<>();

            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Interval interval = new Interval();
                interval.start = start;
                interval.end = end;

                intervals.add(interval);
            }

//            System.out.println("input" + k + ": " + intervals);
            String result = solve(intervals);

            System.out.println("Case #" + k + ": " + result);
        }

    }

    private static String solve(List<Interval> intervals) {
        Interval jamieBusy = null;
        Interval cameronBusy = null;

        StringBuilder sb = new StringBuilder();

        for (Interval interval : intervals) {
            if (cameronBusy == null || !cameronBusy.isOverlap(interval)) {
                cameronBusy = interval;
                sb.append('C');
            } else if (jamieBusy == null || !jamieBusy.isOverlap(interval)) {
                jamieBusy = interval;
                sb.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }
}



class Interval {
    int start;
    int end;

    public boolean isOverlap(Interval that) {
        if (this.end > that.start && this.start < that.start) return true;

        if (that.end > this.start && that.start < this.start) return true;

        if (this.end > that.end && this.start < that.end) return true;

        if (that.end > this.end && that.start < this.end) return true;


        return false;
    }

    @Override
    public String toString() {
        return "[" + start + " : " + end + "]";
    }
}
