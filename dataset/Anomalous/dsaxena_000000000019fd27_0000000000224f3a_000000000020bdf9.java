import java.util.*;
import java.io.*;

public class Solution {
    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public boolean overlaps(Interval other) {
            return this.end > other.start && this.start < other.end;
        }
    }

    public static boolean canAddToSchedule(ArrayList<Interval> schedule, Interval newInterval) {
        for (Interval interval : schedule) {
            if (newInterval.overlaps(interval)) {
                return false;
            }
        }
        return true;
    }

    public static String assignParents(ArrayList<Interval> intervals) {
        ArrayList<Interval> jamSchedule = new ArrayList<>();
        ArrayList<Interval> camSchedule = new ArrayList<>();
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
        int T = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            ArrayList<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Interval(start, end));
            }

            String result = assignParents(intervals);
            output.append("Case #").append(t).append(": ").append(result);
            if (t < T) {
                output.append("\n");
            }
        }

        System.out.println(output.toString());
    }
}