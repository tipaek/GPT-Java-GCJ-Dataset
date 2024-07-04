import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int lineCount = in.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < lineCount; j++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                activities.add(new Activity(startTime, endTime, j));
            }

            Collections.sort(activities);

            try {
                List<Activity> scheduledActivities = assignActivities(activities);
                String result = scheduledActivities.stream()
                        .sorted(Comparator.comparingInt(Activity::getIndex))
                        .map(Activity::getPerson)
                        .collect(Collectors.joining());
                stringBuilder.append(formatResult(caseNum, result));
            } catch (Exception e) {
                stringBuilder.append(formatResult(caseNum, "IMPOSSIBLE"));
            }
        }

        in.close();
        System.out.print(stringBuilder);
    }

    private static List<Activity> assignActivities(List<Activity> activities) throws Exception {
        Activity lastJActivity = null;
        Activity lastCActivity = null;

        for (Activity activity : activities) {
            if (lastJActivity == null || activity.startTime >= lastJActivity.endTime) {
                activity.setPerson("J");
                lastJActivity = activity;
            } else if (lastCActivity == null || activity.startTime >= lastCActivity.endTime) {
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
        int startTime;
        int endTime;
        int index;
        String person;

        public Activity(int startTime, int endTime, int index) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.index = index;
            this.person = "";
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