import java.util.*;

public class Solution {

    private int T;
    private List<List<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int x = 0; x < solution.days.size(); x++) {
            List<Activity> activities = solution.days.get(x);
            activities.sort(Comparator.comparingInt(activity -> activity.start));
            boolean possible = solution.schedule(activities);

            String schedule;
            if (possible) {
                activities.sort(Comparator.comparingInt(activity -> activity.order));
                StringBuilder scheduleBuilder = new StringBuilder();
                for (Activity activity : activities) {
                    scheduleBuilder.append(activity.assignee);
                }
                schedule = scheduleBuilder.toString();
            } else {
                schedule = "IMPOSSIBLE";
            }
            System.out.println(String.format("Case #%d: %s", x + 1, schedule));
        }
    }

    private boolean schedule(List<Activity> activities) {
        List<Activity> cameron = new ArrayList<>();
        List<Activity> jamie = new ArrayList<>();
        boolean allAssigned = true;

        for (ListIterator<Activity> i = activities.listIterator(); i.hasNext(); ) {
            Activity activity = i.next();
            boolean assignedToCameron = assignActivity(activity, cameron, "C");
            if (!assignedToCameron) {
                boolean assignedToJamie = assignActivity(activity, jamie, "J");
                allAssigned &= assignedToJamie;
            } else {
                allAssigned &= assignedToCameron;
            }
            i.set(activity);
        }
        return allAssigned;
    }

    private boolean assignActivity(Activity activity, List<Activity> parentActivities, String assignee) {
        if (parentActivities.isEmpty() || canAssign(activity, parentActivities)) {
            activity.assignee = assignee;
            parentActivities.add(activity);
            parentActivities.sort(Comparator.comparingInt(a -> a.start));
            return true;
        }
        return false;
    }

    private boolean canAssign(Activity activity, List<Activity> parentActivities) {
        for (Activity parentActivity : parentActivities) {
            if (activity.start < parentActivity.end && activity.end > parentActivity.start) {
                return false;
            }
        }
        return true;
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
                String[] data = scanner.nextLine().split(" ");
                Activity activity = new Activity(j, Integer.parseInt(data[0]), Integer.parseInt(data[1]));
                activities.add(activity);
            }
            days.add(activities);
        }
        scanner.close();
    }

    public class Activity {
        int order;
        int start;
        int end;
        String assignee;

        public Activity(int order, int start, int end) {
            this.order = order;
            this.start = start;
            this.end = end;
            this.assignee = "";
        }

        @Override
        public String toString() {
            return String.format("Assignee: %s\t Order: %d\t Start: %d\t End: %d", assignee, order, start, end);
        }
    }
}