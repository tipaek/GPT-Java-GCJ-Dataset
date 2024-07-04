import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static class Activity implements Comparable<Activity> {
        public int start;
        public int end;
        public char assignedTo;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity [start=" + start + ", end=" + end + ", assignedTo=" + assignedTo + "]";
        }

        @Override
        public int compareTo(Activity other) {
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        char lastAssigned = ' ';

        for (int t = 1; t <= testCases; ++t) {
            int numActivities = scanner.nextInt();
            int jamesEnd = 0, cameronEnd = 0;
            ArrayList<Activity> activities = new ArrayList<>(numActivities);
            PriorityQueue<Activity> activityQueue = new PriorityQueue<>(numActivities);

            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activities.add(activity);
                activityQueue.add(activity);
            }

            boolean impossible = false;

            while (!activityQueue.isEmpty()) {
                Activity currentActivity = activityQueue.poll();
                if (currentActivity != null) {
                    if (lastAssigned == 'J') {
                        if (currentActivity.start >= cameronEnd) {
                            currentActivity.assignedTo = 'C';
                            cameronEnd = currentActivity.end;
                        } else if (currentActivity.start >= jamesEnd) {
                            currentActivity.assignedTo = 'J';
                            jamesEnd = currentActivity.end;
                        } else {
                            impossible = true;
                            break;
                        }
                    } else {
                        if (currentActivity.start >= jamesEnd) {
                            currentActivity.assignedTo = 'J';
                            jamesEnd = currentActivity.end;
                        } else if (currentActivity.start >= cameronEnd) {
                            currentActivity.assignedTo = 'C';
                            cameronEnd = currentActivity.end;
                        } else {
                            impossible = true;
                            break;
                        }
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                for (Activity activity : activities) {
                    schedule.append(activity.assignedTo);
                }
                lastAssigned = schedule.charAt(schedule.length() - 1);
                System.out.println("Case #" + t + ": " + schedule.toString());
            }
        }
    }
}