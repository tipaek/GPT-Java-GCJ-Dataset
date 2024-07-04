import java.util.*;

public class Solution {

    private int T;
    private List<List<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int x = 0; x < solution.days.size(); x++) {
            List<Activity> activities = solution.days.get(x);
            System.out.println(String.format("Case #%d: %s", x + 1, solution.schedule(activities)));
        }
    }

    private String schedule(List<Activity> activities) {
        StringBuilder schedule = new StringBuilder();
        boolean allAssigned = true;

        List<Activity> Cameron = new ArrayList<>();
        List<Activity> Jamie = new ArrayList<>();

        for (Activity activity : activities) {
            boolean assignedToCameron = assignActivity(activity, Cameron, "C");
            if (assignedToCameron) {
                schedule.append("C");
            } else {
                boolean assignedToJamie = assignActivity(activity, Jamie, "J");
                if (assignedToJamie) {
                    schedule.append("J");
                }
                allAssigned &= assignedToCameron || assignedToJamie;
            }
        }

        return allAssigned ? schedule.toString() : "IMPOSSIBLE";
    }

    public boolean assignActivity(Activity activity, List<Activity> parentActivities, String assignee) {
        if (parentActivities.isEmpty() || canBeAssigned(activity, parentActivities)) {
            activity.assignee = assignee;
            parentActivities.add(activity);
            parentActivities.sort(Comparator.comparingInt(a -> a.start));
            return true;
        }
        return false;
    }

    private boolean canBeAssigned(Activity activity, List<Activity> parentActivities) {
        for (int i = 0; i < parentActivities.size(); i++) {
            Activity parentActivity = parentActivities.get(i);
            boolean noOverlapWithCurrent = activity.start >= parentActivity.end || activity.end <= parentActivity.start;
            boolean noOverlapWithNext = true;
            if (i != parentActivities.size() - 1) {
                Activity nextParentActivity = parentActivities.get(i + 1);
                noOverlapWithNext = activity.start >= nextParentActivity.end || activity.end <= nextParentActivity.start;
            }
            if (noOverlapWithCurrent && noOverlapWithNext) {
                return true;
            }
        }
        return false;
    }

    private void readInput() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            T = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String[] cells = scanner.nextLine().split(" ");
                Activity activity = new Activity(Integer.parseInt(cells[0]), Integer.parseInt(cells[1]));
                activities.add(activity);
            }
            days.add(activities);
        }
        scanner.close();
    }

    public class Activity {
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
            return String.format("Assignee: %s\t\t Start: %d\t\t End: %d", assignee, start, end);
        }
    }
}