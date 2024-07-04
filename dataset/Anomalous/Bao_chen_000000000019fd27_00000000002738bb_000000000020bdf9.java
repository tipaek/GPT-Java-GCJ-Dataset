import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            
            for (int j = 0; j < activitiesCount; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            
            processCase(activities, caseNum);
        }
    }
    
    private static boolean isScheduleAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = true;
        }
    }

    private static void processCase(int[][] activities, int caseNum) {
        boolean[] scheduleJ = new boolean[3601];
        boolean[] scheduleC = new boolean[3601];
        StringBuilder result = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (isScheduleAvailable(scheduleJ, start, end)) {
                markSchedule(scheduleJ, start, end);
                result.append("J");
            } else if (isScheduleAvailable(scheduleC, start, end)) {
                markSchedule(scheduleC, start, end);
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNum + ": " + result.toString());
    }
}