import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(scanner.nextLine(), i));
            }

            System.out.print("Case #" + (t + 1) + ": ");
            List<Activity> sortedActivities = new ArrayList<>(activities);
            Collections.sort(sortedActivities);

            int[] endTimes = {0, 0};
            StringBuilder result = new StringBuilder();

            for (Activity activity : sortedActivities) {
                assignParent(activity, endTimes);
            }

            for (Activity activity : activities) {
                if (activity.getParent() != null) {
                    result.append(activity.getParent());
                } else {
                    result.setLength(0); // Clear result
                    result.append("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private static void assignParent(Activity activity, int[] endTimes) {
        if (endTimes[0] <= activity.getStart()) {
            endTimes[0] = activity.getEnd();
            activity.setParent('C');
        } else if (endTimes[1] <= activity.getStart()) {
            endTimes[1] = activity.getEnd();
            activity.setParent('J');
        } else {
            activity.setParent(null);
        }
    }

    static class Activity implements Comparable<Activity> {
        private final int index;
        private final int start;
        private final int end;
        private Character parent;

        Activity(String properties, int index) {
            String[] parts = properties.split(" ");
            this.start = Integer.parseInt(parts[0]);
            this.end = Integer.parseInt(parts[1]);
            this.index = index;
        }

        int getStart() {
            return start;
        }

        int getEnd() {
            return end;
        }

        void setParent(Character parent) {
            this.parent = parent;
        }

        Character getParent() {
            return parent;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}