import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder resultBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
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
        int lastJEndTime = 0;
        int lastCEndTime = 0;

        for (Activity activity : activities) {
            if (activity.getStartTime() >= lastJEndTime) {
                activity.setPerson("J");
                lastJEndTime = activity.getEndTime();
            } else if (activity.getStartTime() >= lastCEndTime) {
                activity.setPerson("C");
                lastCEndTime = activity.getEndTime();
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