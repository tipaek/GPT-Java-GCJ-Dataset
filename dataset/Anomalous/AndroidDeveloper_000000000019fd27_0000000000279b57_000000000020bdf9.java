import java.util.*;

public class Solution {

    static class Activity {
        int begin;
        int end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int test = 0; test < tests; ++test) {
            int n_activities = scanner.nextInt();

            Activity[] activities = new Activity[n_activities];
            for (int i = 0; i < n_activities; i++) {
                activities[i] = new Activity();
                activities[i].begin = scanner.nextInt();
                activities[i].end = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.begin));

            int cEnd = -1;
            int jEnd = -1;

            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (Activity activity : activities) {
                if (cEnd > activity.begin && jEnd > activity.begin) {
                    isImpossible = true;
                    break;
                }

                if (cEnd <= activity.begin) {
                    result.append("C");
                    cEnd = activity.end;
                } else {
                    result.append("J");
                    jEnd = activity.end;
                }
            }

            System.out.printf("Case #%d: %s%n", test + 1, isImpossible ? "IMPOSSIBLE" : result.toString());
        }
    }
}