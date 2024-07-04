import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(start, end, j));
            }
            String result = solve(activities);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String solve(List<Activity> activities) {
        Collections.sort(activities, Comparator.comparingInt(a -> a.start));

        int cEnd = 0;
        int jEnd = 0;
        char[] result = new char[activities.size()];
        for (Activity activity : activities) {
            if (cEnd <= activity.start) {
                result[activity.index] = 'C';
                cEnd = activity.end;
            } else if (jEnd <= activity.start) {
                result[activity.index] = 'J';
                jEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}