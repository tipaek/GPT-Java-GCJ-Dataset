import java.util.*;

class Activity implements Comparable<Activity> {
    int start, end, position;

    @Override
    public int compareTo(Activity a) {
        return Integer.compare(this.start, a.start);
    }

    @Override
    public String toString() {
        return start + " " + end + " " + position;
    }
}

class Parent {
    boolean isFree = true;
    int busyTill = 0;
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int noOfActivities = sc.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < noOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = sc.nextInt();
                activity.end = sc.nextInt();
                activity.position = j;
                activities.add(activity);
            }

            Collections.sort(activities);

            Parent jamie = new Parent();
            Parent cameron = new Parent();
            char[] result = new char[noOfActivities];
            Arrays.fill(result, 'X');

            boolean isPossible = true;

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
                    result[activity.position] = 'J';
                } else if (cameron.isFree) {
                    cameron.isFree = false;
                    cameron.busyTill = activity.end;
                    result[activity.position] = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            String output = isPossible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}