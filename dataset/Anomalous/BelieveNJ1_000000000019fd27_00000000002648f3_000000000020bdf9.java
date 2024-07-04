import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static String assignActivities(Activity[] activities) {
        Arrays.sort(activities, (a1, a2) -> {
            if (a1.start != a2.start) {
                return Integer.compare(a1.start, a2.start);
            } else {
                return Integer.compare(a1.end, a2.end);
            }
        });

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
        StringBuilder resultBuilder = new StringBuilder();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = scanner.nextInt();
            Activity[] activities = new Activity[activityCount];

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            String result = assignActivities(activities);
            resultBuilder.append("Case #").append(testCase).append(": ").append(result).append("\n");
        }

        System.out.print(resultBuilder.toString());
    }
}