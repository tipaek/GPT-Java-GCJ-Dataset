import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            processActivities(activities, caseNumber);
        }
    }

    private static boolean isSchedulable(Set<int[]> scheduledActivities, int start, int end) {
        if (scheduledActivities.isEmpty()) {
            return true;
        }

        int latestEnd = -1;
        int earliestStart = 3601;
        
        for (int[] activity : scheduledActivities) {
            if (start >= activity[1]) {
                latestEnd = Math.max(latestEnd, activity[1]);
            }
            if (end <= activity[0]) {
                earliestStart = Math.min(earliestStart, activity[0]);
            }
        }
        
        return latestEnd >= 0 && (earliestStart == 3601 || earliestStart <= 3600);
    }

    private static void processActivities(int[][] activities, int caseNumber) {
        Set<int[]> cameronActivities = new HashSet<>();
        Set<int[]> jamieActivities = new HashSet<>();
        StringBuilder schedule = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (isSchedulable(jamieActivities, start, end)) {
                jamieActivities.add(activity);
                schedule.append("J");
            } else if (isSchedulable(cameronActivities, start, end)) {
                cameronActivities.add(activity);
                schedule.append("C");
            } else {
                schedule.setLength(0);
                break;
            }
        }

        if (schedule.length() == activities.length) {
            System.out.println("Case #" + caseNumber + ": " + schedule);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }
}