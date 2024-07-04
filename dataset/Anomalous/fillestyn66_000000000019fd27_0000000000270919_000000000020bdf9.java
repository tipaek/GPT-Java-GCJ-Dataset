import java.util.*;
import java.io.*;

public class Solution {

    private static class Activity implements Comparable<Activity> {
        public Integer start;
        public Integer stop;

        @Override
        public int compareTo(Activity other) {
            return this.start.compareTo(other.start);
        }

        @Override
        public String toString() {
            return start + " " + stop;
        }
    }

    private static class Person {
        public String initial;
        public Activity activity;

        public boolean canTakeActivity(Activity newActivity) {
            return newActivity.stop <= activity.start || newActivity.start >= activity.stop;
        }

        @Override
        public String toString() {
            return initial + " A: " + activity.toString() + "\n";
        }
    }

    private static String processResult(List<Activity> activityList) {
        StringBuilder resultString = new StringBuilder();

        Person C = new Person();
        C.initial = "C";
        Person J = new Person();
        J.initial = "J";

        for (Activity activity : activityList) {
            if (C.activity == null) {
                C.activity = activity;
                resultString.append(C.initial);
            } else if (J.activity == null) {
                J.activity = activity;
                resultString.append(J.initial);
            } else if (C.canTakeActivity(activity)) {
                C.activity = activity;
                resultString.append(C.initial);
            } else if (J.canTakeActivity(activity)) {
                J.activity = activity;
                resultString.append(J.initial);
            } else {
                return "IMPOSSIBLE";
            }
        }
        return resultString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numOfActivities = scanner.nextInt();
            List<Activity> activityList = new ArrayList<>();
            
            for (int j = 0; j < numOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.stop = scanner.nextInt();
                activityList.add(activity);
            }
            
            Collections.sort(activityList); // Ensure activities are sorted by start time
            System.out.println("Case #" + i + ": " + processResult(activityList));
        }
        
        scanner.close();
    }
}