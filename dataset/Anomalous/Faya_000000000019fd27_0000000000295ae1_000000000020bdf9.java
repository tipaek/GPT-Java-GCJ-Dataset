import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            String[] results = new String[size];
            scanner.nextLine();

            for (int i = 0; i < size; i++) {
                int activityCount = scanner.nextInt();
                scanner.nextLine();
                Activity[] activities = new Activity[activityCount];

                for (int j = 0; j < activityCount; j++) {
                    activities[j] = new Activity(scanner.nextInt(), scanner.nextInt(), j);
                    scanner.nextLine();
                }

                results[i] = determineActivityPattern(activities, i + 1);
            }

            for (String result : results) {
                System.out.println(result);
            }
        }
    }

    private static String determineActivityPattern(Activity[] activities, int caseNumber) {
        Arrays.sort(activities);

        String[] assignments = new String[activities.length];
        boolean[] assigned = new boolean[activities.length];

        Activity lastCameron = null;
        for (int i = 0; i < activities.length; i++) {
            if (lastCameron == null || activities[i].start >= lastCameron.end) {
                lastCameron = activities[i];
                assignments[activities[i].index] = "C";
                assigned[i] = true;
            }
        }

        Activity lastJamie = null;
        for (int i = 0; i < activities.length; i++) {
            if (!assigned[i]) {
                if (lastJamie != null && activities[i].start < lastJamie.end) {
                    return "Case #" + caseNumber + ": IMPOSSIBLE";
                }
                lastJamie = activities[i];
                assignments[activities[i].index] = "J";
            }
        }

        return "Case #" + caseNumber + ": " + String.join("", assignments);
    }
}

class Activity implements Comparable<Activity> {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.end, other.end);
    }
}