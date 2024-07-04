import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] results = new String[size];
        scanner.nextLine();

        for (int i = 0; i < size; i++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine();
            Activity[] activities = new Activity[numActivities];

            for (int j = 0; j < numActivities; j++) {
                activities[j] = new Activity(scanner.nextInt(), scanner.nextInt(), j);
                scanner.nextLine();
            }

            results[i] = assignActivities(activities, i + 1);
        }
        scanner.close();

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String assignActivities(Activity[] activities, int caseNumber) {
        Arrays.sort(activities);

        String[] schedule = new String[activities.length];
        boolean[] assigned = new boolean[activities.length];

        Activity lastC = null;
        for (int i = 0; i < activities.length; i++) {
            if (lastC == null || activities[i].start >= lastC.end) {
                lastC = activities[i];
                schedule[activities[i].index] = "C";
                assigned[i] = true;
            }
        }

        Activity lastJ = null;
        for (int i = 0; i < activities.length; i++) {
            if (!assigned[i]) {
                if (lastJ != null && activities[i].start < lastJ.end) {
                    return "Case #" + caseNumber + ": IMPOSSIBLE";
                }
                lastJ = activities[i];
                schedule[activities[i].index] = "J";
            }
        }

        return "Case #" + caseNumber + ": " + String.join("", schedule);
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
        if (this.end != other.end) {
            return Integer.compare(this.end, other.end);
        }
        return Integer.compare(other.start, this.start);
    }
}