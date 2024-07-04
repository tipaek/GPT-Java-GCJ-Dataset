import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = initializeScanner();

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; ++i) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            Activity cameron = null;
            Activity jamie = null;
            StringBuilder result = new StringBuilder();

            int j;
            for (j = 0; j < activityCount; j++) {
                Activity currentActivity = activities.get(j);
                if (cameron == null || !cameron.isOverlapping(currentActivity)) {
                    cameron = currentActivity;
                    currentActivity.setAssignee("C");
                } else if (jamie == null || !jamie.isOverlapping(currentActivity)) {
                    jamie = currentActivity;
                    currentActivity.setAssignee("J");
                } else {
                    break;
                }
            }

            if (j != activityCount) {
                System.out.printf("Case #%d: IMPOSSIBLE%s", i, i != testCases ? "\n" : "");
            } else {
                activities.sort(Comparator.comparingInt(a -> a.originalIndex));
                activities.forEach(activity -> result.append(activity.assignee));
                System.out.printf("Case #%d: %s%s", i, result.toString(), i != testCases ? "\n" : "");
            }
        }
        scanner.close();
    }

    private static Scanner initializeScanner() throws FileNotFoundException {
        if (IS_PRACTICE) {
            String outputFileName = "output-" + INPUT_FILE_NAME + ".out";
            System.setOut(new PrintStream(new File(outputFileName)));
            return new Scanner(new FileReader(INPUT_FILE_NAME + ".in"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    public static class Activity {
        int start;
        int end;
        int originalIndex;
        String assignee;

        public Activity(int start, int end, int originalIndex) {
            this.start = start;
            this.end = end;
            this.originalIndex = originalIndex;
            this.assignee = null;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public boolean isOverlapping(Activity other) {
            return this.start < other.end && other.start < this.end;
        }
    }
}