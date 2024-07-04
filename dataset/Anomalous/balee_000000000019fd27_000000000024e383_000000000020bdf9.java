import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Activity {
        int start;
        int end;
        char assignedTo;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    private static String process(Scanner scanner) {
        int numActivities = scanner.nextInt();
        Activity[] activities = new Activity[numActivities];
        Activity[] sortedActivities = new Activity[numActivities];

        for (int i = 0; i < numActivities; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            activities[i] = new Activity(start, end);
            sortedActivities[i] = activities[i];
        }

        Arrays.sort(sortedActivities, (a, b) -> Integer.compare(a.start, b.start));

        Activity lastC = null;
        Activity lastJ = null;

        for (Activity activity : sortedActivities) {
            if (lastC == null || lastC.end <= activity.start) {
                lastC = activity;
                activity.assignedTo = 'C';
            } else if (lastJ == null || lastJ.end <= activity.start) {
                lastJ = activity;
                activity.assignedTo = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.assignedTo);
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in.available() > 0 ? System.in :
            new FileInputStream(Thread.currentThread().getStackTrace()[1].getClassName() + ".practice.in"));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            System.out.printf("Case #%d: %s\n", i, process(scanner));
        }
    }
}