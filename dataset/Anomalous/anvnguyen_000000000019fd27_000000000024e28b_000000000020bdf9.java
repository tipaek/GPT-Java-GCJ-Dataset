import java.util.*;
import java.io.*;

public class Solution {
    private static class Activity implements Comparable<Activity> {
        int index;
        char person;
        int start;
        int end;

        public Activity(int index, char person, int start, int end) {
            this.index = index;
            this.person = person;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(i, ' ', start, end));
            }
            String result = scheduleActivities(activities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String scheduleActivities(List<Activity> activities) {
        Collections.sort(activities);

        int cEnd = 0, jEnd = 0;
        boolean possible = true;

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                activity.person = 'C';
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                activity.person = 'J';
                jEnd = activity.end;
            } else {
                possible = false;
                break;
            }
        }

        if (!possible) {
            return "IMPOSSIBLE";
        }

        char[] result = new char[activities.size()];
        for (Activity activity : activities) {
            result[activity.index] = activity.person;
        }

        return new String(result);
    }
}