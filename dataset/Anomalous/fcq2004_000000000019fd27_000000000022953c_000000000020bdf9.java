import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int a = 0; a < activitiesCount; a++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            System.out.println("Case #" + (t + 1) + ": " + assignActivities(activities));
        }
    }

    static String assignActivities(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        int cEnd = 0, jEnd = 0;

        activities.sort(Comparator.comparingInt(a -> a.start));

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                result.append('C');
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                result.append('J');
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    static class Activity {
        int start, end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}