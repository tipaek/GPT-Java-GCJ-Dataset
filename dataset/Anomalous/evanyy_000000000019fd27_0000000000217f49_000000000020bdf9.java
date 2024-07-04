import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            
            for (int i = 0; i < numActivities; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            System.out.println("Case #" + caseNum + ": " + assignActivities(activities));
        }
    }

    public static String assignActivities(int[][] activities) {
        StringBuilder result = new StringBuilder();
        int[][] cameronSchedule = new int[activities.length][2];
        int[][] jamieSchedule = new int[activities.length][2];
        int cameronIndex = 0;
        int jamieIndex = 0;
        
        for (int[] activity : activities) {
            boolean assignedToCameron = true;
            
            for (int i = 0; i < cameronIndex; i++) {
                if (!(cameronSchedule[i][1] <= activity[0] || cameronSchedule[i][0] >= activity[1])) {
                    assignedToCameron = false;
                    break;
                }
            }
            
            if (assignedToCameron) {
                cameronSchedule[cameronIndex][0] = activity[0];
                cameronSchedule[cameronIndex][1] = activity[1];
                cameronIndex++;
                result.append("C");
            } else {
                boolean assignedToJamie = true;
                
                for (int i = 0; i < jamieIndex; i++) {
                    if (!(jamieSchedule[i][1] <= activity[0] || jamieSchedule[i][0] >= activity[1])) {
                        return "IMPOSSIBLE";
                    }
                }
                
                jamieSchedule[jamieIndex][0] = activity[0];
                jamieSchedule[jamieIndex][1] = activity[1];
                jamieIndex++;
                result.append("J");
            }
        }
        
        return result.toString();
    }
}