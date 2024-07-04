import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            List<Activity> activities = readActivities(scanner);
            assignActivities(activities);
            System.out.println("Case #" + (t + 1) + ": " + formatOutput(activities));
        }
    }

    private static List<Activity> readActivities(Scanner scanner) {
        int n = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(i, start, end));
        }
        
        return activities;
    }

    private static void assignActivities(List<Activity> activities) {
        Collections.sort(activities);
        int cEnd = 0, jEnd = 0;
        
        for (Activity activity : activities) {
            if (activity.start >= jEnd) {
                jEnd = activity.end;
                activity.assignee = "J";
            } else if (activity.start >= cEnd) {
                cEnd = activity.end;
                activity.assignee = "C";
            } else {
                activity.assignee = null;
            }
        }
    }

    private static String formatOutput(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.index));
        StringBuilder result = new StringBuilder();
        
        for (Activity activity : activities) {
            if (activity.assignee == null) {
                return "IMPOSSIBLE";
            }
            result.append(activity.assignee);
        }
        
        return result.toString();
    }
}

class Activity implements Comparable<Activity> {
    int index;
    int start;
    int end;
    String assignee;

    public Activity(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}