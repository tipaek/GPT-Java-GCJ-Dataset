import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            handleTestCase(scanner, i);
        }
    }
    
    private static void handleTestCase(Scanner scanner, int caseNumber) {
        int numActivities = scanner.nextInt();
        Activity[] activities = new Activity[numActivities];
        char[] schedule = new char[numActivities];

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities[i] = new Activity(start, end, i);
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

        int cEnd = 0, jEnd = 0;
        boolean possible = true;

        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                schedule[activity.index] = 'C';
                cEnd = activity.end;
            } else if (activity.start >= jEnd) {
                schedule[activity.index] = 'J';
                jEnd = activity.end;
            } else {
                possible = false;
                break;
            }
        }

        String result = possible ? new String(schedule) : "IMPOSSIBLE";
        System.out.println("Case #" + caseNumber + ": " + result);
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