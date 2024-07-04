import java.util.*;
import java.io.*;

public class Solution {
    
    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        if (start > 1440 || end > 1440) return false;
        
        for (int[] slot : schedule) {
            if (slot[0] == 0 && slot[1] == 0) continue;

            if ((slot[0] < start && slot[1] > start) || (slot[0] < end && slot[1] > end)) {
                return false;
            }
            if ((start < slot[0] && end > slot[0]) || (start < slot[1] && end > slot[1])) {
                return false;
            }
            if (slot[0] == start && slot[1] == end) {
                return false;
            }
        }
        
        return true;
    }
    
    private String assignSchedule(int[][] timeSlots) {
        StringBuilder assignment = new StringBuilder();
        int[][] cSchedule = new int[timeSlots.length][2];
        int[][] jSchedule = new int[timeSlots.length][2];
        int cCount = 0, jCount = 0;
        
        for (int i = 0; i < timeSlots.length; i++) {
            int start = timeSlots[i][0];
            int end = timeSlots[i][1];
            
            if (start > 1440 || end > 1440) {
                return "IMPOSSIBLE";
            }
            
            if (i == 0 || isTimeSlotFree(cSchedule, start, end)) {
                assignment.append("C");
                cSchedule[cCount][0] = start;
                cSchedule[cCount][1] = end;
                cCount++;
            } else if (isTimeSlotFree(jSchedule, start, end)) {
                assignment.append("J");
                jSchedule[jCount][0] = start;
                jSchedule[jCount][1] = end;
                jCount++;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return assignment.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numSlots = scanner.nextInt();
            int[][] timeMatrix = new int[numSlots][2];
            
            for (int j = 0; j < numSlots; j++) {
                timeMatrix[j][0] = scanner.nextInt();
                timeMatrix[j][1] = scanner.nextInt();
            }
            
            String result = solution.assignSchedule(timeMatrix);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}