import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }

            activities.sort(Comparator.naturalOrder());
            int cameronEnd = 0;
            int jamieEnd = 0;
            StringBuilder result = new StringBuilder();

            for (Activity activity : activities) {
                if (cameronEnd <= activity.startingTime) {
                    result.append('C');
                    cameronEnd = activity.endTime;
                } else if (jamieEnd <= activity.startingTime) {
                    result.append('J');
                    jamieEnd = activity.endTime;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
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