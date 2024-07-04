import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = in.nextInt();
        
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = in.nextInt();
            int[][] activities = new int[activityCount][2];
            Map<String, Integer> activityMap = new HashMap<>();
            boolean impossible = false;
            
            for (int j = 0; j < activityCount; j++) {
                for (int k = 0; k < 2; k++) {
                    activities[j][k] = in.nextInt();
                }
                String key = activities[j][0] + "-" + activities[j][1];
                if (activityMap.get(key) == null) {
                    activityMap.put(key, j);
                } else {
                    key += "*";
                    if (activityMap.get(key) == null) {
                        activityMap.put(key, j);
                    } else {
                        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                        impossible = true;
                        break;
                    }
                }
            }
            
            if (!impossible) {
                assignActivities(activities, testCase, activityMap);
            }
        }
    }

    public static void assignActivities(int[][] activities, int testCase, Map<String, Integer> activityMap) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        char[] result = new char[activities.length];
        result[activityMap.get(activities[0][0] + "-" + activities[0][1])] = 'C';
        activityMap.remove(activities[0][0] + "-" + activities[0][1]);
        
        int cEnd = activities[0][1];
        int jEnd = 0;

        for (int i = 1; i < activities.length; i++) {
            String key = activities[i][0] + "-" + activities[i][1];
            if (activityMap.get(key) == null) {
                key += "*";
            }
            Integer index = activityMap.get(key);
            if (index == null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
            if (activities[i][0] >= cEnd) {
                result[index] = 'C';
                cEnd = activities[i][1];
            } else if (activities[i][0] >= jEnd) {
                result[index] = 'J';
                jEnd = activities[i][1];
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
            activityMap.remove(key);
        }
        
        System.out.println("Case #" + testCase + ": " + new String(result));
    }
}