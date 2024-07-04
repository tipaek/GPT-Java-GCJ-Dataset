import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }

            System.out.println("Case #" + caseNum + ": " + scheduleActivities(activities));
        }
    }

    private static String scheduleActivities(int[][] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        StringBuilder schedule = new StringBuilder(activities.length);
        int endCameron = -1;
        int endJamie = -1;

        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];

            if (start >= endCameron) {
                endCameron = end;
                schedule.append("C");
            } else if (start >= endJamie) {
                endJamie = end;
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}