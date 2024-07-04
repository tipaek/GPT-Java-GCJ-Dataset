import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    private static final char JAMIE = 'J';
    private static final char CAMERON = 'C';
    private static final String impossible = "IMPOSSIBLE";

    public static void main(String... args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        MAIN:
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Interval[] intervals = new Interval[n];
            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(in.nextInt(), in.nextInt());
            }
            for (int j1 = 0; j1 < n - 1; j1++) {
                Interval curInterval = intervals[j1];
                if (curInterval.assignee == 0)
                    curInterval.assignee = JAMIE;
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
                            System.out.println("Case #" + i + ": " + impossible);
                            continue MAIN;
                        }
                    }

                }
            }
            if (intervals[n - 1].assignee == 0) {
                intervals[n - 1].assignee = JAMIE;
            }
            StringBuilder sb = new StringBuilder();
            for (Interval interval : intervals) {
                sb.append(interval.assignee);
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
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