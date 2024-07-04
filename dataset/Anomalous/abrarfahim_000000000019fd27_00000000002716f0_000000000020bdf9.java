import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Interval(start, end));
            }

            intervals.sort((a, b) -> a.end - b.end);

            StringBuilder schedule = new StringBuilder();
            List<Interval> cameron = new ArrayList<>();
            List<Interval> jamie = new ArrayList<>();

            cameron.add(intervals.get(0));
            schedule.append("C");
            intervals.remove(0);

            boolean impossible = false;

            for (Interval interval : intervals) {
                boolean overlapC = overlaps(cameron, interval);
                boolean overlapJ = overlaps(jamie, interval);

                if (!overlapC) {
                    cameron.add(interval);
                    schedule.append("C");
                } else if (!overlapJ) {
                    jamie.add(interval);
                    schedule.append("J");
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static boolean overlaps(List<Interval> list, Interval interval) {
        for (Interval existing : list) {
            if (existing.start < interval.end && interval.start < existing.end) {
                return true;
            }
        }
        return false;
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}