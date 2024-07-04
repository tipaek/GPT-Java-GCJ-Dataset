import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static class Activity {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static char[] solve(Activity[] activities) {
        Arrays.sort(activities, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                int startCompared = Integer.compare(o1.start, o2.start);
                return startCompared != 0 ? startCompared : Integer.compare(o1.end, o2.end);
            }
        });

        Activity cameronTask = null;
        Activity jamieTask  = null;
        char[] result = new char[activities.length];

        for (int i = 0; i < activities.length; ++i) {
            Activity activity = activities[i];
            if (cameronTask != null && activity.start >= cameronTask.end) cameronTask = null;
            if (jamieTask != null && activity.start >= jamieTask.end) jamieTask = null;

            if (cameronTask == null) {
                cameronTask = activity;
                result[i] = 'C';
            } else if (jamieTask == null) {
                jamieTask = activity;
                result[i] = 'J';
            } else {
                return null;
            }
        }

        return result;
    }

    public static void main(String[] params) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < t; ++i) {
            int n = Integer.valueOf(scanner.nextLine());
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; ++j) {
                String[] in = scanner.nextLine().split(" ");
                activities[j] = new Activity(Integer.valueOf(in[0]), Integer.valueOf(in[1]));
            }
            char[] solution = solve(activities);
            System.out.println(String.format("Case  #%d: %s", i + 1, solution != null ? new String(solution) : "IMPOSSIBLE"));
        }
    }
}
