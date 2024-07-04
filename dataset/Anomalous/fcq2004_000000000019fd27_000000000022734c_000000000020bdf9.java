import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    static String assignActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.start));

        int cEnd = 0, jEnd = 0;
        char[] schedule = new char[activities.size()];

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                schedule[activity.index] = 'C';
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                schedule[activity.index] = 'J';
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}