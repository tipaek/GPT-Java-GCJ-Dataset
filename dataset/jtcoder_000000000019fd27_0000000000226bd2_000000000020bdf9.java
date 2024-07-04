import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    boolean canMakeIt(Interval newActivity, List<Interval> activities, Interval[] intervalsArr) {
        boolean canMakeIt = true;
        for (Interval activityToCheck : activities) {
            if (activityToCheck.hasOverlap(newActivity)) {
                canMakeIt = false;
            }
        }
        return canMakeIt;
    }

    private String schedule(Interval[] intervalsArr) {
        List<Interval> cActivities = new ArrayList<>();
        List<Interval> jActivities = new ArrayList<>();
        StringBuffer sb = new StringBuffer(intervalsArr.length);
        for (Interval interval : intervalsArr) {
            if (canMakeIt(interval, cActivities, intervalsArr)) {
                cActivities.add(interval);
            } else if (canMakeIt(interval, jActivities, intervalsArr)) {
                jActivities.add(interval);
            } else {
                return "IMPOSSIBLE";
            }
            sb.append('C');
        }
        for (Interval interval : jActivities) {
            sb.setCharAt(interval.order, 'J');
        }
        return sb.toString();
    }

    private void run() throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int intervals = sc.nextInt();
            Interval[] intervalsArr = new Interval[intervals];
            for (int j = 0; j < intervals; j++) {
                intervalsArr[j] = new Interval(sc.nextInt(), sc.nextInt(), j);
            }
            Arrays.sort(intervalsArr);
            System.out.println("Case #" + i + ": " + schedule(intervalsArr));
        }
        sc.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int order;

    public Interval(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }

    boolean hasOverlap(Interval n) {
        return !((this.end <= n.start) || (this.start >= n.end));
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.valueOf(this.start).compareTo(o.end);
    }

    public String toString() {
        return "start=" + this.start + " end=" + this.end;
    }

}