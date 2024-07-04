import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int activityNumber = 0; activityNumber < numberOfActivities; activityNumber++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime, activityNumber));
            }
            System.out.println("Case #" + caseNumber + ": " + assignActivities(activities));
        }
    }

    private static String assignActivities(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(a -> a.startTime));
        int cEnd = 0, jEnd = 0;
        char[] result = new char[activities.size()];

        for (Activity activity : activities) {
            if (activity.startTime >= cEnd) {
                result[activity.index] = 'C';
                cEnd = activity.endTime;
            } else if (activity.startTime >= jEnd) {
                result[activity.index] = 'J';
                jEnd = activity.endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    private static class Activity {
        int startTime;
        int endTime;
        int index;

        Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }
    }
}