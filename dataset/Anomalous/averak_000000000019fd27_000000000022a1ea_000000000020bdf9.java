import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            int[][] activities = new int[activitiesCount][2];
            Map<String, Integer> activityMap = new HashMap<>();
            boolean isImpossible = false;
            
            for (int i = 0; i < activitiesCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activityMap.put(activities[i][0] + "-" + activities[i][1], i);
            }
            
            if (!isImpossible) {
                assignActivities(activities, t, activityMap);
            }
        }
    }

    private static void assignActivities(int[][] activities, int caseNumber, Map<String, Integer> activityMap) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
        char[] schedule = new char[activities.length];
        
        schedule[activityMap.get(activities[0][0] + "-" + activities[0][1])] = 'C';
        int cEnd = activities[0][1];
        int jEnd = 0;

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= cEnd) {
                schedule[activityMap.get(activities[i][0] + "-" + activities[i][1])] = 'C';
                cEnd = activities[i][1];
            } else if (activities[i][0] >= jEnd) {
                schedule[activityMap.get(activities[i][0] + "-" + activities[i][1])] = 'J';
                jEnd = activities[i][1];
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                return;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + new String(schedule));
    }
}