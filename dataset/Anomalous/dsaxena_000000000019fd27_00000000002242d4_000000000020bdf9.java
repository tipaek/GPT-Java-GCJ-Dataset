import java.util.*;

public class Solution {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlaps(Interval other) {
            return !(this.end <= other.start || this.start >= other.end);
        }
    }

    public static boolean canAddToSchedule(List<Interval> schedule, Interval interval) {
        for (Interval existingInterval : schedule) {
            if (interval.overlaps(existingInterval)) {
                return false;
            }
        }
        return true;
    }

    public static String assignParents(List<Interval> intervals) {
        List<Interval> jamSchedule = new ArrayList<>();
        List<Interval> camSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (Interval interval : intervals) {
            if (canAddToSchedule(jamSchedule, interval)) {
                jamSchedule.add(interval);
                result.append("J");
            } else if (canAddToSchedule(camSchedule, interval)) {
                camSchedule.add(interval);
                result.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        StringBuilder output = new StringBuilder();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }

            String result = assignParents(intervals);
            output.append("Case #").append(t).append(": ").append(result);
            if (t < testCases) {
                output.append("\n");
            }
        }

        System.out.println(output.toString());
        scanner.close();
    }
}