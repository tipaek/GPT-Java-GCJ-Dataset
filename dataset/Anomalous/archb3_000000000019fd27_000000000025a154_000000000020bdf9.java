import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; ++i) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] intervals = new String[n];
            for (int j = 0; j < n; j++) {
                intervals[j] = scanner.nextLine();
            }
            String result = new Solution().scheduleIntervals(intervals);
            if (result.contains("IMPOSSIBLE")) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private String scheduleIntervals(String[] intervals) {
        List<int[]> cSchedule = new ArrayList<>();
        List<int[]> jSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (String interval : intervals) {
            String[] times = interval.split(" ");
            int start = Integer.parseInt(times[0]);
            int end = Integer.parseInt(times[1]);
            int[] currentInterval = {start, end};

            if (canBeScheduled(cSchedule, currentInterval)) {
                cSchedule.add(currentInterval);
                result.append("C");
            } else if (canBeScheduled(jSchedule, currentInterval)) {
                jSchedule.add(currentInterval);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    private boolean canBeScheduled(List<int[]> schedule, int[] interval) {
        for (int[] scheduledInterval : schedule) {
            if (intervalsOverlap(scheduledInterval, interval)) {
                return false;
            }
        }
        return true;
    }

    private boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval1[1] > interval2[0];
    }
}