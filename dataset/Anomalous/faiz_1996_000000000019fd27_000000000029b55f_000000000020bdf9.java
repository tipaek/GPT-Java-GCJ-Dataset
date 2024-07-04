import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        List<Case> cases = new ArrayList<>(testCases);

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(startTime, endTime));
            }
            cases.add(new Case(activities));
        }
        scanner.close();

        for (int i = 0; i < cases.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + assignActivities(cases.get(i)));
        }
    }

    static class Case {
        List<Activity> activities;

        Case(List<Activity> activities) {
            this.activities = activities;
        }

        List<Activity> getActivities() {
            return activities;
        }
    }

    static class Activity {
        String person;
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        String getPerson() {
            return person;
        }

        void setPerson(String person) {
            this.person = person;
        }

        int getStartTime() {
            return startTime;
        }

        int getEndTime() {
            return endTime;
        }
    }

    private static String assignActivities(Case c) {
        List<String> users = Arrays.asList("C", "J");
        List<Activity> activities = c.getActivities();
        String currentUser = users.get(0);

        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (i == 0) {
                activity.setPerson(currentUser);
            } else {
                List<Activity> currentUserActivities = filterActivitiesByUser(activities, currentUser);
                if (!isTimeSlotAvailable(activity.getStartTime(), activity.getEndTime(), currentUserActivities)) {
                    currentUser = toggleUser(currentUser);
                    currentUserActivities = filterActivitiesByUser(activities, currentUser);
                    if (!isTimeSlotAvailable(activity.getStartTime(), activity.getEndTime(), currentUserActivities)) {
                        return "IMPOSSIBLE";
                    } else {
                        activity.setPerson(currentUser);
                    }
                } else {
                    activity.setPerson(currentUser);
                }
            }
        }
        return activities.stream().map(Activity::getPerson).collect(Collectors.joining());
    }

    private static List<Activity> filterActivitiesByUser(List<Activity> activities, String user) {
        return activities.stream().filter(activity -> user.equals(activity.getPerson)).collect(Collectors.toList());
    }

    private static boolean isTimeSlotAvailable(int startTime, int endTime, List<Activity> activities) {
        for (Activity activity : activities) {
            if (isOverlapping(startTime, endTime, activity.getStartTime(), activity.getEndTime())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(int startTime, int endTime, int activityStartTime, int activityEndTime) {
        return (startTime < activityEndTime && endTime > activityStartTime);
    }

    private static String toggleUser(String currentUser) {
        return "C".equals(currentUser) ? "J" : "C";
    }
}