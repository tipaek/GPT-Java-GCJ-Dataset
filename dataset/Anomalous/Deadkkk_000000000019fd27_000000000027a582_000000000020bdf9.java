import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        List<Integer> activityCounts = new ArrayList<>();
        List<List<Activity>> allActivities = new ArrayList<>();
        List<List<Activity>> originalActivitiesList = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            int noOfActivities = sc.nextInt();
            activityCounts.add(noOfActivities);
            List<Activity> activities = new ArrayList<>();
            List<Activity> originalActivities = new ArrayList<>();
            for (int j = 0; j < noOfActivities; j++) {
                Activity activity = new Activity(sc.nextInt(), sc.nextInt());
                activities.add(activity);
                originalActivities.add(activity);
            }
            allActivities.add(activities);
            originalActivitiesList.add(originalActivities);
        }

        for (int i = 0; i < noOfTestCases; i++) {
            int noOfActivities = activityCounts.get(i);
            List<Activity> activities = allActivities.get(i);
            List<Activity> originalActivities = originalActivitiesList.get(i);
            if (planActivities(noOfActivities, activities)) {
                System.out.println("Case #" + (i + 1) + ": " + generatePlan(originalActivities));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static String generatePlan(List<Activity> activities) {
        StringBuilder plan = new StringBuilder();
        for (Activity activity : activities) {
            plan.append(activity.getTag());
        }
        return plan.toString();
    }

    private static boolean planActivities(int noOfActivities, List<Activity> activities) {
        Collections.sort(activities, new ActivityComparator());
        Activity C = new Activity(0, 0);
        Activity J = new Activity(0, 0);
        for (Activity activity : activities) {
            if (activity.getStartTime() >= C.getEndTime()) {
                activity.setTag("C");
                C.setEndTime(activity.getEndTime());
            } else if (activity.getStartTime() >= J.getEndTime()) {
                activity.setTag("J");
                J.setEndTime(activity.getEndTime());
            } else {
                return false;
            }
        }
        return true;
    }
}

class ActivityComparator implements Comparator<Activity> {

    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.getStartTime(), a2.getStartTime());
    }
}

class Activity {
    private final int startTime;
    private final int endTime;
    private String tag;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}