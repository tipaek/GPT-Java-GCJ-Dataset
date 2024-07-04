import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            TimeSlot[] schedule = new TimeSlot[n];
            for (int x = 0; x < n; x++) {
                TimeSlot ts = new TimeSlot(x, in.nextInt(), in.nextInt());
                schedule[x] = ts;
            }

            System.out.println("Case #" + i + ": " + parenting(schedule));
        }
    }

    private static String parenting(TimeSlot[] schedule) {
        Arrays.sort(schedule);
        String result = helper(schedule, 0, 0, 0);
        if (result.contains("IMPOSSIBLE")) {
            return "IMPOSSIBLE";
        } else {
            char[] chars = result.toCharArray();
            char[] answer = new char[schedule.length];
            for (int i = 0; i < schedule.length; i++) {
                answer[schedule[i].index] = chars[i];
            }
            return new String(answer);
        }
    }

    private static String helper(TimeSlot[] schedule, int curr, int lastC, int lastJ) {
        if (curr >= schedule.length) return "";
        String result = "";
        if (schedule[curr].start >= lastC) {
            result = "C" + helper(schedule, curr + 1, schedule[curr].end, lastJ);
        }
        if ((result.contains("IMPOSSIBLE") || schedule.length != curr + result.length()) && schedule[curr].start >= lastJ) {
            result = "J" + helper(schedule, curr + 1, lastC, schedule[curr].end);
        }
        return result.isEmpty() || result.contains("IMPOSSIBLE") || schedule.length != curr + result.length() ? "IMPOSSIBLE" : result;
    }

    static class TimeSlot implements Comparable<TimeSlot> {
        int index;
        int start;
        int end;

        public TimeSlot(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(TimeSlot timeSlot) {
            return this.start - timeSlot.start;
        }
    }

}