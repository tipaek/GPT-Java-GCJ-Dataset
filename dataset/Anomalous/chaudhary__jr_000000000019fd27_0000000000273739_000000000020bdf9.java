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
            return this.start - other.start;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        char lastAssigned = ' ';

        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            int jamesEnd = 0, cameronEnd = 0;
            ArrayList<Activity> activities = new ArrayList<>(n);
            PriorityQueue<Activity> activityQueue = new PriorityQueue<>(n);

            for (int i = 0; i < n; i++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activities.add(activity);
                activityQueue.add(activity);
            }

            boolean impossible = false;

            while (!activityQueue.isEmpty()) {
                Activity current = activityQueue.poll();

                if (current != null) {
                    if (lastAssigned == 'J') {
                        if (current.start >= cameronEnd) {
                            current.assignedTo = 'C';
                            cameronEnd = current.end;
                        } else if (current.start >= jamesEnd) {
                            current.assignedTo = 'J';
                            jamesEnd = current.end;
                        } else {
                            impossible = true;
                            break;
                        }
                    } else {
                        if (current.start >= jamesEnd) {
                            current.assignedTo = 'J';
                            jamesEnd = current.end;
                        } else if (current.start >= cameronEnd) {
                            current.assignedTo = 'C';
                            cameronEnd = current.end;
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
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
                lastAssigned = result.charAt(result.length() - 1);
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }

        scanner.close();
    }
}