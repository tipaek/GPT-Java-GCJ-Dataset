import java.util.*;
import java.io.*;

public class Solution {
    
    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        if (start > 1440 || end > 1440) {
            return false;
        }
        
        for (int[] timeSlot : schedule) {
            if (timeSlot[0] == 0 && timeSlot[1] == 0) {
                continue;
            }
            
            if (timeSlot[0] > timeSlot[1]) {
                if ((timeSlot[0] > start && timeSlot[1] < start) && (timeSlot[0] > end && timeSlot[1] < end)) {
                    return true;
                }
            }
            
            if ((timeSlot[0] < start && timeSlot[1] > start) || (timeSlot[0] < end && timeSlot[1] > end)) {
                return false;
            } else if ((start < timeSlot[0] && end > timeSlot[0]) || (start < timeSlot[1] && end > timeSlot[1])) {
                return false;
            }
        }
        
        return true;
    }
    
    private String assignSchedules(int[][] timeSlots) {
        StringBuilder assignment = new StringBuilder();
        int[][] cSchedule = new int[timeSlots.length][2];
        int cCount = 0;
        int[][] jSchedule = new int[timeSlots.length][2];
        int jCount = 0;

        for (int[] timeSlot : timeSlots) {
            if (isTimeSlotFree(cSchedule, timeSlot[0], timeSlot[1])) {
                assignment.append("C");
                cSchedule[cCount++] = timeSlot;
            } else if (isTimeSlotFree(jSchedule, timeSlot[0], timeSlot[1])) {
                assignment.append("J");
                jSchedule[jCount++] = timeSlot;
            } else {
                return "IMPOSSIBLE";
            }

            if (timeSlot[0] > 1440 || timeSlot[1] > 1440) {
                return "IMPOSSIBLE";
            }
        }
        
        return assignment.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int numberOfCases = scanner.nextInt();

        for (int i = 1; i <= numberOfCases; ++i) {
            int numberOfTasks = scanner.nextInt();
            int[][] timeSlots = new int[numberOfTasks][2];
            
            for (int j = 0; j < numberOfTasks; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt();
            }
            
            String result = solution.assignSchedules(timeSlots);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}