import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            List<int[]> cameronSchedule = new ArrayList<>();
            List<int[]> jamieSchedule = new ArrayList<>();
            StringBuilder resultSchedule = new StringBuilder();
            
            boolean isPossible = true;
            
            for (int act = 0; act < activityCount; act++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (isAvailable(cameronSchedule, start, end)) {
                    resultSchedule.append('C');
                    cameronSchedule.add(new int[]{start, end});
                } else if (isAvailable(jamieSchedule, start, end)) {
                    resultSchedule.append('J');
                    jamieSchedule.add(new int[]{start, end});
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                resultSchedule = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + caseNum + ": " + resultSchedule);
        }
        
        scanner.close();
    }
    
    private static boolean isAvailable(List<int[]> schedule, int start, int end) {
        for (int[] timeSlot : schedule) {
            int scheduledStart = timeSlot[0];
            int scheduledEnd = timeSlot[1];
            
            if (start < scheduledEnd && end > scheduledStart) {
                return false;
            }
        }
        return true;
    }
}