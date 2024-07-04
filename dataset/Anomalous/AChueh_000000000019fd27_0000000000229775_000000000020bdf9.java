import java.io.*;
import java.util.*;

public class Solution {

    static class Activity {
        final int start;
        final int end;
        final int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner scanner = null;

        try {
            scanner = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int j = 0; j < numActivities; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt(), j);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));
            System.out.println("Case #" + i + ": " + assignActivities(activities));
        }
    }

    static String assignActivities(Activity[] activities) {
        int jEnd = -1;
        int cEnd = -1;
        char[] result = new char[activities.length];

        for (Activity activity : activities) {
            if (activity.start < jEnd && activity.start < cEnd) {
                return "IMPOSSIBLE";
            }

            if (activity.start >= jEnd) {
                jEnd = activity.end;
                result[activity.index] = 'J';
            } else {
                cEnd = activity.end;
                result[activity.index] = 'C';
            }
        }

        return new String(result);
    }
}