import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    static class Interval {
        int idx, s, e;
        Interval(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            List<Interval> intervals = new ArrayList<>();
            for (int j = 1; j <= n; ++j) {
                int s = in.nextInt();
                int e = in.nextInt();
                intervals.add(new Interval(j - 1, s, e));
            }
            intervals.sort((a, b) -> a.s == b.s ? a.e - b.e : a.s - b.s);
            char[] assign = new char[n];
            int lastC = -1;
            int lastJ = -1;
            boolean isImpossible = false;
            for (Interval interval : intervals) {
                if (interval.s >= lastC) {
                    assign[interval.idx] = 'C';
                    lastC = interval.e;
                } else if (interval.s >= lastJ) {
                    assign[interval.idx] = 'J';
                    lastJ = interval.e;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            String output = String.format("Case #%d: %s", i, isImpossible ? IMPOSSIBLE : new String(assign));
            System.out.println(output);
        }
    }
}