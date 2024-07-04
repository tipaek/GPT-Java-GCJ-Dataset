import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            int[][] tempActivities = new int[activityCount][2];
            StringBuilder schedule = new StringBuilder();
            
            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < 2; j++) {
                    activities[i][j] = scanner.nextInt();
                    tempActivities[i][j] = activities[i][j];
                }
            }
            
            String result = "";
            int overlapCount = 0;
            int lastOverlapIndex = 0;
            
            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < i; j++) {
                    if (i == j) {
                        break;
                    }
                    if (activities[i][0] >= tempActivities[j][0] && activities[i][0] <= tempActivities[j][1] ||
                        activities[i][1] >= tempActivities[j][0] && activities[i][1] <= tempActivities[j][1]) {
                        overlapCount++;
                        lastOverlapIndex = j;
                    }
                }
                
                if (overlapCount == 0) {
                    if (i == 0 || schedule.charAt(lastOverlapIndex) == 'C') {
                        schedule.append('C');
                    } else {
                        schedule.append('J');
                    }
                } else if (overlapCount == 1) {
                    if (schedule.charAt(lastOverlapIndex) == 'C') {
                        schedule.append('J');
                    } else {
                        schedule.append('C');
                    }
                } else {
                    result = "IMPOSSIBLE";
                }
                overlapCount = 0;
            }
            
            System.out.println("Case #" + testCase + ": " + (result.equals("IMPOSSIBLE") ? result : schedule.toString()));
        }
    }
}