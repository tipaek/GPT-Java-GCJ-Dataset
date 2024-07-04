import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] intervals = new String[n];
            for (int j = 0; j < n; j++) {
                intervals[j] = scanner.nextLine();
            }

            String result = new Solution().assignActivities(intervals);
            if (result.contains("IMPOSSIBLE")) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private String assignActivities(String[] intervals) {
        List<int[]> cActivities = new ArrayList<>();
        List<int[]> jActivities = new ArrayList<>();
        StringBuilder schedule = new StringBuilder();

        for (String interval : intervals) {
            String[] parts = interval.split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            int[] currentInterval = {start, end};

            if (canAddActivity(cActivities, currentInterval)) {
                cActivities.add(currentInterval);
                schedule.append("C");
            } else if (canAddActivity(jActivities, currentInterval)) {
                jActivities.add(currentInterval);
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return schedule.toString();
    }

    private boolean canAddActivity(List<int[]> activities, int[] newActivity) {
        for (int[] activity : activities) {
            if ((newActivity[0] < activity[1] && newActivity[1] > activity[0])) {
                return false;
            }
        }
        return true;
    }
}