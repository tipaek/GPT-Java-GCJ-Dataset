import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            Collections.sort(activities);

            int cameronEndTime = 0;
            int jamieEndTime = 0;
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                if (cameronEndTime <= activity.startingTime) {
                    schedule.append('C');
                    cameronEndTime = activity.endTime;
                } else if (jamieEndTime <= activity.startingTime) {
                    schedule.append('J');
                    jamieEndTime = activity.endTime;
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + schedule.toString());
        }

        scanner.close();
    }

    static class Activity implements Comparable<Activity> {
        int startingTime;
        int endTime;

        public Activity(int startingTime, int endTime) {
            this.startingTime = startingTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.startingTime, other.startingTime);
        }
    }
}