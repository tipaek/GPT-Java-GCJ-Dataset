import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            System.out.println("Case #" + (t + 1) + ": " + assignActivities(activities, numActivities));
        }
    }

    private static String assignActivities(List<Activity> activities, int numActivities) {
        char[] schedule = new char[numActivities];
        int cameronEnd = 0;
        int jamieEnd = 0;

        for (Activity activity : activities) {
            if (activity.start >= cameronEnd) {
                schedule[activity.index] = 'C';
                cameronEnd = activity.end;
            } else if (activity.start >= jamieEnd) {
                schedule[activity.index] = 'J';
                jamieEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(schedule);
    }

    private static class Activity {
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