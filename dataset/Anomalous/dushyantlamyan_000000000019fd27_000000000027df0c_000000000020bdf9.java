import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            String result = assignActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
    
    private static String assignActivities(int[][] activities) {
        StringBuilder schedule = new StringBuilder();
        int cEnd = 0, jEnd = 0;
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            
            if (start >= cEnd) {
                schedule.append('C');
                cEnd = end;
            } else if (start >= jEnd) {
                schedule.append('J');
                jEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }
}