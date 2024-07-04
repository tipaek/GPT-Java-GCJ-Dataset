import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new Activity(i, startTime, endTime));
            }

            activities.sort(new ActivityComparator());
            char[] schedule = new char[activitiesCount];
            int jamieEndTime = 0;
            int cameronEndTime = 0;
            boolean isImpossible = false;

            for (Activity activity : activities) {
                if (jamieEndTime <= activity.startTime) {
                    schedule[activity.id] = 'J';
                    jamieEndTime = activity.endTime;
                } else if (cameronEndTime <= activity.startTime) {
                    schedule[activity.id] = 'C';
                    cameronEndTime = activity.endTime;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                System.out.printf("Case #%d: %s\n", t, new String(schedule));
            }
        }
    }

    private static class Activity {
        int id;
        int startTime;
        int endTime;

        Activity(int id, int startTime, int endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private static class ActivityComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            if (a1.startTime != a2.startTime) {
                return Integer.compare(a1.startTime, a2.startTime);
            }
            return Integer.compare(a1.endTime, a2.endTime);
        }
    }
}