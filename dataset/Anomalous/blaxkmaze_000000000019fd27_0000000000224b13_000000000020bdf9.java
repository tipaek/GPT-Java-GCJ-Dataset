import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private String scheduler(int[][] activities) {
        if (activities == null || activities.length == 0) return "";

        Map<Activity, Integer> activityMap = new HashMap<>();
        List<Activity> activityList = new ArrayList<>();
        int freeForC = 0;
        int freeForJ = 0;

        for (int i = 0; i < activities.length; i++) {
            Activity a = new Activity(activities[i][0], activities[i][1]);
            activityMap.put(a, i);
            activityList.add(a);
        }

        Collections.sort(activityList, (a, b) -> a.startTime == b.startTime ? b.endTime - a.endTime : a.startTime - b.startTime);
        char[] output = new char[activities.length];
        for (Activity a : activityList) {
            if (a.startTime >= freeForC) {
                freeForC = a.endTime;
                output[activityMap.get(a)] = 'C';
            } else if (a.startTime >= freeForJ) {
                freeForJ = a.endTime;
                output[activityMap.get(a)] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(output);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testSize = in.nextInt();
        for (int i = 1; i <= testSize; ++i) {
            int activitySize = in.nextInt();
            int[][] activities = new int[activitySize][2];
            for (int j = 0; j < activitySize; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
            }
            String output = new Solution().scheduler(activities);
            System.out.printf("Case #%d: %s%n", i, output);
        }
    }
}