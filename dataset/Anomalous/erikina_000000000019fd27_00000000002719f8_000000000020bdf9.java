package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Parent {
    public int start;
    public int stop;

    public Parent(int start, int stop) {
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

class ActivityStartComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.start, a2.start);
    }
}

class ActivityOrderComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.order, a2.order);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int activitiesCount = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                activities.add(new Activity(start, stop, j));
            }

            activities.sort(new ActivityStartComparator());

            Parent cameron = new Parent(0, 0);
            Parent jamie = new Parent(0, 0);

            boolean possible = true;
            for (Activity activity : activities) {
                if (activity.start >= cameron.stop) {
                    activity.assignee = "C";
                    cameron.start = activity.start;
                    cameron.stop = activity.stop;
                } else if (activity.start >= jamie.stop) {
                    activity.assignee = "J";
                    jamie.start = activity.start;
                    jamie.stop = activity.stop;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                activities.sort(new ActivityOrderComparator());
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignee);
                }
                System.out.println("Case #" + i + ": " + result);
            }
        }
        in.close();
    }
}