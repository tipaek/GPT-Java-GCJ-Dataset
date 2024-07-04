import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            
            for (int j = 0; j < activitiesCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            processActivities(activities, caseNumber);
        }
    }

    private static boolean isSchedulable(Set<int[]> scheduleSet, int start, int end) {
        if (scheduleSet.isEmpty()) {
            return true;
        }

        int latestEnd = -1;
        int earliestStart = Integer.MAX_VALUE;

        for (int[] interval : scheduleSet) {
            if (start >= interval[1]) {
                latestEnd = Math.max(latestEnd, interval[1]);
            }
            if (end <= interval[0]) {
                earliestStart = Math.min(earliestStart, interval[0]);
            }
        }

        return latestEnd >= 0 && (earliestStart == Integer.MAX_VALUE || earliestStart <= 3600);
    }

    private static void processActivities(int[][] activities, int caseNumber) {
        Set<int[]> scheduleJ = new HashSet<>();
        Set<int[]> scheduleC = new HashSet<>();
        StringBuilder scheduleResult = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (isSchedulable(scheduleJ, start, end)) {
                scheduleJ.add(activity);
                scheduleResult.append("J");
            } else if (isSchedulable(scheduleC, start, end)) {
                scheduleC.add(activity);
                scheduleResult.append("C");
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + scheduleResult.toString());
    }
}