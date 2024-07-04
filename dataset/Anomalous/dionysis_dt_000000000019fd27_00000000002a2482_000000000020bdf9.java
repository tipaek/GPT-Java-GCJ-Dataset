import java.util.*;

public class Solution {

    private int T;
    private List<List<Activity>> days = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.readInput();
        solution.processDays();
    }

    private void processDays() {
        for (int x = 0; x < days.size(); x++) {
            List<Activity> activities = days.get(x);

            activities.sort(Comparator.comparingInt(activity -> activity.start));
            boolean possible = schedule(activities);

            String schedule = possible ? getSchedule(activities) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s%n", x + 1, schedule);

            activities.forEach(System.out::println);
            System.out.println("================================================================");
        }
    }

    private String getSchedule(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(activity -> activity.order));
        StringBuilder schedule = new StringBuilder();
        for (Activity activity : activities) {
            schedule.append(activity.assignee);
        }
        return schedule.toString();
    }

    private boolean schedule(List<Activity> activities) {
        List<Activity> cameron = new ArrayList<>();
        List<Activity> jamie = new ArrayList<>();

        for (Activity activity : activities) {
            if (!assignActivity(activity, cameron, "C")) {
                if (!assignActivity(activity, jamie, "J")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean assignActivity(Activity activity, List<Activity> parentActivities, String assignee) {
        for (Activity parentActivity : parentActivities) {
            if (!(activity.start >= parentActivity.end || activity.end <= parentActivity.start)) {
                return false;
            }
        }
        activity.assignee = assignee;
        parentActivities.add(activity);
        parentActivities.sort(Comparator.comparingInt(a -> a.start));
        return true;
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

    private static class Activity {
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
            return String.format("Assignee: %s\t\t Order: %d \t\t Start: %d\t\t End: %d", assignee, order, start, end);
        }
    }
}