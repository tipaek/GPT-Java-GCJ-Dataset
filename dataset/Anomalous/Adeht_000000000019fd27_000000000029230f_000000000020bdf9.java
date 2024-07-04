import java.util.*;

class Activity implements Comparable<Activity> {
    int start, end, position;

    @Override
    public int compareTo(Activity a) {
        return Integer.compare(this.start, a.start);
    }
}

class Parent {
    boolean isFree = true;
    int busyTill = 0;
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Activity> treeSet = new TreeSet<>();
        Parent jamie = new Parent();
        Parent cameron = new Parent();
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int noOfActivities = sc.nextInt();
            StringBuilder str = new StringBuilder("X".repeat(noOfActivities));

            for (int j = 0; j < noOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = sc.nextInt();
                activity.end = sc.nextInt();
                activity.position = j;
                treeSet.add(activity);
            }

            boolean impossible = false;
            for (Activity activity : treeSet) {
                if (jamie.busyTill <= activity.start) {
                    jamie.isFree = true;
                }
                if (cameron.busyTill <= activity.start) {
                    cameron.isFree = true;
                }

                if (jamie.isFree) {
                    jamie.isFree = false;
                    jamie.busyTill = activity.end;
                    str.setCharAt(activity.position, 'J');
                } else if (cameron.isFree) {
                    cameron.isFree = false;
                    cameron.busyTill = activity.end;
                    str.setCharAt(activity.position, 'C');
                } else {
                    str = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            cameron.busyTill = 0;
            jamie.busyTill = 0;
            System.out.println("Case #" + (i + 1) + ": " + str);
            treeSet.clear();
        }

        sc.close();
    }
}