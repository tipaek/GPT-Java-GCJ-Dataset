import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            String result = assignActivities(activities, numActivities);
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }

    private static String assignActivities(List<Activity> activities, int numActivities) {
        Collections.sort(activities, (a1, a2) -> Integer.compare(a1.start, a2.start));
        String[] assignments = new String[numActivities];
        List<Activity> cActivities = new LinkedList<>();
        List<Activity> jActivities = new LinkedList<>();
        
        for (Activity activity : activities) {
            if (cActivities.isEmpty() || activity.start >= cActivities.get(cActivities.size() - 1).end) {
                cActivities.add(activity);
                assignments[activity.position] = "C";
            } else if (jActivities.isEmpty() || activity.start >= jActivities.get(jActivities.size() - 1).end) {
                jActivities.add(activity);
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

    static class Activity {
        int start;
        int end;
        int position;

        Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }
}