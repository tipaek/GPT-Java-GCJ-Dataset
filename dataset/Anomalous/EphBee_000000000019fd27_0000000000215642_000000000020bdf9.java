import java.util.*;

public class Solution {

    static class Activity {
        int startTime;
        int endTime;
        int location;
        String executor;

        public static final Comparator<Activity> ORIGINAL_COMPARATOR = Comparator.comparingInt(a -> a.location);
        public static final Comparator<Activity> TIME_COMPARATOR = Comparator.comparingInt(a -> a.startTime);
    }

    static class User {
        String id;
        int finishingTime;

        User(String id) {
            this.id = id;
            this.finishingTime = -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        for (int caseID = 1; caseID <= count; caseID++) {
            int activitiesCount = in.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                Activity activity = new Activity();
                activity.startTime = in.nextInt();
                activity.endTime = in.nextInt();
                activity.location = i;
                activities.add(activity);
            }

            User cameron = new User("C");
            User jamie = new User("J");

            activities.sort(Activity.TIME_COMPARATOR);
            StringBuilder finalResult = new StringBuilder();
            boolean possible = true;

            for (Activity activity : activities) {
                if (activity.startTime >= cameron.finishingTime) {
                    activity.executor = cameron.id;
                    cameron.finishingTime = activity.endTime;
                } else if (activity.startTime >= jamie.finishingTime) {
                    activity.executor = jamie.id;
                    jamie.finishingTime = activity.endTime;
                } else {
                    finalResult.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                activities.sort(Activity.ORIGINAL_COMPARATOR);
                for (Activity activity : activities) {
                    finalResult.append(activity.executor);
                }
            }

            System.out.println("Case #" + caseID + ": " + finalResult);
        }
    }
}