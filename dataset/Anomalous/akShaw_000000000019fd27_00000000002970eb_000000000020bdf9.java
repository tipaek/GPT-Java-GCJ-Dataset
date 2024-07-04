import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(sc.nextInt(), sc.nextInt());
            }

            results[i] = "Case #" + (i + 1) + ": " + getResult(intervals);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String getResult(Interval[] intervals) {
        ArrayList<Interval> cameron = new ArrayList<>();
        ArrayList<Interval> jamie = new ArrayList<>();
        StringBuilder result = new StringBuilder("C");

        cameron.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (!isBusy(cameron, intervals[i])) {
                result.append("C");
                cameron.add(intervals[i]);
            } else if (!isBusy(jamie, intervals[i])) {
                result.append("J");
                jamie.add(intervals[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean isBusy(ArrayList<Interval> parent, Interval interval) {
        for (Interval existingInterval : parent) {
            if (intervalOverlaps(existingInterval, interval)) {
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