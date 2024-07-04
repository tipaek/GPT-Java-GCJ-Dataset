import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            String result = assignActivities(activities, activitiesCount);
            System.out.println("Case #" + caseNum + ": " + result);
        }
        
        scanner.close();
    }

    private static String assignActivities(List<Activity> activities, int totalActivities) {
        Collections.sort(activities);
        String[] assignments = new String[totalActivities];
        Arrays.fill(assignments, "");
        
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        
        for (Activity activity : activities) {
            if (cameronActivities.isEmpty()) {
                cameronActivities.add(activity);
                assignments[activity.getPosition()] = "C";
            } else if (jamieActivities.isEmpty()) {
                jamieActivities.add(activity);
                assignments[activity.getPosition()] = "J";
            } else {
                int currentStartTime = activity.getStart();
                
                if (currentStartTime >= cameronActivities.get(cameronActivities.size() - 1).getEnd()) {
                    cameronActivities.add(activity);
                    assignments[activity.getPosition()] = "C";
                } else if (currentStartTime >= jamieActivities.get(jamieActivities.size() - 1).getEnd()) {
                    jamieActivities.add(activity);
                    assignments[activity.getPosition()] = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        return String.join("", assignments);
    }

    static class Activity implements Comparable<Activity> {
        private final int start;
        private final int end;
        private final int position;

        Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}