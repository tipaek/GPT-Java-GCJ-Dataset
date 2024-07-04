import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                intervals.add(new Interval(in.nextInt(), in.nextInt()));
            }
            results[i] = scheduleTasks(intervals);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, results[i]));
        }
    }

    private static String scheduleTasks(List<Interval> intervals) {
        List<Interval> cSchedule = new ArrayList<>();
        List<Interval> jSchedule = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (Interval interval : intervals) {
            if (canSchedule(cSchedule, interval)) {
                cSchedule.add(interval);
                schedule.append("C");
            } else if (canSchedule(jSchedule, interval)) {
                jSchedule.add(interval);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private static boolean canSchedule(List<Interval> schedule, Interval interval) {
        for (Interval scheduled : schedule) {
            if (!(interval.start >= scheduled.end || interval.end <= scheduled.start)) {
                return false;
            }
        }
        return true;
    }

    private static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}