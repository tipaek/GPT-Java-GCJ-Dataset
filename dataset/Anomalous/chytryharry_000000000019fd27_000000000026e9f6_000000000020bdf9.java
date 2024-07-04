import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            String result = scheduleActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String scheduleActivities(List<Activity> activities) {
        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();
        List<Assignment> assignments = new ArrayList<>();
        Map<Activity, Integer> activityIndexMap = new HashMap<>();
        
        for (int i = 0; i < activities.size(); i++) {
            activityIndexMap.put(activities.get(i), i);
        }
        
        activities.sort(Comparator.comparingInt(a -> a.end));
        
        for (Activity activity : activities) {
            if (isAssignable(cameronActivities, activity)) {
                cameronActivities.add(activity);
                assignments.add(new Assignment(activity, 'C'));
            } else if (isAssignable(jamieActivities, activity)) {
                jamieActivities.add(activity);
                assignments.add(new Assignment(activity, 'J'));
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        char[] result = new char[activities.size()];
        for (Assignment assignment : assignments) {
            result[activityIndexMap.get(assignment.activity)] = assignment.person;
        }
        
        return new String(result);
    }

    private static boolean isAssignable(List<Activity> activities, Activity newActivity) {
        for (Activity activity : activities) {
            if (!(newActivity.start >= activity.end || newActivity.end <= activity.start)) {
                return false;
            }
        }
        return true;
    }

    private static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Activity activity = (Activity) o;
            return start == activity.start && end == activity.end && index == activity.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, index);
        }
    }

    private static class Assignment {
        Activity activity;
        char person;

        Assignment(Activity activity, char person) {
            this.activity = activity;
            this.person = person;
        }
    }
}