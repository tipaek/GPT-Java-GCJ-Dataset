import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            Interval[] intervals = new Interval[n];

            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
                scanner.nextLine();
            }

            results[i] = "Case #" + (i + 1) + ": " + assignTasks(intervals);
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignTasks(Interval[] intervals) {
        List<Interval> cameron = new ArrayList<>();
        List<Interval> jamie = new ArrayList<>();
        StringBuilder result = new StringBuilder("C");

        cameron.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (!isConflicting(cameron, intervals[i])) {
                result.append("C");
                cameron.add(intervals[i]);
            } else if (!isConflicting(jamie, intervals[i])) {
                result.append("J");
                jamie.add(intervals[i]);
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    private static boolean isConflicting(List<Interval> list, Interval interval) {
        for (Interval existingInterval : list) {
            if (intervalsOverlap(existingInterval, interval)) {
                return true;
            }
        }
        return false;
    }

    private static boolean intervalsOverlap(Interval a, Interval b) {
        return !(a.getEnd() <= b.getStart() || a.getStart() >= b.getEnd());
    }
}

class Interval {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}