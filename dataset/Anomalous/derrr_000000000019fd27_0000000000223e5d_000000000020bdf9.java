import java.util.*;
import java.io.*;

public class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }
            String result = scheduleActivities(activities);
            System.out.printf("Case #%d: %s%n", i, result);
        }
    }

    private static String scheduleActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt((Activity a) -> a.start).thenComparingInt(a -> a.end));
        int cameronEnd = 0;
        int jamieEnd = 0;
        char[] result = new char[activities.size()];

        for (Activity activity : activities) {
            if (activity.start >= cameronEnd) {
                cameronEnd = activity.end;
                result[activity.index] = 'C';
            } else if (activity.start >= jamieEnd) {
                jamieEnd = activity.end;
                result[activity.index] = 'J';
            } else {
                return IMPOSSIBLE;
            }
        }
        return new String(result);
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