import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            String result = assignActivities(activities, N);
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }

    private static String assignActivities(List<Activity> activities, int N) {
        Collections.sort(activities);
        String[] assignments = new String[N];
        List<Activity> cActivities = new ArrayList<>();
        List<Activity> jActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (canAssign(cActivities, activity)) {
                cActivities.add(activity);
                assignments[activity.position] = "C";
            } else if (canAssign(jActivities, activity)) {
                jActivities.add(activity);
                assignments[activity.position] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        return String.join("", assignments);
    }

    private static boolean canAssign(List<Activity> assignedActivities, Activity newActivity) {
        return assignedActivities.isEmpty() || newActivity.start >= assignedActivities.get(assignedActivities.size() - 1).end;
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int position;

        Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}