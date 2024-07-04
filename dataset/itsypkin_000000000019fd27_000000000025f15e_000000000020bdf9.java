import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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
                interval.id = i;

                intervals.add(interval);
            }


            String result = solve(intervals);

            System.out.println("Case #" + k + ": " + result);
        }

    }

    private static String solve(List<Interval> intervals) {
        Interval jamieBusy = null;
        Interval cameronBusy = null;
        char[] result = new char[intervals.size()];

        List<Interval> sorted = intervals.stream().sorted().collect(Collectors.toList());

        for (Interval interval : sorted) {
            if (cameronBusy == null || !cameronBusy.isOverlap(interval)) {
                cameronBusy = interval;
                result[interval.id] = 'C';
            } else if (jamieBusy == null || !jamieBusy.isOverlap(interval)) {
                jamieBusy = interval;
                result[interval.id] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.copyValueOf(result);
    }
}



class Interval implements Comparable<Interval> {
    int start;
    int end;
    int id;

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

    @Override
    public int compareTo(Interval o) {
        int startCompare = Integer.compare(this.start, o.start);

        if (startCompare != 0) return startCompare;

        return Integer.compare(this.end, o.end);
    }
}
