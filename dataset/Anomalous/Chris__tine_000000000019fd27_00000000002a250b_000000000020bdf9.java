import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int a = 0; a < numActivities; a++) {
                activities[a][0] = scanner.nextInt();
                activities[a][1] = scanner.nextInt();
            }
            String result = assignActivities(numActivities, activities);
            System.out.printf("Case #%d: %s\n", t + 1, result);
        }
    }
    
    public static String assignActivities(int numActivities, int[][] activities) {
        int[][] activitiesWithIndex = new int[numActivities][3];
        for (int i = 0; i < numActivities; i++) {
            activitiesWithIndex[i][0] = activities[i][0];
            activitiesWithIndex[i][1] = activities[i][1];
            activitiesWithIndex[i][2] = i;
        }
        
        Arrays.sort(activitiesWithIndex, Comparator.comparingInt(a -> a[0]));
        
        int lastC = 0;
        int lastJ = -1;
        int[][] assignments = new int[numActivities][2];
        assignments[0][0] = 0;
        assignments[0][1] = activitiesWithIndex[0][2];
        
        for (int i = 1; i < numActivities; i++) {
            assignments[i][1] = activitiesWithIndex[i][2];
            if (activitiesWithIndex[i][0] >= activitiesWithIndex[lastC][1]) {
                assignments[i][0] = 0;
                lastC = i;
            } else if (lastJ == -1 || activitiesWithIndex[i][0] >= activitiesWithIndex[lastJ][1]) {
                assignments[i][0] = 1;
                lastJ = i;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        Arrays.sort(assignments, Comparator.comparingInt(a -> a[1]));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numActivities; i++) {
            result.append(assignments[i][0] == 0 ? "C" : "J");
        }
        return result.toString();
    }
}