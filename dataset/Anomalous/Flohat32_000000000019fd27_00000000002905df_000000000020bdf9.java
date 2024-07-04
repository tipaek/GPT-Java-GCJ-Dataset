import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MainC {

    public static class Activity {
        public final int id;
        public final int start;
        public final int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    public static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.start, a2.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int i = 0; i < numActivities; i++) {
                activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(activities, new ActivityComparator());

            char[] assignments = new char[numActivities];
            int cAvailable = 0;
            int jAvailable = 0;
            boolean isPossible = true;

            for (Activity activity : activities) {
                if (cAvailable <= activity.start) {
                    assignments[activity.id] = 'C';
                    cAvailable = activity.end;
                } else if (jAvailable <= activity.start) {
                    assignments[activity.id] = 'J';
                    jAvailable = activity.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isPossible) {
                for (char assignment : assignments) {
                    result.append(assignment);
                }
            } else {
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}