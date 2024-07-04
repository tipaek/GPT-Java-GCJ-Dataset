import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            Activity[] activities = new Activity[N];
            char[] schedule = new char[N];
            boolean impossible = false;

            for (int n = 0; n < N; n++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities[n] = new Activity(start, end, n);
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a.start));

            int endC = 0, endJ = 0;

            for (Activity activity : activities) {
                if (endC <= activity.start) {
                    schedule[activity.index] = 'C';
                    endC = activity.end;
                } else if (endJ <= activity.start) {
                    schedule[activity.index] = 'J';
                    endJ = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : new String(schedule);
            System.out.printf("Case #%d: %s%n", t, result);
        }
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