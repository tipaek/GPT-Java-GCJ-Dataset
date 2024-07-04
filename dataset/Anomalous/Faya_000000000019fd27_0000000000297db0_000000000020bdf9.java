import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        String[] results = new String[testCaseCount];
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            int activityCount = scanner.nextInt();
            scanner.nextLine();
            Activity[] activities = new Activity[activityCount];

            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Activity(start, end, j);
                scanner.nextLine();
            }

            results[i] = scheduleActivities(activities, i + 1);
        }
        scanner.close();

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String scheduleActivities(Activity[] activities, int testCaseNumber) {
        Arrays.sort(activities);
        String[] schedule = new String[activities.length];
        Activity lastC = null;
        Activity lastJ = null;

        for (Activity activity : activities) {
            if (lastC == null || activity.start >= lastC.end) {
                lastC = activity;
                schedule[activity.index] = "C";
            } else if (lastJ == null || activity.start >= lastJ.end) {
                lastJ = activity;
                schedule[activity.index] = "J";
            } else {
                return "Case #" + testCaseNumber + ": IMPOSSIBLE";
            }
        }

        return "Case #" + testCaseNumber + ": " + String.join("", schedule);
    }
}

class Activity implements Comparable<Activity> {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.end, other.end);
    }
}