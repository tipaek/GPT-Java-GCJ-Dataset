import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Solution {

    static final int MOD = 1000000007;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static class Interval {
        long start;
        long end;

        Interval(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(in.readLine());
        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(in.readLine());
            long[][] intervals = new long[n][2];
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] input = in.readLine().split(" ");
                intervals[i][0] = Long.parseLong(input[0]);
                intervals[i][1] = Long.parseLong(input[1]);
            }

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                long start = intervals[i][0];
                long end = intervals[i][1];

                if (!hasOverlap(cIntervals, start, end)) {
                    cIntervals.add(new Interval(start, end));
                    result.append("C");
                } else if (!hasOverlap(jIntervals, start, end)) {
                    jIntervals.add(new Interval(start, end));
                    result.append("J");
                } else {
                    System.out.println("Case #" + t + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
        in.close();
    }

    static boolean hasOverlap(List<Interval> intervals, long start, long end) {
        int maxEnd = 0;
        for (Interval interval : intervals) {
            if (maxEnd < interval.end) {
                maxEnd = (int) interval.end;
            }
        }
        maxEnd = Math.max(maxEnd, (int) end);
        int[] aux = new int[maxEnd + 1];

        for (Interval interval : intervals) {
            aux[(int) interval.start]++;
            aux[(int) interval.end]--;
        }
        aux[(int) start]++;
        aux[(int) end]--;

        for (int i = 1; i <= maxEnd; i++) {
            aux[i] += aux[i - 1];
            if (aux[i] > 1) {
                return true;
            }
        }
        return false;
    }
}