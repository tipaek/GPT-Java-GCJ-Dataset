import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int currentCase = 1; currentCase <= numberOfCases; currentCase++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < numberOfActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            System.out.println("Case #" + currentCase + ": " + assignActivities(activities, numberOfActivities));
        }
        scanner.close();
    }

    public static String assignActivities(List<Activity> activities, int numberOfActivities) {
        Collections.sort(activities, (a1, a2) -> Integer.compare(a1.start, a2.start));
        String[] schedule = new String[numberOfActivities];
        List<Activity> cameronActivities = new LinkedList<>();
        List<Activity> jamieActivities = new LinkedList<>();

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