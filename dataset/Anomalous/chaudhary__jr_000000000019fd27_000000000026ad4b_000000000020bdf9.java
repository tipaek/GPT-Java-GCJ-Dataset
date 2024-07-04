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

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int numActivities = scanner.nextInt();
            int jamesEndTime = 0, cameronEndTime = 0;
            ArrayList<Activity> activities = new ArrayList<>(numActivities);
            PriorityQueue<Activity> activityQueue = new PriorityQueue<>(numActivities);

            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activities.add(activity);
                activityQueue.add(activity);
            }

            boolean isImpossible = false;

            while (!activityQueue.isEmpty()) {
                Activity currentActivity = activityQueue.poll();
                
                if (currentActivity != null) {
                    if (currentActivity.start >= cameronEndTime) {
                        currentActivity.assignedTo = 'C';
                        cameronEndTime = currentActivity.end;
                    } else if (currentActivity.start >= jamesEndTime) {
                        currentActivity.assignedTo = 'J';
                        jamesEndTime = currentActivity.end;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testCase + ": ");
                for (Activity activity : activities) {
                    System.out.print(activity.assignedTo);
                }
                System.out.println();
            }
        }
    }
}