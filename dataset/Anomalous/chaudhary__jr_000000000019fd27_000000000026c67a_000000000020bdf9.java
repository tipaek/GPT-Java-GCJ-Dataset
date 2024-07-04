import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static class Activity implements Comparable<Activity> {
        public int start;
        public int end;
        public char assignedPerson;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity [start=" + start + ", end=" + end + ", assignedPerson=" + assignedPerson + "]";
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

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            int jamesAvailableAt = 0, cameronAvailableAt = 0;
            ArrayList<Activity> activitiesList = new ArrayList<>(numActivities);
            PriorityQueue<Activity> activitiesQueue = new PriorityQueue<>(numActivities);

            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activitiesList.add(activity);
                activitiesQueue.add(activity);
            }

            boolean conflictDetected = false;

            while (!activitiesQueue.isEmpty()) {
                Activity currentActivity = activitiesQueue.poll();
                if (currentActivity != null) {
                    if (currentActivity.start >= cameronAvailableAt) {
                        currentActivity.assignedPerson = 'C';
                        cameronAvailableAt = currentActivity.end;
                    } else if (currentActivity.start >= jamesAvailableAt) {
                        currentActivity.assignedPerson = 'J';
                        jamesAvailableAt = currentActivity.end;
                    } else {
                        conflictDetected = true;
                        break;
                    }
                }
            }

            if (conflictDetected) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + testCase + ": ");
                for (Activity activity : activitiesList) {
                    System.out.print(activity.assignedPerson);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}