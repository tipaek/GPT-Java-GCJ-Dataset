import java.util.*;

public class Solution {

    private int T;
    private List<List<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();

        for (int x = 0; x < solution.days.size(); x++) {
            List<Activity> activities = solution.days.get(x);

            activities.sort(Comparator.comparingInt(a -> a.start));
            boolean possible = solution.schedule(activities);

            StringBuilder schedule = new StringBuilder();
            if (possible) {
                activities.sort(Comparator.comparingInt(a -> a.order));

                for (Activity activity : activities) {
                    schedule.append(activity.assignee);
                }
            } else {
                schedule.append("IMPOSSIBLE");
            }
            System.out.println(String.format("Case #%d: %s", x + 1, schedule.toString()));
        }
    }

    private boolean schedule(List<Activity> activities) {
        boolean allAssigned = true;

        List<Activity> cameronActivities = new ArrayList<>();
        List<Activity> jamieActivities = new ArrayList<>();

        for (ListIterator<Activity> i = activities.listIterator(); i.hasNext(); ) {
            Activity activity = i.next();

            boolean assignedToCameron = assignActivity(activity, cameronActivities, "C");
            if (!assignedToCameron) {
                boolean assignedToJamie = assignActivity(activity, jamieActivities, "J");
                allAssigned = allAssigned && assignedToJamie;
            } else {
                allAssigned = allAssigned && assignedToCameron;
            }

            i.set(activity);
        }

        return allAssigned;
    }

    private boolean assignActivity(Activity activity, List<Activity> parentActivities, String assignee) {
        boolean assigned = parentActivities.isEmpty() || activity.start >= parentActivities.get(parentActivities.size() - 1).end;

        if (assigned) {
            activity.assignee = assignee;
            parentActivities.add(activity);
        }
        return assigned;
    }

    private void readInput() {
        Scanner reader = new Scanner(System.in);

        if (reader.hasNextLine()) {
            T = Integer.parseInt(reader.nextLine());
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String[] cells = reader.nextLine().split(" ");
                Activity activity = new Activity(j, Integer.parseInt(cells[0]), Integer.parseInt(cells[1]));
                activities.add(activity);
            }

            days.add(activities);
        }

        reader.close();
    }

    public static class Activity {
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
            return String.format("Assignee: %s\t Order: %d \t Start: %d\t End: %d", assignee, order, start, end);
        }
    }
}