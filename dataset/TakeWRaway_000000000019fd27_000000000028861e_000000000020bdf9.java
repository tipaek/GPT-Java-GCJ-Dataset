import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = scanner.nextInt();
        IntStream.rangeClosed(1, T).forEach(t -> {
            int N = scanner.nextInt();
            List<Activity> activities = IntStream.range(0, N).boxed()
                    .map(i -> {
                        Activity activity = new Activity();
                        activity.start = scanner.nextInt();
                        activity.end = scanner.nextInt();
                        activity.id = i;
                        return activity;
                    })
                    .collect(toList());
            solve(activities, t);
        });
    }

    private static void solve(List<Activity> activities, int t) {
        activities.sort(comparingInt(activity -> activity.start));
        Activity c = null;
        Activity j = null;
        for (Activity activity : activities) {
            if (c == null || c.end <= activity.start) {
                c = activity;
                activity.assignee = "C";
            } else if (j == null || j.end <= activity.start) {
                j = activity;
                activity.assignee = "J";
            } else {
                activity.assignee = "-";
            }
        }
        activities.sort(comparingInt(activity -> activity.id));
        String answer = activities.stream().map(activity -> activity.assignee).collect(joining());
        System.out.println(format("Case #%s: %s", t, answer.contains("-") ? "IMPOSSIBLE" : answer));
    }

    private static class Activity {
        public int start;
        public int end;
        public int id;
        public String assignee;
    }
}
