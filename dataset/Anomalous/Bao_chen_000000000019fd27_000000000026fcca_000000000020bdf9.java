import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            int minStart = Integer.MAX_VALUE;
            int maxEnd = Integer.MIN_VALUE;
            
            for (int j = 0; j < activitiesCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                minStart = Math.min(minStart, activities[j][0]);
                maxEnd = Math.max(maxEnd, activities[j][1]);
            }
            
            solve(minStart, maxEnd, activities, i);
        }
    }
    
    private static boolean isSchedulable(Set<int[]> schedule, int start, int end) {
        if (schedule.isEmpty()) {
            return true;
        }
        
        int previousEnd = -1;
        int nextStart = 3601;
        
        for (int[] interval : schedule) {
            if (previousEnd >= 0 && nextStart <= 3600) {
                break;
            }
            if (interval[1] <= start) {
                previousEnd = Math.max(previousEnd, interval[1]);
            } else if (interval[0] >= end) {
                nextStart = Math.min(nextStart, interval[0]);
            }
        }
        
        return (previousEnd >= 0 && nextStart == 3601) || (nextStart <= 3600 && previousEnd == -1) || (previousEnd >= 0 && nextStart <= 3600);
    }
    
    private static void solve(int minStart, int maxEnd, int[][] activities, int caseNumber) {
        Set<int[]> cameronSchedule = new HashSet<>();
        Set<int[]> jamieSchedule = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (isSchedulable(jamieSchedule, start, end)) {
                jamieSchedule.add(activity);
                result.append("J");
            } else if (isSchedulable(cameronSchedule, start, end)) {
                cameronSchedule.add(activity);
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}