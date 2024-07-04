import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = in.nextInt();
            List<Interval> intervals = new ArrayList<>(n);
            for (int i = 0;i<n;i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                intervals.add(Interval.of(a, b));
            }
            List<Interval> sorted = new ArrayList<>(intervals);
            sorted.sort(Comparator.comparingInt(Interval::getStart));

            Interval cameron = null, jamie = null;
            Map<Interval, Boolean> assignments = new HashMap<>();

            boolean hasResult = true;

            for (Interval interval : sorted) {
                if (!overlaps(cameron, interval)) {
                    assignments.put(interval, true);
                    cameron = interval;
                } else if(!overlaps(jamie, interval)) {
                    assignments.put(interval, false);
                    jamie = interval;
                } else {
                    hasResult = false;
                    break;
                }
            }

            if (hasResult) {
                StringBuilder builder = new StringBuilder();
                for (Interval interval : intervals) {
                    builder.append((assignments.get(interval) ? 'C' : 'J'));
                }
                System.out.println(String.format("Case #%d: %s", t, builder.toString()));
            } else {
                System.out.println(String.format("Case #%d: %s", t, "IMPOSSIBLE"));
            }
        }
    }

    private static boolean overlaps(Interval a, Interval b) {
        if (a == null || b == null) return false;

        return b.l < a.r;
    }
}

class Interval {
    int l,r;

    public Interval(int a, int b) {
        l = a;
        r = b;
    }

    public static Interval of(int a, int b) {
        return new Interval(a, b);
    }

    @Override
    public boolean equals(Object obj) {
        return ((Interval) obj).l == this.l && ((Interval) obj).r == this.r;
    }

    @Override
    public int hashCode() {
        return String.format("%d-%d", l, r).hashCode();
    }

    public int getStart() {
        return this.l;
    }
}