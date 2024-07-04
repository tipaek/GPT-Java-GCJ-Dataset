import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<int[]> cameronActivities = new ArrayList<>();
            List<int[]> jamieActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            String result = "";

            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int[] activity = new int[] {start, end};

                if (isOverlapping(start, end, jamieActivities)) {
                    if (isOverlapping(start, end, cameronActivities)) {
                        result = "IMPOSSIBLE";
                        break;
                    } else {
                        cameronActivities.add(activity);
                        schedule.append('C');
                    }
                } else {
                    jamieActivities.add(activity);
                    schedule.append('J');
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = schedule.toString();
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    private static boolean isOverlapping(int start, int end, List<int[]> activities) {
        for (int[] activity : activities) {
            int activityStart = activity[0];
            int activityEnd = activity[1];

            if ((activityStart < end && activityEnd > start) || (activityStart == start && activityEnd == end)) {
                return true;
            }
        }
        return false;
    }
}