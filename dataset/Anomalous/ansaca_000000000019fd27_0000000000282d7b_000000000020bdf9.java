import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        
        for (int n = 1; n <= cases; n++) {
            int activities = sc.nextInt();
            boolean possible = true;
            Interval[] intervals = new Interval[activities];
            Interval[] sortedIntervals = new Interval[activities];
            Interval lastC = null, lastJ = null;
            IntervalComparator comparator = new IntervalComparator();

            for (int i = 0; i < activities; i++) {
                Interval temp = new Interval(sc.nextInt(), sc.nextInt());
                intervals[i] = temp;
                sortedIntervals[i] = temp;
            }

            Arrays.sort(sortedIntervals, comparator);

            for (int i = 0; i < activities; i++) {
                if (isPossible(sortedIntervals[i], lastC)) {
                    sortedIntervals[i].madeBy = 'C';
                    lastC = sortedIntervals[i];
                } else if (isPossible(sortedIntervals[i], lastJ)) {
                    sortedIntervals[i].madeBy = 'J';
                    lastJ = sortedIntervals[i];
                } else {
                    possible = false;
                    break;
                }
            }

            String result;
            if (possible) {
                StringBuilder builder = new StringBuilder(activities);
                for (int i = 0; i < activities; i++) {
                    builder.append(intervals[i].madeBy);
                }
                result = builder.toString();
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + n + ": " + result);
        }
    }

    private static boolean isPossible(Interval interval, Interval last) {
        return last == null || last.end <= interval.start;
    }
}

class Interval {
    int start;
    int end;
    char madeBy;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval int1, Interval int2) {
        if (int1.start == int2.start) {
            return Integer.compare(int1.end, int2.end);
        }
        return Integer.compare(int1.start, int2.start);
    }
}