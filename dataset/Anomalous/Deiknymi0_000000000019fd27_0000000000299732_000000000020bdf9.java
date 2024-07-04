import java.io.*;
import java.util.*;

public class Solution {

    static class Activity {
        int start, end;
        char assignedTo;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = ' ';
        }

        boolean isOverlapping(Activity other) {
            return (other.start < this.end && other.start >= this.start) || 
                   (other.end > this.start && other.end <= this.end);
        }

        void assignTo(char c) {
            this.assignedTo = c;
        }
    }

    static class ActivityWrapper {
        Activity activity;

        ActivityWrapper(Activity activity) {
            this.activity = activity;
        }

        boolean isOverlapping(ActivityWrapper other) {
            return activity.isOverlapping(other.activity);
        }

        void assignTo(char c) {
            activity.assignTo(c);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<ActivityWrapper> wrappers = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());
                activities.add(activity);
                wrappers.add(new ActivityWrapper(activity));
            }

            wrappers.sort(Comparator.comparingInt(a -> a.activity.start));

            ActivityWrapper current = wrappers.get(0);
            current.assignTo('C');

            boolean impossible = false;
            ActivityWrapper previous = null;

            for (int i = 1; i < numActivities; i++) {
                ActivityWrapper next = wrappers.get(i);
                next.assignTo(current.activity.assignedTo == 'C' ? 'J' : 'C');

                if (!current.isOverlapping(next)) {
                    previous = current;
                    current = next;
                } else {
                    if (previous != null && previous.isOverlapping(next)) {
                        impossible = true;
                        break;
                    }

                    if (next.activity.end > current.activity.end) {
                        previous = current;
                        current = next;
                    } else {
                        previous = next;
                    }
                }
            }

            if (impossible) {
                out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
                out.println("Case #" + t + ": " + result.toString());
            }
        }

        out.close();
        scanner.close();
    }
}