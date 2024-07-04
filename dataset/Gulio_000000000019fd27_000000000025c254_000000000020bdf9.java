import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();

            Activity[] activities = new Activity[N];
            Activity[] startingOrderActivities = new Activity[N];

            for (int n = 0; n < N; ++n) {
                int a = in.nextInt();
                int b = in.nextInt();
                activities[n] = new Activity(a, b);
                startingOrderActivities[n] = activities[n];
            }

            Arrays.sort(activities, Comparator.comparingInt(activity -> activity.startingTime));

            FreeManager freeManager = new FreeManager();

            try {
                for (Activity activity : activities) {
                    freeManager.addActivity(activity);
                }
            } catch (RuntimeException e) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }
            System.out.print("Case #" + t + ": ");
            for (Activity activity : startingOrderActivities) {
                System.out.print(activity.assignee);
            }
            System.out.println();
        }
    }

    static class Activity {
        final int startingTime;
        final int endingTime;
        char assignee;

        public Activity(int startingTime, int endingTime) {
            this.startingTime = startingTime;
            this.endingTime = endingTime;
        }
    }

    static class FreeManager {
        int[] freeUntil = new int[2];

        void addActivity(Activity activity) {
            if (freeUntil[0] <= activity.startingTime) {
                freeUntil[0] = activity.endingTime;
                activity.assignee = 'C';
                return;
            }
            if (freeUntil[1] <= activity.startingTime) {
                freeUntil[1] = activity.endingTime;
                activity.assignee = 'J';
                return;
            }
            throw new RuntimeException();
        }
    }
}
