import java.util.*;

public class Solution {

    static class Activity {
        int begin;
        int end;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; test++) {
            int n = scanner.nextInt();
            Activity[] activities = new Activity[n];
            
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity();
                activities[i].begin = scanner.nextInt();
                activities[i].end = scanner.nextInt();
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.begin));

            int cEnd = 0;
            int jEnd = 0;
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.begin >= cEnd) {
                    schedule.append('C');
                    cEnd = activity.end;
                } else if (activity.begin >= jEnd) {
                    schedule.append('J');
                    jEnd = activity.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.printf("Case #%d: %s%n", test, schedule.toString());
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", test);
            }
        }
    }
}