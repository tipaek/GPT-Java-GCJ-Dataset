import java.util.*;
import java.io.*;

public class Solution {

    static class Activity {
        String parent;
        ActivityEvent start;
        ActivityEvent end;
    }

    static class ActivityEvent {
        int time;
        boolean isStart;
        Activity activity;

        ActivityEvent(int time, boolean isStart, Activity activity) {
            this.time = time;
            this.isStart = isStart;
            this.activity = activity;
        }

        @Override
        public String toString() {
            return "[time=" + time + ", isStart=" + isStart + "]";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int n = scanner.nextInt();
            List<ActivityEvent> events = new ArrayList<>();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                Activity activity = new Activity();
                activities.add(activity);

                ActivityEvent startEvent = new ActivityEvent(startTime, true, activity);
                events.add(startEvent);
                activity.start = startEvent;

                ActivityEvent endEvent = new ActivityEvent(endTime, false, activity);
                events.add(endEvent);
                activity.end = endEvent;
            }

            solve(tc, events, activities);
        }
        scanner.close();
    }

    private static void solve(int tc, List<ActivityEvent> events, List<Activity> activities) {
        events.sort((e1, e2) -> {
            int timeComparison = Integer.compare(e1.time, e2.time);
            if (timeComparison == 0) {
                return Boolean.compare(e2.isStart, e1.isStart);
            }
            return timeComparison;
        });

        Stack<String> availableParents = new Stack<>();
        availableParents.push("J");
        availableParents.push("C");

        for (ActivityEvent event : events) {
            if (event.isStart) {
                if (availableParents.isEmpty()) {
                    System.out.println("Case #" + tc + ": IMPOSSIBLE");
                    return;
                }
                event.activity.parent = availableParents.pop();
            } else {
                availableParents.push(event.activity.parent);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.parent);
        }

        System.out.println("Case #" + tc + ": " + result.toString());
    }
}