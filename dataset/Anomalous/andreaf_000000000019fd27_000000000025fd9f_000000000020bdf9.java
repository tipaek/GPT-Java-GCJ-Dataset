import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCase = sc.nextInt();
            for (int i = 0; i < numberOfTestCase; i++) {
                int numberOfActivities = sc.nextInt();
                List<Activity> activities = new ArrayList<>();
                for (int activity = 0; activity < numberOfActivities; activity++) {
                    int startTime = sc.nextInt();
                    int endTime = sc.nextInt();
                    activities.add(new Activity(startTime, endTime));
                }
                activities.sort(Comparator.comparingInt(a -> a.startTime));
                int cameronEndTurn = -1;
                int jamieEndTurn = -1;
                StringBuilder schedule = new StringBuilder();
                int activityIndex = 0;
                for (int minute = 0; minute <= 24 * 60; minute++) {
                    if (activityIndex >= activities.size()) {
                        break;
                    }
                    Activity activity = activities.get(activityIndex);
                    if (activity.startTime > minute) {
                        continue;
                    }
                    if (cameronEndTurn != -1 && minute >= cameronEndTurn) {
                        cameronEndTurn = -1;
                    }
                    if (jamieEndTurn != -1 && minute >= jamieEndTurn) {
                        jamieEndTurn = -1;
                    }
                    if (cameronEndTurn == -1) {
                        schedule.append("C");
                        cameronEndTurn = activity.endTime;
                        activityIndex++;
                        minute--;
                    } else if (jamieEndTurn == -1) {
                        schedule.append("J");
                        jamieEndTurn = activity.endTime;
                        activityIndex++;
                        minute--;
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                System.out.println(String.format("Case #%d: %s", (i + 1), schedule.toString()));
            }
        }
    }

    private static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}