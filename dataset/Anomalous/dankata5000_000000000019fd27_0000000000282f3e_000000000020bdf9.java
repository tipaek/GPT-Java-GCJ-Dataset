import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.run(System.in);
        System.out.print(result);
    }

    String run(InputStream is) {
        StringBuilder output = new StringBuilder();
        try (Scanner scanner = new Scanner(is)) {
            final int T = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= T; t++) {
                int N = scanner.nextInt();
                int[] startTimes = new int[N];
                int[] endTimes = new int[N];

                for (int i = 0; i < N; i++) {
                    startTimes[i] = scanner.nextInt();
                    endTimes[i] = scanner.nextInt();
                }

                String result = scheduleActivities(startTimes, endTimes);
                output.append("Case #").append(t).append(": ").append(result).append(System.lineSeparator());
            }
        }
        return output.toString();
    }

    String scheduleActivities(int[] startTimes, int[] endTimes) {
        int N = endTimes.length;
        Activity[] activities = new Activity[N];
        SortedMap<Integer, Moment> moments = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            int start = startTimes[i];
            int end = endTimes[i];
            Activity activity = new Activity(start, end);
            activities[i] = activity;

            moments.computeIfAbsent(start, k -> new Moment()).starts.add(activity);
            moments.computeIfAbsent(end, k -> new Moment()).ends.add(activity);
        }

        boolean cAvailable = true;
        boolean jAvailable = true;

        for (Moment moment : moments.values()) {
            for (Activity activity : moment.ends) {
                if (activity.assignedParent == Parent.C) {
                    cAvailable = true;
                } else if (activity.assignedParent == Parent.J) {
                    jAvailable = true;
                }
            }

            for (Activity activity : moment.starts) {
                if (cAvailable) {
                    activity.assignedParent = Parent.C;
                    cAvailable = false;
                } else if (jAvailable) {
                    activity.assignedParent = Parent.J;
                    jAvailable = false;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.assignedParent);
        }
        return result.toString();
    }

    enum Parent {
        C, J
    }

    class Activity {
        int start;
        int end;
        Parent assignedParent;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Moment {
        List<Activity> starts = new ArrayList<>();
        List<Activity> ends = new ArrayList<>();
    }
}