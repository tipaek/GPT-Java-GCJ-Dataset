import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numberOfActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }

            String result = assignActivities(activities);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(Activity::getStart));

        String[] assignments = new String[activities.size()];
        Activity cameron = null;
        Activity jamie = null;

        for (Activity activity : activities) {
            if (cameron == null || activity.getStart() >= cameron.getEnd()) {
                cameron = activity;
                assignments[activity.getIndex()] = "C";
            } else if (jamie == null || activity.getStart() >= jamie.getEnd()) {
                jamie = activity;
                assignments[activity.getIndex()] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (String assignment : assignments) {
            result.append(assignment);
        }

        return result.toString();
    }

    static class Activity {
        private final int start;
        private final int end;
        private final int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getIndex() {
            return index;
        }
    }
}