import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rene Argento on 03/04/20.
 */
// https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020bdf9
public class Solution {

    public static class Activity implements Comparable<Activity> {
        int startTime;
        int endTime;
        int id;

        public Activity(int startTime, int endTime, int id) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.id = id;
        }

        @Override
        public int compareTo(Activity other) {
            return startTime - other.startTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 1; t <= tests; t++) {
            int totalActivities = scanner.nextInt();
            Activity[] activities = new Activity[totalActivities];

            for (int i = 0; i < totalActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            String schedule = getSchedule(activities);
            System.out.println("Case #" + t + ": " + schedule);
        }
    }

    private static String getSchedule(Activity[] activities) {
        String[] scheduleInOrder = new String[activities.length];
        int cameronNextFreeTime = 0;
        int jamieNextFreeTime = 0;

        Arrays.sort(activities);

        for (Activity activity : activities) {
            if (activity.startTime >= cameronNextFreeTime) {
                scheduleInOrder[activity.id] = "C";
                cameronNextFreeTime = activity.endTime;
            } else if (activity.startTime >= jamieNextFreeTime) {
                scheduleInOrder[activity.id] = "J";
                jamieNextFreeTime = activity.endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder schedule = new StringBuilder();
        for (String name : scheduleInOrder) {
            schedule.append(name);
        }
        return schedule.toString();
    }

}
