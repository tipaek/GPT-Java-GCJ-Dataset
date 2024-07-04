import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            Map<String, Integer> activityMap = new HashMap<>();
            boolean impossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                for (int j = 0; j < 2; j++) {
                    activities[i][j] = scanner.nextInt();
                }
                String key = activities[i][0] + "-" + activities[i][1];
                if (activityMap.containsKey(key)) {
                    key += "-";
                    if (activityMap.containsKey(key)) {
                        System.out.println("Case #" + t + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
                activityMap.put(key, i);
            }
            
            if (!impossible) {
                assignActivities(activities, t, activityMap);
            }
        }
    }

    private static void assignActivities(int[][] activities, int testCaseNumber, Map<String, Integer> activityMap) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        char[] schedule = new char[activities.length];
        Arrays.fill(schedule, ' ');

        int cEnd = 0, jEnd = 0;

        for (int[] activity : activities) {
            String key = activity[0] + "-" + activity[1];
            int index = activityMap.get(key);
            if (activity[0] >= cEnd) {
                schedule[index] = 'C';
                cEnd = activity[1];
            } else if (activity[0] >= jEnd) {
                schedule[index] = 'J';
                jEnd = activity[1];
            } else {
                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        System.out.println("Case #" + testCaseNumber + ": " + new String(schedule));
    }
}