import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = getActivities(activityCount, scanner);
            String result = assignTasks(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static List<Activity> getActivities(int activityCount, Scanner scanner) {
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < activityCount; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end));
        }
        return activities;
    }

    private static String assignTasks(List<Activity> activities) {
        StringBuilder assignment = new StringBuilder("C");
        Activity cameron = activities.get(0);
        Activity jamie = new Activity(0, 0);
        
        for (int i = 1; i < activities.size(); i++) {
            Activity current = activities.get(i);
            Activity previous = activities.get(i - 1);
            String assignTo = "C";
            
            if (current.start == previous.end) {
                assignTo = assignment.substring(assignment.length() - 1);
            } else if (cameron.overlaps(current) && jamie.overlaps(current)) {
                return "IMPOSSIBLE";
            } else if (cameron.overlaps(current)) {
                assignTo = "J";
            } else if (jamie.overlaps(current)) {
                assignTo = "C";
            }

            if (assignTo.equals("J")) {
                jamie = current;
            } else {
                cameron = current;
            }
            assignment.append(assignTo);
        }

        return assignment.toString();
    }

    static class Activity {
        int start;
        int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean overlaps(Activity other) {
            return (this.start < other.end && this.end > other.start);
        }
    }
}