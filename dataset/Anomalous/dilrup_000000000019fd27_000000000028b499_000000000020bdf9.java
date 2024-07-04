import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            String[] resultArr = new String[n];
            String result = "";
            List<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int s = in.nextInt();
                int e = in.nextInt();
                intervals.add(new Interval(s, e, j));
            }

            intervals.sort(Comparator.comparingInt(interval -> interval.start));
            int ce = 0, je = 0;

            for (Interval interval : intervals) {
                if (ce <= interval.start) {
                    resultArr[interval.index] = "C";
                    ce = interval.end;
                } else if (je <= interval.start) {
                    resultArr[interval.index] = "J";
                    je = interval.end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = String.join("", resultArr);
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static class Interval {
        int start;
        int end;
        int index;

        Interval(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}