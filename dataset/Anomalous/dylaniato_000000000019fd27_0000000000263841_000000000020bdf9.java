import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfActivities = Integer.parseInt(scanner.nextLine());

            List<Activity> activitiesList = new ArrayList<>();
            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                String[] activityTimes = scanner.nextLine().split(" ");
                activitiesList.add(new Activity(
                        Integer.parseInt(activityTimes[0]),
                        Integer.parseInt(activityTimes[1]))
                );
            }
            System.out.println(String.format("Case #%d: %s", caseIndex + 1, assignActivities(activitiesList)));
        }
    }

    private static String assignActivities(List<Activity> activities) {
        Parent cameron = new Parent("C");
        Parent jamie = new Parent("J");

        List<Activity> sortedActivities = activities.stream()
                .sorted(Comparator.comparing(Activity::getStartTime))
                .collect(Collectors.toList());

        StringBuilder assignmentResult = new StringBuilder();
        for (Activity activity : sortedActivities) {
            if (cameron.isAvailableFor(activity)) {
                cameron.assign(activity);
                assignmentResult.append(cameron.getName());
            } else if (jamie.isAvailableFor(activity)) {
                jamie.assign(activity);
                assignmentResult.append(jamie.getName());
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignmentResult.toString();
    }

    private static class Parent {
        private final String name;
        private Activity currentActivity;

        public Parent(String name) {
            this.name = name;
            this.currentActivity = null;
        }

        public String getName() {
            return name;
        }

        public boolean isAvailableFor(Activity newActivity) {
            return currentActivity == null || currentActivity.getEndTime() <= newActivity.getStartTime();
        }

        public void assign(Activity newActivity) {
            this.currentActivity = newActivity;
        }
    }

    private static class Activity {
        private final int startTime;
        private final int endTime;

        public Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}