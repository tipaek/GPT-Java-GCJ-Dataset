import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            System.out.println("Case #" + testCase + ": " + findSchedule(activityCount, scanner));
        }
    }

    static class Activity {
        int time;
        boolean isStart;
        int index;

        public Activity(int time, boolean isStart, int index) {
            this.time = time;
            this.isStart = isStart;
            this.index = index;
        }
    }

    private static String findSchedule(int activityCount, Scanner scanner) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < activityCount; i++) {
            activities.add(new Activity(scanner.nextInt(), true, i));
            activities.add(new Activity(scanner.nextInt(), false, i));
        }

        activities.sort((a1, a2) -> {
            if (a1.time == a2.time) {
                return a1.isStart ? 1 : -1;
            }
            return Integer.compare(a1.time, a2.time);
        });

        char[] schedule = new char[activityCount];
        int cameron = -1;
        int jamie = -1;

        for (Activity activity : activities) {
            if (activity.isStart) {
                if (cameron == -1) {
                    cameron = activity.index;
                    schedule[activity.index] = 'C';
                } else if (jamie == -1) {
                    jamie = activity.index;
                    schedule[activity.index] = 'J';
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                if (cameron == activity.index) {
                    cameron = -1;
                } else if (jamie == activity.index) {
                    jamie = -1;
                }
            }
        }

        return new String(schedule);
    }
}