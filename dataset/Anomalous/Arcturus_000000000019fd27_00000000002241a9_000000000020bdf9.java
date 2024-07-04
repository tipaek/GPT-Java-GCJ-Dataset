import java.util.*;
import java.io.*;

public class Solution {

    public static class Activity {
        public int index;
        public int begin;
        public int end;
        public char person;

        public Activity(int index, int begin, int end) {
            this.index = index;
            this.begin = begin;
            this.end = end;
        }
    }

    public static class ActivityTimeComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.begin, a2.begin);
        }
    }

    public static class ActivityIndexComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Integer.compare(a1.index, a2.index);
        }
    }

    public static void parentingPartneringReturns(int caseNum, Scanner in) {
        System.out.print("Case #" + caseNum + ": ");

        int activities = in.nextInt();
        int cameronAvailable = 0;
        int jamieAvailable = 0;
        boolean possible = true;

        List<Activity> activityList = new ArrayList<>();

        for (int i = 0; i < activities; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            activityList.add(new Activity(i, begin, end));
        }

        activityList.sort(new ActivityTimeComparator());

        for (Activity activity : activityList) {
            if (cameronAvailable <= activity.begin) {
                activity.person = 'C';
                cameronAvailable = activity.end;
            } else if (jamieAvailable <= activity.begin) {
                activity.person = 'J';
                jamieAvailable = activity.end;
            } else {
                possible = false;
                break;
            }
        }

        activityList.sort(new ActivityIndexComparator());

        if (possible) {
            for (Activity activity : activityList) {
                System.out.print(activity.person);
            }
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            parentingPartneringReturns(i, in);
        }
        in.close();
    }
}