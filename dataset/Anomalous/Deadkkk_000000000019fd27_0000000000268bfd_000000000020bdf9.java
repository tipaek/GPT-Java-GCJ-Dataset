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
        List<List<Activity>> testCases = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            int noOfActivities = sc.nextInt();
            activityCounts.add(noOfActivities);
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < noOfActivities; j++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt()));
            }
            testCases.add(activities);
        }

        for (int i = 0; i < noOfTestCases; i++) {
            int noOfActivities = activityCounts.get(i);
            List<Activity> activities = testCases.get(i);
            if (planActivities(noOfActivities, activities)) {
                System.out.println("Case #" + (i + 1) + ": " + getPlanString(activities));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static String getPlanString(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getTag());
        }
        return result.toString();
    }

    private static boolean planActivities(int noOfActivities, List<Activity> activities) {
        Collections.sort(activities, new ActivityComparator());
        Activity cActivity = new Activity(0, 0);
        Activity jActivity = new Activity(0, 0);

        for (Activity activity : activities) {
            if (activity.getStartTime() >= cActivity.getEndTime()) {
                activity.setTag("C");
                cActivity.setEndTime(activity.getEndTime());
            } else if (activity.getStartTime() >= jActivity.getEndTime()) {
                activity.setTag("J");
                jActivity.setEndTime(activity.getEndTime());
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
    private int startTime;
    private int endTime;
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

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}