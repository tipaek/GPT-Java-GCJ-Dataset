import java.util.*;
import java.io.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < activityCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            System.out.println("Case #" + (t + 1) + ": " + assignActivities(activities));
        }
        scanner.close();
    }

    private static String assignActivities(List<Activity> activities) {
        List<Activity> sortedActivities = new ArrayList<>(activities);
        Collections.sort(sortedActivities);
        int cEnd = 0, jEnd = 0;

        for (Activity activity : sortedActivities) {
            if (cEnd <= activity.startTime) {
                activity.assignedTo = 'C';
                cEnd = activity.endTime;
            } else if (jEnd <= activity.startTime) {
                activity.assignedTo = 'J';
                jEnd = activity.endTime;
            } else {
                return IMPOSSIBLE;
            }
        }

        Collections.sort(sortedActivities, Comparator.comparingInt(a -> a.index));
        StringBuilder result = new StringBuilder();
        for (Activity activity : sortedActivities) {
            result.append(activity.assignedTo);
        }
        return result.toString();
    }

    private static class Activity implements Comparable<Activity> {
        private final int startTime;
        private final int endTime;
        private final int index;
        private char assignedTo;

        Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }
}