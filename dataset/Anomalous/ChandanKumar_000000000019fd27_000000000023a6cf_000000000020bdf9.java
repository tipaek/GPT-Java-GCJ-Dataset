import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = scanner.nextInt();
            Activity[] activities = new Activity[activitiesCount];
            int[] startTimes = new int[activitiesCount];

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Activity(start, end, j);
                startTimes[j] = start;
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            StringBuilder schedule = new StringBuilder();
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;

            for (Activity activity : activities) {
                if (cameronEnd <= activity.start) {
                    cameronEnd = activity.end;
                    activity.assignedTo = 'C';
                } else if (jamieEnd <= activity.start) {
                    jamieEnd = activity.end;
                    activity.assignedTo = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                char[] finalSchedule = new char[activitiesCount];
                for (Activity activity : activities) {
                    finalSchedule[activity.index] = activity.assignedTo;
                }
                results[i] = new String(finalSchedule);
            } else {
                results[i] = "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, results[i]));
        }
    }

    static class Activity {
        int start, end, index;
        char assignedTo;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}