import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int numberInstances = Integer.parseInt(br.readLine());
            for (int i = 1; i <= numberInstances; ++i) {
                boolean failed = false;
                String[] arguments = br.readLine().split(" ");
                int numberActivities = Integer.parseInt(arguments[0]);
                Activity[] activities = new Activity[numberActivities];
                char[] assignments = new char[numberActivities];

                for (int j = 0; j < numberActivities; j++) {
                    String[] activity = br.readLine().split(" ");
                    int start = Integer.parseInt(activity[0]);
                    int end = Integer.parseInt(activity[1]);
                    activities[j] = new Activity(start, end, j);
                }

                Arrays.sort(activities);

                int jamieEnd = 0;
                int cameronEnd = 0;

                for (Activity activity : activities) {
                    if (activity.start >= jamieEnd) {
                        jamieEnd = activity.end;
                        assignments[activity.index] = 'J';
                    } else if (activity.start >= cameronEnd) {
                        cameronEnd = activity.end;
                        assignments[activity.index] = 'C';
                    } else {
                        failed = true;
                        break;
                    }
                }

                if (failed) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + i + ": " + new String(assignments));
                }
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(this.end, other.end);
        }

        @Override
        public String toString() {
            return "(" + index + "," + start + "," + end + ")";
        }
    }
}