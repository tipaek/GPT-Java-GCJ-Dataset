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
            
            assignActivities(activities, caseNumber);
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void assignActivities(int[][] activities, int caseNumber) {
        boolean[] scheduleJ = new boolean[1440];
        boolean[] scheduleC = new boolean[1440];
        StringBuilder assignment = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (isAvailable(scheduleJ, start, end)) {
                Arrays.fill(scheduleJ, start, end, true);
                assignment.append("J");
            } else if (isAvailable(scheduleC, start, end)) {
                Arrays.fill(scheduleC, start, end, true);
                assignment.append("C");
            } else {
                assignment.setLength(0);
                assignment.append("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + assignment.toString());
    }
}