import java.util.*;
import java.io.*;

public class Solution {

    private static final boolean IS_PRACTICE = false;
    private static final String INPUT_FILE_NAME = "test";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = getScanner();

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            Activity cameron = null;
            Activity jamie = null;
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                if (cameron == null || !cameron.overlapsWith(activity)) {
                    cameron = activity;
                    schedule.append("C");
                } else if (jamie == null || !jamie.overlapsWith(activity)) {
                    jamie = activity;
                    schedule.append("J");
                } else {
                    schedule.setLength(0);
                    break;
                }
            }

            if (schedule.length() == 0) {
                System.out.printf("Case #%d: IMPOSSIBLE%s", i, i != testCases ? "\n" : "");
            } else {
                System.out.printf("Case #%d: %s%s", i, schedule.toString(), i != testCases ? "\n" : "");
            }
        }
        scanner.close();
    }

    private static Scanner getScanner() throws FileNotFoundException {
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

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean overlapsWith(Activity other) {
            return this.start < other.end && other.start < this.end;
        }
    }
}