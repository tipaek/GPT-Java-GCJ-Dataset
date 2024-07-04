import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] res = new String[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(sc.nextInt(), sc.nextInt());
            }

            res[i] = "Case #" + (i + 1) + ": " + getResult(intervals);
        }

        for (String result : res) {
            System.out.println(result);
        }
    }

    private static String getResult(Interval[] intervals) {
        List<Interval> cameron = new ArrayList<>();
        List<Interval> jamie = new ArrayList<>();
        StringBuilder res = new StringBuilder("C");

        cameron.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (!isBusy(cameron, intervals[i])) {
                res.append("C");
                cameron.add(intervals[i]);
            } else if (!isBusy(jamie, intervals[i])) {
                res.append("J");
                jamie.add(intervals[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return res.toString();
    }

    private static boolean isBusy(List<Interval> intervals, Interval interval) {
        for (Interval current : intervals) {
            if (intervalOverlaps(current, interval)) {
                return true;
            }
        }
        return false;
    }

    private static boolean intervalOverlaps(Interval a, Interval b) {
        return !(a.getEi() <= b.getSi() || a.getSi() >= b.getEi());
    }
}

class Interval {
    private final int si;
    private final int ei;

    public Interval(int si, int ei) {
        this.si = si;
        this.ei = ei;
    }

    public int getSi() {
        return si;
    }

    public int getEi() {
        return ei;
    }
}