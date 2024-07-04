import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            String[] schedule = new String[activityCount];
            boolean possible = true;
            
            for (int j = 0; j < activityCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            for (int j = 0; j < activityCount; j++) {
                schedule = assignSchedule(activities, schedule, j);
                if (schedule[j] == null) {
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + i + ": " + (possible ? String.join("", schedule) : "IMPOSSIBLE"));
        }
    }

    private static String[] assignSchedule(int[][] activities, String[] schedule, int currentIndex) {
        if (currentIndex == 0) {
            schedule[currentIndex] = "J";
            return schedule;
        }
        
        int currentStart = activities[currentIndex][0];
        int currentEnd = activities[currentIndex][1];
        boolean isJOccupied = false;
        
        for (int i = 0; i < currentIndex; i++) {
            int start = activities[i][0];
            int end = activities[i][1];
            
            if (!(currentStart >= end || currentEnd <= start)) {
                if (isJOccupied) {
                    schedule[currentIndex] = null;
                    return schedule;
                } else if ("J".equals(schedule[i])) {
                    isJOccupied = true;
                }
            }
        }
        
        schedule[currentIndex] = isJOccupied ? "C" : "J";
        return schedule;
    }
}