import java.io.*;
import java.time.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCases = Integer.parseInt(reader.readLine());

            for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
                int numberOfActivities = Integer.parseInt(reader.readLine());
                List<Activity> activities = new ArrayList<>();

                for (int i = 0; i < numberOfActivities; i++) {
                    String[] times = reader.readLine().split(" ");
                    int start = Integer.parseInt(times[0]);
                    int end = Integer.parseInt(times[1]);
                    activities.add(new Activity(start, end, i));
                }

                activities.sort(Comparator.comparingInt(a -> a.start));
                String result = assignActivities(activities, numberOfActivities);
                System.out.println("Case #" + caseIndex + ": " + result);
            }
        }
    }

    private static String assignActivities(List<Activity> activities, int numberOfActivities) {
        int[] assignedPersons = new int[numberOfActivities];
        int endJ = 0, endC = 0;

        for (Activity activity : activities) {
            if (activity.start >= endJ) {
                assignedPersons[activity.index] = 'J';
                endJ = activity.end;
            } else if (activity.start >= endC) {
                assignedPersons[activity.index] = 'C';
                endC = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (int person : assignedPersons) {
            result.append((char) person);
        }
        return result.toString();
    }

    private static class Activity {
        int start, end, index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}