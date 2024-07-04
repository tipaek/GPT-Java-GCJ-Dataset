import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int numberOfCases = scanner.nextInt();
            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int numberOfActivities = scanner.nextInt();
                List<Activity> activities = new ArrayList<>();
                for (int i = 0; i < numberOfActivities; i++) {
                    activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
                }
                System.out.println("Case #" + caseIndex + ": " + assignActivities(activities, numberOfActivities));
            }
        }
    }

    public static String assignActivities(List<Activity> activities, int numberOfActivities) {
        Collections.sort(activities);
        String[] assignedPersons = new String[numberOfActivities];
        List<Activity> cActivities = new ArrayList<>();
        List<Activity> jActivities = new ArrayList<>();

        for (Activity activity : activities) {
            if (cActivities.isEmpty() || activity.start >= cActivities.get(cActivities.size() - 1).end) {
                cActivities.add(activity);
                assignedPersons[activity.position] = "C";
            } else if (jActivities.isEmpty() || activity.start >= jActivities.get(jActivities.size() - 1).end) {
                jActivities.add(activity);
                assignedPersons[activity.position] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (String person : assignedPersons) {
            result.append(person);
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