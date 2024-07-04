import java.io.*;
import java.util.*;

public class Solution {
    static short[] minutes = new short[24 * 60];

    public static class Activity {
        public int start, end;
        public char assignedTo;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = ' ';
            for (int i = start; i < end; i++) {
                minutes[i]++;
            }
        }

        public boolean isOverlapping(Activity other) {
            return (other.start >= this.start && other.start < this.end) ||
                   (other.end > this.start && other.end <= this.end);
        }

        public void assignTo(char c) {
            this.assignedTo = c;
        }
    }

    public static class ActivityWrapper {
        public Activity original;

        public ActivityWrapper(Activity original) {
            this.original = original;
        }

        public boolean isOverlapping(ActivityWrapper other) {
            return original.isOverlapping(other.original);
        }

        public void assignTo(char c) {
            original.assignTo(c);
        }
    }

    public static void main(String[] args) throws NumberFormatException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {
            Arrays.fill(minutes, (short) 0);
            List<Activity> activities = new ArrayList<>();
            List<ActivityWrapper> wrappers = new ArrayList<>();

            int numActivities = in.nextInt();
            for (int i = 0; i < numActivities; i++) {
                Activity activity = new Activity(in.nextInt(), in.nextInt());
                activities.add(activity);
                wrappers.add(new ActivityWrapper(activity));
            }

            wrappers.sort(Comparator.comparingInt(o -> o.original.start));

            boolean impossible = Arrays.stream(minutes).anyMatch(minute -> minute >= 3);

            if (impossible) {
                out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                ActivityWrapper current = wrappers.get(0);
                current.assignTo('C');

                for (int i = 1; i < numActivities; i++) {
                    ActivityWrapper next = wrappers.get(i);
                    next.assignTo(current.original.assignedTo == 'C' ? 'J' : 'C');
                    if (!current.isOverlapping(next) || next.original.end > current.original.end) {
                        current = next;
                    }
                }

                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
                out.println("Case #" + t + ": " + result.toString());
            }
        }

        out.close();
    }
}