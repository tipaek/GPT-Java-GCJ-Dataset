import java.util.Arrays;
import java.util.Scanner;

class Solution {

    static class Activity implements Comparable<Activity> {
        int start;
        int end;

        public Activity(int start, int end) {
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
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
            int numberOfActivities = scanner.nextInt();
            Activity[] activities = new Activity[numberOfActivities];

            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(start, end);
            }

            Arrays.sort(activities);

            int endTimeC = 0;
            int endTimeJ = 0;
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.start >= endTimeC) {
                    endTimeC = activity.end;
                    schedule.append("C");
                } else if (activity.start >= endTimeJ) {
                    endTimeJ = activity.end;
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + testIndex + ": " + schedule);
        }
    }
}