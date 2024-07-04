import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        List<Integer> nos = new ArrayList<>();
        List<List<Activity>> tActivities = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            int noOfActivities = sc.nextInt();
            nos.add(noOfActivities);
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < noOfActivities; j++) {
                activities.add(new Activity(sc.nextInt(), sc.nextInt()));
            }
            tActivities.add(activities);
        }

        for (int i = 0; i < noOfTestCases; i++) {
            int noOfActivities = nos.get(i);
            List<Activity> activities = tActivities.get(i);
            if (planActivities(noOfActivities, activities)) {
                System.out.println("Case #" + (i + 1) + ": " + getPlan(activities));
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }
    }

    private static String getPlan(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.tag);
        }
        return result.toString();
    }

    private static boolean planActivities(int noOfActivities, List<Activity> activities) {
        Collections.sort(activities, new ActivityComparator());
        Activity C = new Activity(0, 0);
        Activity J = new Activity(0, 0);

        for (Activity activity : activities) {
            if (activity.startTime >= C.endTime) {
                activity.setTag("C");
                C.endTime = activity.endTime;
            } else if (activity.startTime >= J.endTime) {
                activity.setTag("J");
                J.endTime = activity.endTime;
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
        return Integer.compare(a1.startTime, a2.startTime);
    }
}

class Activity {
    int startTime;
    int endTime;
    String tag;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    void setTag(String tag) {
        this.tag = tag;
    }
}