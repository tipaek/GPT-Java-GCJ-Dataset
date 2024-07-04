

import java.util.*;

public class Solution {

    public static void main(String args[]) {

        Solution s = new Solution();
        List<String> results = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int numberOfTests = in.nextInt();


        for (int i = 0; i < numberOfTests; i++) {
            List<Activity> activies = new ArrayList<>();
            int numberOfActivies = in.nextInt();
            for (int a = 0; a < numberOfActivies; a++) {
                activies.add(s.new Activity(in.nextInt(), in.nextInt()));
            }
            Comparator<Activity> comparatorByStartTime = Comparator.comparing(a -> a.startTime);
            activies.sort(comparatorByStartTime);

            Activity p = null;
            for (Activity a : activies) {
                if (p != null) {
                    p.nextActivity = a;
                }
                p = a;
            }
            List<Activity> c = new ArrayList<>();
            List<Activity> j = new ArrayList<>();

            if (scheduleActivities(activies.get(0), c, j)) {
                for (Activity a : c) {
                    a.scheduledTo="C";
                }
                for (Activity a : j) {
                    a.scheduledTo="J";
                }
                String scheduling = "";
                for (Activity a : activies) {
                    scheduling += a.scheduledTo;
                }
                results.add(formatResults(i+1,scheduling));
            } else {
                results.add(formatResults(i + 1, "IMPOSSIBLE"));
            }

        }

        for (String r : results) {
            System.out.println(r);
        }

    }

    private static String formatResults(int i, String impossible) {
        return "Case #" + i + ": " + impossible;
    }

    public class Activity {
        int startTime;
        int endTime;
        Activity nextActivity;
        String scheduledTo;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            nextActivity = null;
            scheduledTo = "";
        }

    }

    public static boolean scheduleActivities(Activity a, List<Activity> c, List<Activity> j) {
        boolean assignedToC = false, assignedToJ = false;
        if (a == null) {
            return true;
        }
        if (c.isEmpty() || c.get(c.size() - 1).endTime <= a.startTime) {
            c.add(a);
            assignedToC = scheduleActivities(a.nextActivity, c, j);
            if (!assignedToC) c.remove(a);
        }
        if (j.isEmpty()|| j.get(j.size() - 1).endTime <= a.startTime) {
            j.add(a);
            assignedToJ = scheduleActivities(a.nextActivity, c, j);
            if (!assignedToJ) j.remove(a);
        }
        return assignedToC || assignedToJ;
    }

}
