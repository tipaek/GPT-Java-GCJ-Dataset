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
            for (int j = 0; j < noOfActivities; j++) {
                Activity activity = new Activity();
                activity.start = sc.nextInt();
                activity.end = sc.nextInt();
                activity.position = j;
                treeSet.add(activity);
            }

            StringBuilder str = new StringBuilder();
            boolean isPossible = true;

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
                    str.append("J");
                } else if (cameron.isFree) {
                    cameron.isFree = false;
                    cameron.busyTill = activity.end;
                    str.append("C");
                } else {
                    str = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                String result = str.toString();
                char[] output = new char[noOfActivities];
                int index = 0;
                for (Activity activity : treeSet) {
                    output[activity.position] = result.charAt(index++);
                }
                str = new StringBuilder(new String(output));
            }

            System.out.println("Case #" + (i + 1) + ": " + str);
            treeSet.clear();
            jamie.busyTill = 0;
            cameron.busyTill = 0;
        }

        sc.close();
    }
}