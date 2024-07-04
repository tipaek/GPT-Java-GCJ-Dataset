import java.util.*;

public class Solution {

    static class Activity {
        int num;
        int begin;
        int end;

        Activity(int num, int begin, int end) {
            this.num = num;
            this.begin = begin;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int test = 0; test < tests; test++) {
            int nActivities = scanner.nextInt();
            Activity[] activities = new Activity[nActivities];

            for (int i = 0; i < nActivities; i++) {
                int begin = scanner.nextInt();
                int end = scanner.nextInt();
                activities[i] = new Activity(i, begin, end);
            }

            Arrays.sort(activities, (a1, a2) -> {
                if (a1.begin != a2.begin) {
                    return Integer.compare(a1.begin, a2.begin);
                }
                return Integer.compare(a1.end, a2.end);
            });

            int cEnd = -1;
            int jEnd = -1;
            char[] schedule = new char[nActivities];
            boolean impossible = false;

            for (Activity activity : activities) {
                if (cEnd > activity.begin && jEnd > activity.begin) {
                    impossible = true;
                    break;
                }
                if (cEnd <= activity.begin) {
                    schedule[activity.num] = 'C';
                    cEnd = activity.end;
                } else if (jEnd <= activity.begin) {
                    schedule[activity.num] = 'J';
                    jEnd = activity.end;
                }
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", test + 1);
            } else {
                System.out.printf("Case #%d: %s%n", test + 1, new String(schedule));
            }
        }
    }
}