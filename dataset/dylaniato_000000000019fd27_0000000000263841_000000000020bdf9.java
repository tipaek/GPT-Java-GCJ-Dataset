import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cases; i++) {
            int activitiesNumber = Integer.parseInt(scanner.nextLine());

            List<Activity> activities = new ArrayList<>();
            for (int k = 0; k < activitiesNumber; k++) {
                String[] digitStrings = scanner.nextLine().split(" ");
                activities.add(new Activity(
                        Integer.parseInt(digitStrings[0]),
                        Integer.parseInt(digitStrings[1]))
                );
            }
            System.out.println(String.format("Case #%s: %s", i + 1, schedule(activities)));
        }
    }

    private static String schedule(List<Activity> activities) {
        Parent cameron = new Parent("C");
        Parent jamie = new Parent("J");

        List<Activity> sortedActivities = activities.stream()
                .sorted(Comparator.comparing(Activity::getStart))
                .collect(Collectors.toList());

        StringBuilder schedule = new StringBuilder();
        for (Activity activity : sortedActivities) {
            if (cameron.canManage(activity)) {
                cameron.manage(activity);
                schedule.append(cameron.getName());
            } else if (jamie.canManage(activity)) {
                jamie.manage(activity);
                schedule.append(jamie.getName());
            } else return "IMPOSSIBLE";
        }

        return schedule.toString();
    }

    private static class Parent {
        private String name;
        private Activity currentActivity;

        public Parent(String name) {
            this.name = name;
            currentActivity = null;
        }

        public String getName() {
            return name;
        }

        public Activity getCurrentActivity() {
            return currentActivity;
        }

        public boolean canManage(Activity otherActivity) {
            return currentActivity == null ||
                    currentActivity.getEnd() <= otherActivity.getStart();
        }

        public void manage(Activity activity) {
            this.currentActivity = activity;
        }
    }

    private static class Activity {
        private int start;
        private int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

}
