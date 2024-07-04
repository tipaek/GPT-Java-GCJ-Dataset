import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            for (int j = 0; j < numActivities; j++) {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            String result = new ScheduleChecker(numActivities, activities).determineSchedule();
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static class ScheduleChecker {
        private final int numActivities;
        private final int[][] activities;

        public ScheduleChecker(int numActivities, int[][] activities) {
            this.numActivities = numActivities;
            this.activities = activities;
        }

        public String determineSchedule() {
            int endTimeC = 0;
            int endTimeJ = 0;
            StringBuilder schedule = new StringBuilder();
            List<Activity> activityList = new ArrayList<>();
            for (int i = 0; i < numActivities; i++) {
                activityList.add(new Activity(activities[i][0], activities[i][1], i));
            }
            activityList.sort(Comparator.comparingInt(Activity::getStartTime));

            for (Activity activity : activityList) {
                if (endTimeC <= activity.getStartTime()) {
                    activity.setResponsiblePerson("C");
                    endTimeC = activity.getEndTime();
                } else if (endTimeJ <= activity.getStartTime()) {
                    activity.setResponsiblePerson("J");
                    endTimeJ = activity.getEndTime();
                } else {
                    return "IMPOSSIBLE";
                }
            }

            activityList.sort(Comparator.comparingInt(Activity::getId));
            for (Activity activity : activityList) {
                schedule.append(activity.getResponsiblePerson());
            }

            return schedule.toString();
        }
    }

    static class Activity {
        private final int startTime;
        private final int endTime;
        private final int id;
        private String responsiblePerson;

        public Activity(int startTime, int endTime, int id) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.id = id;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getId() {
            return id;
        }

        public String getResponsiblePerson() {
            return responsiblePerson;
        }

        public void setResponsiblePerson(String responsiblePerson) {
            this.responsiblePerson = responsiblePerson;
        }
    }
}