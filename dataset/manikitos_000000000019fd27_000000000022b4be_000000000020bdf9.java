import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final char JAMIE = 'J';
    private static final char CAMERON = 'C';

    public static void main(String... args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];
            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(in.nextInt(), in.nextInt());
            }
            if (getSolution(n, intervals) != 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (Interval interval : intervals) {
                if( interval.assignee == 0 )
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                sb.append(interval.assignee);
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }

    private static int getSolution(int n, Interval[] intervals) {
        for (int j1 = 0; j1 < n - 1; j1++) {
            Interval curInterval = intervals[j1];
            boolean autoset = false;
            if (curInterval.assignee == 0) {
                autoset = true;
                curInterval.assignee = JAMIE;
            }
            Set<Integer> changed = new HashSet<>();
            boolean retry = false;
            for (int j2 = j1 + 1; j2 < n; j2++) {
                Interval anotherInterval = intervals[j2];
                if (curInterval.overlaps(anotherInterval)) {
                    if (anotherInterval.assignee == 0) {
                        if (autoset)
                            changed.add(j2);
                        switch (curInterval.assignee) {
                            case JAMIE:
                                anotherInterval.assignee = CAMERON;
                                break;
                            case CAMERON:
                                anotherInterval.assignee = JAMIE;
                                break;
                        }
                        continue;
                    }
                    if (curInterval.assignee == anotherInterval.assignee) {
                        if (!autoset)
                            return 1;
                        retry = true;
                        break;
                    }
                }
            }
            if (retry) {
                for (int jj : changed) {
                    intervals[jj].assignee = 0;
                }
                curInterval.assignee = CAMERON;
                for (int j2 = j1 + 1; j2 < n; j2++) {
                    Interval anotherInterval = intervals[j2];
                    if (curInterval.overlaps(anotherInterval)) {
                        if (anotherInterval.assignee == 0) {
                            switch (curInterval.assignee) {
                                case JAMIE:
                                    anotherInterval.assignee = CAMERON;
                                    break;
                                case CAMERON:
                                    anotherInterval.assignee = JAMIE;
                                    break;
                            }
                            continue;
                        }
                        if (curInterval.assignee == anotherInterval.assignee) {
                            return 1;
                        }
                    }
                }
            }
        }
        if (intervals[n - 1].assignee == 0) {
            intervals[n - 1].assignee = JAMIE;
        }
        return 0;
    }

    private static class Interval {
        final int start;
        final int end;
        char assignee = 0;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public boolean overlaps(Interval ai) {
            return (start <= ai.start && ai.start < end) ||
                    (start < ai.end && ai.end <= end) ||
                    (ai.start < start && ai.end > end);
        }
    }
}
