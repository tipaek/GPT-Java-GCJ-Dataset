import java.util.Arrays;
import java.util.Scanner;

class Scheduler {
    static class Activity implements Comparable<Activity> {
        final int start, end, index;

        public Activity(int index, int start, int end) {
            this.index = index;
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
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 1; t <= testCases; t++) {
                int activitiesCount = scanner.nextInt();
                Activity[] activities = new Activity[activitiesCount];
                for (int i = 0; i < activitiesCount; i++) {
                    activities[i] = new Activity(i, scanner.nextInt(), scanner.nextInt());
                }
                Arrays.sort(activities);

                boolean isPossible = true;
                char[] schedule = new char[activitiesCount];
                int cEnd = 0;
                int jEnd = 0;

                for (Activity activity : activities) {
                    if (cEnd <= activity.start) {
                        cEnd = activity.end;
                        schedule[activity.index] = 'C';
                    } else if (jEnd <= activity.start) {
                        jEnd = activity.end;
                        schedule[activity.index] = 'J';
                    } else {
                        isPossible = false;
                        break;
                    }
                }

                System.out.printf("Case #%d: %s\n", t, isPossible ? new String(schedule) : "IMPOSSIBLE");
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scheduler.main(args);
    }
}