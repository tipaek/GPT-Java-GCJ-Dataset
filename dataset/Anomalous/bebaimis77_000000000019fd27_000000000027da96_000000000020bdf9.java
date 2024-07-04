import java.util.*;
import java.io.*;

class Activity {
    private int activityNo;
    private int startTime;
    private int endTime;

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setStartTime(int time) {
        startTime = time;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getActivityNo() {
        return activityNo;
    }

    public void setActivityNo(int no) {
        activityNo = no;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int z = 1; z <= T; z++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Activity> cameronActivities = new ArrayList<>();
            List<Activity> jamieActivities = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                Activity activity = new Activity();
                activity.setStartTime(scanner.nextInt());
                activity.setEndTime(scanner.nextInt());
                activity.setActivityNo(i);
                activities.add(activity);
            }

            activities.sort(Comparator.comparingInt(Activity::getStartTime));

            boolean possible = true;
            char[] result = new char[N];
            for (Activity activity : activities) {
                if (isValid(activity, cameronActivities)) {
                    cameronActivities.add(activity);
                    result[activity.getActivityNo()] = 'C';
                } else if (isValid(activity, jamieActivities)) {
                    jamieActivities.add(activity);
                    result[activity.getActivityNo()] = 'J';
                } else {
                    System.out.println("Case #" + z + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.print("Case #" + z + ": ");
                System.out.println(result);
            }
        }
    }

    private static boolean isValid(Activity activity, List<Activity> activities) {
        for (Activity a : activities) {
            if ((a.getStartTime() <= activity.getStartTime() && activity.getStartTime() < a.getEndTime()) ||
                (a.getStartTime() < activity.getEndTime() && activity.getEndTime() <= a.getEndTime()) ||
                (a.getStartTime() > activity.getStartTime() && activity.getEndTime() > a.getEndTime())) {
                return false;
            }
        }
        return true;
    }
}