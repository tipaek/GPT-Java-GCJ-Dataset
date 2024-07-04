import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = processInput(scanner);
        System.out.println(result);
    }

    public static String processInput(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }
            result.append("Case #").append(i).append(": ").append(assignActivities(activities)).append("\n");
        }
        return result.toString();
    }

    public static String assignActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.start));
        int endC = 0, endJ = 0;
        Map<Activity, String> activityAssignments = new HashMap<>();
        
        for (Activity activity : activities) {
            if (activity.start >= endC) {
                endC = activity.end;
                activityAssignments.put(activity, "C");
            } else if (activity.start >= endJ) {
                endJ = activity.end;
                activityAssignments.put(activity, "J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activityAssignments.get(activity));
        }
        return result.toString();
    }

    public static class Activity {
        public int start;
        public int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}