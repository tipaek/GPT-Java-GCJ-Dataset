import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder scheduleBuilder = new StringBuilder();
            String result = "";

            for (int i = 0; i < activityCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                int[] activity = {startTime, endTime};

                if (isOverlapping(startTime, endTime, jamieSchedule)) {
                    if (isOverlapping(startTime, endTime, cameronSchedule)) {
                        result = "IMPOSSIBLE";
                        break;
                    } else {
                        cameronSchedule.add(activity);
                        scheduleBuilder.append('C');
                    }
                } else {
                    jamieSchedule.add(activity);
                    scheduleBuilder.append('J');
                }
            }

            result = result.equals("IMPOSSIBLE") ? "IMPOSSIBLE" : scheduleBuilder.toString();
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    private static boolean isOverlapping(int start, int end, List<int[]> schedule) {
        for (int[] activity : schedule) {
            int activityStart = activity[0];
            int activityEnd = activity[1];
            if ((activityStart == start && activityEnd == end) ||
                (activityStart > start && activityStart < end) ||
                (activityEnd > start && activityEnd < end) ||
                (activityStart < start && activityEnd > end)) {
                return true;
            }
        }
        return false;
    }
}