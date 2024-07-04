import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class TimeSlot {
    public int start;
    public int stop;

    public TimeSlot(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }
}

class Activity {
    public int start;
    public int stop;
    public String assignee;
    public int order;

    public Activity(int start, int stop, int order) {
        this.start = start;
        this.stop = stop;
        this.order = order;
    }
}

class StartTimeComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.start, a2.start);
    }
}

class OrderComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.order, a2.order);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int stop = scanner.nextInt();
                activities.add(new Activity(start, stop, j));
            }

            activities.sort(new StartTimeComparator());

            TimeSlot cameron = new TimeSlot(0, 0);
            TimeSlot jamie = new TimeSlot(0, 0);

            boolean possible = true;
            for (Activity activity : activities) {
                if (activity.start >= cameron.stop) {
                    activity.assignee = "C";
                    cameron.stop = activity.stop;
                } else if (activity.start >= jamie.stop) {
                    activity.assignee = "J";
                    jamie.stop = activity.stop;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                activities.sort(new OrderComparator());
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignee);
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }
}