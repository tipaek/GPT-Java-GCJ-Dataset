import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTestCase = sc.nextInt();
            for (int i = 0; i < numberOfTestCase; i++) {
                int numberOfActivities = sc.nextInt();
                List<Activity> activities = new ArrayList<>();
                for (int j = 0; j < numberOfActivities; j++) {
                    int startTime = sc.nextInt();
                    int endTime = sc.nextInt();
                    activities.add(new Activity(startTime, endTime));
                }
                activities.sort(Comparator.comparingInt(Activity::getStart));
                int cameronEnd = -1;
                int jamieEnd = -1;
                StringBuilder schedule = new StringBuilder();
                int activityIndex = 0;
                for (int minute = 0; minute <= 24 * 60; minute++) {
                    if (activityIndex >= activities.size()) {
                        break;
                    }
                    Activity activity = activities.get(activityIndex);
                    if (activity.getStart() > minute) {
                        continue;
                    }
                    if (cameronEnd != -1 && minute >= cameronEnd) {
                        cameronEnd = -1;
                    }
                    if (jamieEnd != -1 && minute >= jamieEnd) {
                        jamieEnd = -1;
                    }
                    if (cameronEnd == -1) {
                        schedule.append("C");
                        cameronEnd = activity.getEnd();
                        activityIndex++;
                        minute--;
                    } else if (jamieEnd == -1) {
                        schedule.append("J");
                        jamieEnd = activity.getEnd();
                        activityIndex++;
                        minute--;
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                System.out.printf("Case #%d: %s%n", (i + 1), schedule.toString());
            }
        }
    }

    private static class Activity {
        private final int start;
        private final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}