import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            String result = assignActivities(activities, activityCount);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    public static String assignActivities(List<Activity> activities, int activityCount) {
        Collections.sort(activities);
        String[] assignments = new String[activityCount];
        Arrays.fill(assignments, "");
        
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        
        for (Activity activity : activities) {
            if (cameronActivities.isEmpty() || activity.start >= cameronActivities.get(cameronActivities.size() - 1).end) {
                cameronActivities.add(activity);
                assignments[activity.position] = "C";
            } else if (jamieActivities.isEmpty() || activity.start >= jamieActivities.get(jamieActivities.size() - 1).end) {
                jamieActivities.add(activity);
                assignments[activity.position] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String assignment : assignments) {
            result.append(assignment);
        }
        
        return result.toString();
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