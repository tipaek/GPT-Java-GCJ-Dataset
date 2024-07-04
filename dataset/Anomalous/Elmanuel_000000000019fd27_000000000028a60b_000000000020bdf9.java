import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, i));
            }
            
            String result = assignActivities(activities, numberOfActivities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    private static String assignActivities(List<Activity> activities, int numberOfActivities) {
        Collections.sort(activities);
        String[] schedule = new String[numberOfActivities];
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        
        for (Activity activity : activities) {
            if (cameronActivities.isEmpty() || activity.start >= cameronActivities.get(cameronActivities.size() - 1).end) {
                cameronActivities.add(activity);
                schedule[activity.position] = "C";
            } else if (jamieActivities.isEmpty() || activity.start >= jamieActivities.get(jamieActivities.size() - 1).end) {
                jamieActivities.add(activity);
                schedule[activity.position] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String s : schedule) {
            result.append(s);
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