import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            Map<String, Integer> activityIndexMap = new HashMap<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activityIndexMap.put(activities[i][0] + "-" + activities[i][1], i);
            }
            
            if (!isImpossible) {
                assignActivities(activities, testCase, activityIndexMap);
            }
        }
    }

    public static void assignActivities(int[][] activities, int testCaseNumber, Map<String, Integer> activityIndexMap) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        char[] assignments = new char[activities.length];
        assignments[activityIndexMap.get(activities[0][0] + "-" + activities[0][1])] = 'C';
        
        int cEnd = activities[0][1];
        int jEnd = 0;

        for (int i = 1; i < activities.length; i++) {
            int start = activities[i][0];
            int end = activities[i][1];
            String key = start + "-" + end;

            if (start >= cEnd) {
                assignments[activityIndexMap.get(key)] = 'C';
                cEnd = end;
            } else if (start >= jEnd) {
                assignments[activityIndexMap.get(key)] = 'J';
                jEnd = end;
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + new String(assignments));
    }
}