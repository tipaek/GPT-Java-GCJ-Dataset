import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int test = 0; test < numberOfTests; test++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            boolean[] assignments = new boolean[numActivities];
            int[] endTimeTracker = {0, 0};
            boolean isImpossible = false;
            
            for (int i = 0; i < numActivities; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            for (int i = 0; i < numActivities; i++) {
                int earliestStart = Integer.MAX_VALUE;
                int activityIndex = -1;
                
                for (int j = 0; j < numActivities; j++) {
                    if (startTimes[j] < earliestStart) {
                        activityIndex = j;
                        earliestStart = startTimes[j];
                    }
                }
                
                int currentStart = startTimes[activityIndex];
                startTimes[activityIndex] = Integer.MAX_VALUE;
                
                if (endTimeTracker[0] <= currentStart) {
                    assignments[activityIndex] = false;
                    endTimeTracker[0] = endTimes[activityIndex];
                } else if (endTimeTracker[1] <= currentStart) {
                    assignments[activityIndex] = true;
                    endTimeTracker[1] = endTimes[activityIndex];
                } else {
                    isImpossible = true;
                    break;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (test + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (boolean assignment : assignments) {
                    result.append(assignment ? "J" : "C");
                }
                System.out.println("Case #" + (test + 1) + ": " + result);
            }
        }
    }
}