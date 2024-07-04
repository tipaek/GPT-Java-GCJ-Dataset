import java.util.*;

public class Solution {

    static class Interval {
        int time;
        int type;
        int idx;

        Interval(int time, int type, int idx) {
            this.time = time;
            this.type = type;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, 1, i));
                intervals.add(new Interval(end, -1, -i));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.time));

            int activeIntervals = 0;
            boolean isPossible = true;
            for (Interval interval : intervals) {
                activeIntervals += interval.type;
                if (activeIntervals > 2) {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (!isPossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    result.append('o');
                }
                boolean cameronAvailable = true;
                for (Interval interval : intervals) {
                    if (interval.idx > 0) {
                        char assigned = cameronAvailable ? 'C' : 'J';
                        result.setCharAt(interval.idx - 1, assigned);
                        if (cameronAvailable) {
                            cameronAvailable = false;
                        }
                    } else {
                        if (result.charAt(-interval.idx - 1) == 'C') {
                            cameronAvailable = true;
                        }
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}