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
        TreeSet<Activity> treeSet = new TreeSet<>();
        Parent jamie = new Parent();
        Parent cameron = new Parent();
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int noOfActivities = sc.nextInt();
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < noOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = sc.nextInt();
                activity.end = sc.nextInt();
                activity.position = j;
                treeSet.add(activity);
            }

            boolean impossible = false;
            Iterator<Activity> itr = treeSet.iterator();

            while (itr.hasNext()) {
                Activity activity = itr.next();

                if (jamie.busyTill <= activity.start) {
                    jamie.isFree = true;
                }

                if (cameron.busyTill <= activity.start) {
                    cameron.isFree = true;
                }

                if (jamie.isFree) {
                    jamie.isFree = false;
                    jamie.busyTill = activity.end;
                    str.append("J");
                } else if (cameron.isFree) {
                    cameron.isFree = false;
                    cameron.busyTill = activity.end;
                    str.append("C");
                } else {
                    str = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                char[] result = new char[noOfActivities];
                itr = treeSet.iterator();
                int index = 0;
                while (itr.hasNext()) {
                    Activity activity = itr.next();
                    result[activity.position] = str.charAt(index++);
                }
                str = new StringBuilder(new String(result));
            }

            System.out.println("Case #" + (i + 1) + ": " + str);
            treeSet.clear();
            jamie.busyTill = 0;
            cameron.busyTill = 0;
        }
    }
}