import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int schedules = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            List<int[]> intervals = new ArrayList<>();
            
            for (int j = 0; j < schedules; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                intervals.add(new int[]{start, end});
            }

            String result = assignSchedules(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignSchedules(List<int[]> intervals) {
        intervals.sort(Comparator.comparingInt(a -> a[0])); // Sort intervals by start time

        int[] cameron = null;
        int[] jamie = null;
        StringBuilder schedule = new StringBuilder();

        for (int[] interval : intervals) {
            if (cameron == null || cameron[1] <= interval[0]) {
                cameron = interval;
                schedule.append('C');
            } else if (jamie == null || jamie[1] <= interval[0]) {
                jamie = interval;
                schedule.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}