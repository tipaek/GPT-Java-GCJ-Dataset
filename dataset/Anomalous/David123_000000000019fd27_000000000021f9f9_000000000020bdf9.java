import java.util.*;
import java.io.*;

public class Solution {

    public static String findSolution(List<int[]> activities, int numActivities) {
        StringBuilder solution = new StringBuilder();
        String[] assignment = new String[numActivities];
        
        boolean isJamieAvailable = true;
        boolean isCamAvailable = true;
        
        int jamieEndTime = -10;
        int camEndTime = -10;
        
        for (int[] activity : activities) {
            int startTime = activity[0];
            int endTime = activity[1];
            int activityIndex = activity[2];
            
            if (startTime >= jamieEndTime) {
                jamieEndTime = -10;
                isJamieAvailable = true;
            }
            
            if (startTime >= camEndTime) {
                camEndTime = -10;
                isCamAvailable = true;
            }
            
            if (isJamieAvailable) {
                jamieEndTime = endTime;
                isJamieAvailable = false;
                assignment[activityIndex] = "J";
            } else if (isCamAvailable) {
                camEndTime = endTime;
                isCamAvailable = false;
                assignment[activityIndex] = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        for (String s : assignment) {
            solution.append(s);
        }
        
        return solution.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();
        
        for (int i = 1; i <= numTestCase; ++i) {
            int numActivities = in.nextInt();
            List<int[]> activities = new ArrayList<>(numActivities);
            
            for (int k = 0; k < numActivities; k++) {
                int[] activity = new int[3];
                activity[0] = in.nextInt();
                activity[1] = in.nextInt();
                activity[2] = k;
                activities.add(activity);
            }
            
            activities.sort(Comparator.comparingInt(a -> a[0]));
            
            String solution = findSolution(activities, numActivities);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}