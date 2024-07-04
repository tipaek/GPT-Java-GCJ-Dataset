import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Activity implements Comparable<Activity> {
        int start;
        int end;
        int index;
        char assignedPerson;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            Activity[] activities = new Activity[numActivities];

            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(i, start, end);
            }

            Arrays.sort(activities);

            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean impossible = false;
            StringBuilder result = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    cameronEnd = activity.end;
                    activity.assignedPerson = 'C';
                } else if (activity.start >= jamieEnd) {
                    jamieEnd = activity.end;
                    activity.assignedPerson = 'J';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
                for (Activity activity : activities) {
                    result.append(activity.assignedPerson);
                }
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
        scanner.close();
    }
}