import java.util.*;

public class Solution {

    private int testCases;
    private List<List<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int i = 0; i < solution.days.size(); i++) {
            List<Activity> activities = solution.days.get(i);
            System.out.println(String.format("Case #%d: %s", i + 1, solution.schedule(activities)));
        }
    }

    private String schedule(List<Activity> activities) {
        StringBuilder schedule = new StringBuilder();
        boolean allAssigned = true;

        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (Activity activity : activities) {
            boolean assignedToCameron = assignActivity(activity, cameronActivities, "C");
            if (assignedToCameron) {
                schedule.append("C");
            } else {
                boolean assignedToJamie = assignActivity(activity, jamieActivities, "J");
                if (assignedToJamie) {
                    schedule.append("J");
                }
                allAssigned = allAssigned && assignedToJamie;
            }
            allAssigned = allAssigned && assignedToCameron;
        }

        return allAssigned ? schedule.toString() : "IMPOSSIBLE";
    }

    private boolean assignActivity(Activity activity, List<Activity> parentActivities, String assignee) {
        if (parentActivities.isEmpty() || parentActivities.stream().allMatch(a -> activity.end <= a.start || activity.start >= a.end)) {
            activity.assignee = assignee;
            parentActivities.add(activity);
            return true;
        }
        return false;
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            testCases = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < testCases; i++) {
            int activityCount = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                Activity activity = new Activity(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
                activities.add(activity);
            }
            days.add(activities);
        }

        scanner.close();
    }

    public static class Activity {
        int start;
        int end;
        String assignee;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignee = "";
        }

        @Override
        public String toString() {
            return String.format("Assignee: %s\t Start: %d\t End: %d", assignee, start, end);
        }
    }
}