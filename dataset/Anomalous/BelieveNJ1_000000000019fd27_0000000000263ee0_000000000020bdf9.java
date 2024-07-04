package codejam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ParentingPartneringReturns {

    static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static String assignActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt((Activity a) -> a.start).thenComparingInt(a -> a.end));

        int cEnd = -1, jEnd = -1;
        char[] schedule = new char[activities.length];

        for (Activity activity : activities) {
            if (cEnd <= activity.start) {
                schedule[activity.index] = 'C';
                cEnd = activity.end;
            } else if (jEnd <= activity.start) {
                schedule[activity.index] = 'J';
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(schedule);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            String answer = assignActivities(activities);
            result.append("Case #").append(testCase).append(": ").append(answer).append("\n");
        }

        System.out.print(result);
    }
}