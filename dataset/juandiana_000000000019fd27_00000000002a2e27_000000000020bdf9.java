import java.util.*;

public class Solution {
    private static class Activity {
        public int index;
        public int startTime;
        public int endTime;
        public char assignedTo;

        public Activity(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(i, scanner.nextInt(), scanner.nextInt()));
            }
            String res = solve(activities);
            System.out.println(String.format("Case #%d: %s", caseNum, res));
        }

        scanner.close();
    }

    private static String getSchedule(List<Activity> activities) {
        activities.sort(Comparator.comparing(o -> o.index));

        StringBuilder builder = new StringBuilder();
        for (Activity activity : activities) {
            builder.append(activity.assignedTo);
        }

        return builder.toString();
    }

    private static String solve(List<Activity> activities) {
        activities.sort(Comparator.comparing(o -> o.startTime));

        Activity currentActivityC = activities.get(0);
        currentActivityC.assignedTo = 'C';
        Activity currentActivityJ = activities.get(1);
        currentActivityJ.assignedTo = 'J';

        for (int i = 2; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (activity.startTime >= currentActivityC.endTime) {
                currentActivityC = activity;
                activity.assignedTo = 'C';
            } else if (activity.startTime >= currentActivityJ.endTime) {
                currentActivityJ = activity;
                activity.assignedTo = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return getSchedule(activities);
    }
}
