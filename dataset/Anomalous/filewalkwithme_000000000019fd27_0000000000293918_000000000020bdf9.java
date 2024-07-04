import java.util.*;
import java.io.*;

class Activity implements Comparable<Activity> {
    int start;
    int end;

    @Override
    public int compareTo(Activity other) {
        return this.start - other.start;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Activity activity = (Activity) obj;
        return start == activity.start;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            TreeSet<Activity> JActivities = new TreeSet<>();
            TreeSet<Activity> CActivities = new TreeSet<>();

            for (int i = 0; i < activityCount; i++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.end = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                if (assignActivity(JActivities, activity, 'J', result) ||
                    assignActivity(CActivities, activity, 'C', result)) {
                    continue;
                }

                result.setLength(0);
                result.append("IMPOSSIBLE");
                isImpossible = true;
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static boolean assignActivity(TreeSet<Activity> activities, Activity activity, char person, StringBuilder result) {
        if (activities.isEmpty()) {
            activities.add(activity);
            result.append(person);
            return true;
        }

        Activity before = activities.lower(activity);
        Activity after = activities.higher(activity);

        if ((before == null || before.end <= activity.start) && 
            (after == null || activity.end <= after.start)) {
            activities.add(activity);
            result.append(person);
            return true;
        }

        return false;
    }
}