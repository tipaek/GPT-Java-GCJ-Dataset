import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime, j));
            }

            Collections.sort(activities);

            try {
                activities = assignActivities(activities);
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.getPerson());
                }
                output.append(formatResult(caseNum, result.toString()));
            } catch (Exception e) {
                output.append(formatResult(caseNum, "IMPOSSIBLE"));
            }
        }

        scanner.close();
        printOutput(output.toString());
    }

    private static List<Activity> assignActivities(List<Activity> activities) throws Exception {
        Activity lastJActivity = null;
        Activity lastCActivity = null;

        for (Activity activity : activities) {
            if (lastJActivity == null || lastJActivity.getEndTime() <= activity.getStartTime()) {
                activity.setPerson("J");
                lastJActivity = activity;
            } else if (lastCActivity == null || lastCActivity.getEndTime() <= activity.getStartTime()) {
                activity.setPerson("C");
                lastCActivity = activity;
            } else {
                throw new Exception("Impossible");
            }
        }

        return activities;
    }

    private static String formatResult(int caseNum, String result) {
        return "Case #" + caseNum + ": " + result + "\n";
    }

    private static void printOutput(String output) {
        System.out.print(output);
    }

    static class Activity implements Comparable<Activity> {
        private final int startTime;
        private final int endTime;
        private final int index;
        private String person;

        public Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getIndex() {
            return index;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.startTime, other.startTime);
        }
    }
}