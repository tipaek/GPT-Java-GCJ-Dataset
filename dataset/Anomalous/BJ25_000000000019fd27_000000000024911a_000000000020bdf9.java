import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder resultBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime, j));
            }

            Collections.sort(activities);

            try {
                List<Activity> scheduledActivities = scheduleActivities(activities);
                String result = scheduledActivities.stream()
                        .sorted(Comparator.comparingInt(Activity::getIndex))
                        .map(Activity::getPerson)
                        .collect(Collectors.joining());
                resultBuilder.append(formatResult(caseNum, result));
            } catch (Exception e) {
                resultBuilder.append(formatResult(caseNum, "IMPOSSIBLE"));
            }
        }

        scanner.close();
        System.out.print(resultBuilder.toString());
    }

    private static List<Activity> scheduleActivities(List<Activity> activities) throws Exception {
        Activity lastJActivity = null;
        Activity lastCActivity = null;

        for (Activity activity : activities) {
            if (lastJActivity == null || activity.getStartTime() >= lastJActivity.getEndTime()) {
                activity.setPerson("J");
                lastJActivity = activity;
            } else if (lastCActivity == null || activity.getStartTime() >= lastCActivity.getEndTime()) {
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

    static class Activity implements Comparable<Activity> {
        private final int startTime;
        private final int endTime;
        private final int index;
        private String person;

        public Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
            this.person = "";
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