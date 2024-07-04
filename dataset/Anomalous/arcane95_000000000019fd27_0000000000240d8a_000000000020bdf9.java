import java.util.*;

class Interval {
    int pos;
    int start, end;

    Interval(int pos, int start, int end) {
        this.pos = pos;
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int t1 = 1; t1 <= t; t1++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new Interval(i, start, end);
            }

            Arrays.sort(intervals, (interval1, interval2) -> {
                if (interval1.start == interval2.start) {
                    return Integer.compare(interval1.end, interval2.end);
                }
                return Integer.compare(interval1.start, interval2.start);
            });

            boolean isPossible = true;
            StringBuilder schedule = new StringBuilder(" ".repeat(n));
            int endJ = 0, endC = 0;

            for (Interval interval : intervals) {
                if (endJ <= endC) {
                    if (endJ <= interval.start) {
                        endJ = interval.end;
                        schedule.setCharAt(interval.pos, 'J');
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    if (endC <= interval.start) {
                        endC = interval.end;
                        schedule.setCharAt(interval.pos, 'C');
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }

            String result = isPossible ? schedule.toString() : "IMPOSSIBLE";
            System.out.println("Case #" + t1 + ": " + result);
        }
    }
}