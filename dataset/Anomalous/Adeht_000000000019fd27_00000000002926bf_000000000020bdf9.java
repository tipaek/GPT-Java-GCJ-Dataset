import java.util.*;

class Activity implements Comparable<Activity> {
    int start, end, position;

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}

class Parent {
    boolean isFree = true;
    int busyTill = 0;
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Activity> activities = new TreeSet<>();
        Parent jamie = new Parent();
        Parent cameron = new Parent();
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int noOfActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder("X".repeat(noOfActivities));

            for (int j = 0; j < noOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = scanner.nextInt();
                activity.end = scanner.nextInt();
                activity.position = j;
                activities.add(activity);
            }

            boolean possible = true;
            for (Activity activity : activities) {
                if (jamie.busyTill <= activity.start) {
                    jamie.isFree = true;
                }
                if (cameron.busyTill <= activity.start) {
                    cameron.isFree = true;
                }

                if (jamie.isFree) {
                    jamie.isFree = false;
                    jamie.busyTill = activity.end;
                    result.setCharAt(activity.position, 'C');
                } else if (cameron.isFree) {
                    cameron.isFree = false;
                    cameron.busyTill = activity.end;
                    result.setCharAt(activity.position, 'J');
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }

            activities.clear();
            jamie.busyTill = 0;
            cameron.busyTill = 0;
        }

        scanner.close();
    }
}