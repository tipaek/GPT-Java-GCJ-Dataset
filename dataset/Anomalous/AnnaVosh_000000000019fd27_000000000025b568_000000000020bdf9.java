import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCount = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= testCount; test++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] times = new String[n];

            for (int i = 0; i < n; i++) {
                times[i] = scanner.nextLine();
            }

            String result = createSchedule(times, n);
            System.out.println("Case #" + test + ": " + result);
        }
    }

    private static String createSchedule(String[] times, int n) {
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] time = times[i].split(" ");
            intervals[i][0] = Integer.parseInt(time[0]);
            intervals[i][1] = Integer.parseInt(time[1]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        Map<String, Character> scheduleMap = new HashMap<>();

        int endC = 0, endJ = 0;

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            String intervalKey = start + " " + end;

            if (endC <= start) {
                scheduleMap.put(intervalKey, 'C');
                endC = end;
            } else if (endJ <= start) {
                scheduleMap.put(intervalKey, 'J');
                endJ = end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (String time : times) {
            result.append(scheduleMap.get(time));
        }

        return result.toString();
    }
}