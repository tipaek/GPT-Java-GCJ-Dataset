import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            scanner.nextLine();
            Activity[] activities = new Activity[numActivities];

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[j] = new Activity(start, end, j);
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
        String[] assignment = new String[activities.length];
        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

        int cEnd = 0;
        int jEnd = 0;

        for (Activity activity : activities) {
            if (cEnd <= activity.start) {
                cEnd = activity.end;
                assignment[activity.index] = "C";
            } else if (jEnd <= activity.start) {
                jEnd = activity.end;
                assignment[activity.index] = "J";
            } else {
                return "Case #" + caseNumber + ": IMPOSSIBLE";
            }
        }

        return "Case #" + caseNumber + ": " + String.join("", assignment);
    }
}

class Activity {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}