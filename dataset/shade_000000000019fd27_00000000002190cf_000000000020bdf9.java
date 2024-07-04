import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numberOfActivities = scanner.nextInt();
            Activity[] activities = new Activity[numberOfActivities];
            for (int n = 0; n < numberOfActivities; n++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities[n] = new Activity(startTime, endTime, n);
            }
            Arrays.sort(activities);
            System.out.println("Case #" + (t + 1) + ": " + runSchedule(activities));
        }
    }

    public static String runSchedule(Activity[] activities) {
        char[] resultChar = new char[activities.length];
        ArrayList<Activity> cameron = new ArrayList<>();
        ArrayList<Activity> jamie = new ArrayList<>();

        cameron.add(activities[0]);
        resultChar[activities[0].index] = 'C';

        for (int i = 1; i < activities.length; i++) {
            boolean cameronOverlap = false;
            boolean jamieOverlap = false;
            for (Activity activity: cameron) {
                cameronOverlap = activity.isOverlap(activities[i]);
                if (cameronOverlap) {
                    break;
                }
            }
            if (cameronOverlap) {
                for (Activity activity: jamie) {
                    jamieOverlap = activity.isOverlap(activities[i]);
                    if (jamieOverlap) {
                        // IMPOSSIBLE SCHEDULE
                        return "IMPOSSIBLE";
                    }
                }
                jamie.add(activities[i]);
                resultChar[activities[i].index] = 'J';
            } else {
                cameron.add(activities[i]);
                resultChar[activities[i].index] = 'C';
            }
        }
        return String.valueOf(resultChar);
    }


    public static class Activity implements Comparable<Activity> {
        public int startTime;
        public int endTime;
        public int index;
        public char owner;

        public Activity(int start, int end, int index) {
            this.startTime = start;
            this.endTime = end;
            this.index = index;
        }

        // method is not right yet
        public boolean isOverlap(Activity activity) {
            int start1 = this.startTime;
            int start2 = activity.startTime;
            int end1 = this.endTime;
            int end2 = activity.endTime;

            if ((start2 < end1) || (end2 < end1)) {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Activity o) {
            return this.startTime - o.startTime;
        }
    }

}
