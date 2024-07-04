import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCases; i++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < numActivities; j++) {
                String[] input = scanner.nextLine().split(" ");
                activities.add(new Activity(Integer.parseInt(input[0]), Integer.parseInt(input[1]), j));
            }

            String result = scheduleActivities(activities);
            System.out.println(String.format("Case #%d: %s", i + 1, result));
        }
    }

    private static String scheduleActivities(List<Activity> activities) {
        Parent cameron = new Parent("C");
        Parent jamie = new Parent("J");

        List<Activity> sortedActivities = activities.stream()
                .sorted(Comparator.comparingInt(Activity::getStart))
                .collect(Collectors.toList());

        Map<Integer, String> assignments = new HashMap<>();
        for (Activity activity : sortedActivities) {
            if (cameron.canHandle(activity)) {
                cameron.assign(activity);
                assignments.put(activity.getSeq(), cameron.getName());
            } else if (jamie.canHandle(activity)) {
                jamie.assign(activity);
                assignments.put(activity.getSeq(), jamie.getName());
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignments.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());
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

        public boolean canHandle(Activity activity) {
            return currentActivity == null || currentActivity.getEnd() <= activity.getStart();
        }

        public void assign(Activity activity) {
            this.currentActivity = activity;
        }
    }

    private static class Activity {
        private final int start;
        private final int end;
        private final int seq;

        public Activity(int start, int end, int seq) {
            this.start = start;
            this.end = end;
            this.seq = seq;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getSeq() {
            return seq;
        }
    }
}