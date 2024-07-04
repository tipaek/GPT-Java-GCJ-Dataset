import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            TimeSlot[] schedule = new TimeSlot[n];
            for (int j = 0; j < n; j++) {
                schedule[j] = new TimeSlot(j, scanner.nextInt(), scanner.nextInt());
            }
            System.out.println("Case #" + i + ": " + getParentingSchedule(schedule));
        }
    }

    private static String getParentingSchedule(TimeSlot[] schedule) {
        Arrays.sort(schedule);
        String assignments = assignTasks(schedule, 0, 0, 0);
        if (assignments.contains("IMPOSSIBLE")) {
            return "IMPOSSIBLE";
        } else {
            char[] result = new char[schedule.length];
            for (int i = 0; i < schedule.length; i++) {
                result[schedule[i].index] = assignments.charAt(i);
            }
            return new String(result);
        }
    }

    private static String assignTasks(TimeSlot[] schedule, int currentIndex, int lastC, int lastJ) {
        if (currentIndex >= schedule.length) return "";
        String result = "";

        if (schedule[currentIndex].start >= lastC) {
            result = "C" + assignTasks(schedule, currentIndex + 1, schedule[currentIndex].end, lastJ);
        }
        if ((result.contains("IMPOSSIBLE") || schedule.length != currentIndex + result.length()) && schedule[currentIndex].start >= lastJ) {
            result = "J" + assignTasks(schedule, currentIndex + 1, lastC, schedule[currentIndex].end);
        }
        return result.isEmpty() || result.contains("IMPOSSIBLE") || schedule.length != currentIndex + result.length() ? "IMPOSSIBLE" : result;
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
        public int compareTo(TimeSlot other) {
            return Integer.compare(this.start, other.start);
        }
    }
}