import java.util.*;
import java.io.*;

public class Solution {

    static class Activity {
        int startTime;
        int endTime;
        int location;
        String executer;

        public static final Comparator<Activity> ORIGINAL_COMPARATOR = Comparator.comparingInt(a -> a.location);

        public static final Comparator<Activity> TIME_COMPARATOR = Comparator.comparingInt(a -> a.startTime);
    }

    static class User {
        String ID;
        int finishingTime;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        for (int t = 0; t < testCases; t++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activityCount; i++) {
                Activity activity = new Activity();
                activity.startTime = scanner.nextInt();
                activity.endTime = scanner.nextInt();
                activity.location = i;
                activities.add(activity);
            }

            User cameron = new User();
            cameron.ID = "C";
            cameron.finishingTime = -1;

            User jamie = new User();
            jamie.ID = "J";
            jamie.finishingTime = -1;

            activities.sort(Activity.TIME_COMPARATOR);
            StringBuilder result = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.startTime >= cameron.finishingTime) {
                    result.append(cameron.ID);
                    cameron.finishingTime = activity.endTime;
                } else if (activity.startTime >= jamie.finishingTime) {
                    result.append(jamie.ID);
                    jamie.finishingTime = activity.endTime;
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}