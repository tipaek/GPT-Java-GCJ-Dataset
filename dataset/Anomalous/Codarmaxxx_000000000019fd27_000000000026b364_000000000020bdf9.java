import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            String result = assignActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignActivities(Activity[] activities) {
        int[] schedule = new int[1440];
        char[] assignments = new char[activities.length];

        for (Activity activity : activities) {
            if (canAssign(schedule, activity.start, activity.end, 1)) {
                assign(schedule, activity.start, activity.end, 1);
                assignments[activity.index] = 'C';
            } else if (canAssign(schedule, activity.start, activity.end, 2)) {
                assign(schedule, activity.start, activity.end, 2);
                assignments[activity.index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }

    private static boolean canAssign(int[] schedule, int start, int end, int person) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == person) {
                return false;
            }
        }
        return true;
    }

    private static void assign(int[] schedule, int start, int end, int person) {
        for (int i = start; i < end; i++) {
            schedule[i] = person;
        }
    }

    private static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}