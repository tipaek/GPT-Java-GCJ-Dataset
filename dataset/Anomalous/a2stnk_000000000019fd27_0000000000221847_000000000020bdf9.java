import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int index, start, end, person;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                System.out.printf("Case #%d: ", i + 1);
                solveTestCase(scanner);
            }
        }
    }

    private static void solveTestCase(Scanner scanner) {
        int activityCount = scanner.nextInt();
        Activity[] activities = new Activity[activityCount];
        
        for (int i = 0; i < activityCount; i++) {
            activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.start, a2.start));

        Activity[] currentActivities = new Activity[2];
        
        for (Activity activity : activities) {
            boolean assigned = false;
            for (int j = 0; j < 2; j++) {
                if (currentActivities[j] == null || currentActivities[j].end <= activity.start) {
                    currentActivities[j] = activity;
                    activity.person = j;
                    assigned = true;
                    break;
                }
            }
            if (!assigned) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.index, a2.index));

        for (Activity activity : activities) {
            System.out.print(activity.person == 0 ? "C" : "J");
        }
        System.out.println();
    }
}