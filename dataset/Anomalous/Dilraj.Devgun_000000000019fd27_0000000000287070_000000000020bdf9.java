import java.util.*;

public class Solution {

    static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    public static void processTestCase(Scanner scanner, int caseNumber) {
        int numActivities = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities.add(new Activity(start, end, i));
        }

        activities.sort(Comparator.comparingInt(a -> a.start));

        char[] schedule = new char[numActivities];
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
}