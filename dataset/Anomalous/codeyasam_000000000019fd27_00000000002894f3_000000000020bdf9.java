import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = getActivities(activitiesCount, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static List<Activity> getActivities(int count, Scanner scanner) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end));
        }
        return activities;
    }

    private static String assignTasks(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        Person cameron = new Person("C");
        Person jamie = new Person("J");

        for (Activity activity : activities) {
            if (cameron.isOverlapping(activity) && jamie.isOverlapping(activity)) {
                return "IMPOSSIBLE";
            } else if (cameron.isOverlapping(activity)) {
                jamie.addActivity(activity);
                result.append("J");
            } else {
                cameron.addActivity(activity);
                result.append("C");
            }
        }

        return result.toString();
    }

    static class Person {
        private String name;
        private List<Activity> activities;

        public Person(String name) {
            this.name = name;
            this.activities = new ArrayList<>();
        }

        public boolean isOverlapping(Activity activity) {
            for (Activity a : activities) {
                if (a.isOverlapping(activity)) {
                    return true;
                }
            }
            return false;
        }

        public void addActivity(Activity activity) {
            activities.add(activity);
        }
    }

    static class Activity {
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(Activity other) {
            return (this.start < other.end && this.end > other.start);
        }
    }
}