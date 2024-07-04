import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.util.Collections.sort;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        PrintStream output = System.out;
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            List<Activity> sortedActivities = new ArrayList<>(activities);
            sort(sortedActivities);

            Activity cameron = new Activity(-1, -1);
            Activity jamie = new Activity(-1, -1);
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : sortedActivities) {
                if (cameron.end <= activity.start) {
                    activity.owner = "C";
                    cameron = activity;
                } else if (jamie.end <= activity.start) {
                    activity.owner = "J";
                    jamie = activity;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (!schedule.toString().equals("IMPOSSIBLE")) {
                for (Activity activity : activities) {
                    schedule.append(activity.owner);
                }
            }

            output.println("Case #" + t + ": " + schedule);
        }
    }

    private static class Activity implements Comparable<Activity> {
        int start, end;
        String owner;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    ", owner='" + owner + '\'' +
                    '}';
        }
    }
}