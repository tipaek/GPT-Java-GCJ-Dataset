import java.io.BufferedInputStream;
import java.util.*;

class Solution {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final char CAMERON = 'C';
    private static final char JAMIE = 'J';

    static class Activity {
        int start;
        int finish;
        char asignee;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int finish = scanner.nextInt();

                activities.add(new Activity(start, finish));
            }

            System.out.printf("Case #%d: %s\n", (i + 1), solve(activities));
        }
    }

    private static String solve(List<Activity> activities) {
        TreeMap<Integer, Integer> lookup = new TreeMap<>();
        HashMap<Integer, List<Activity>> alookup = new HashMap<>();

        int lastKnownTimeForCameron = -1;
        int lastKnownTimeForJamie = -1;

        for (Activity activity: activities) {
            lookup.put(activity.start, lookup.getOrDefault(activity.start, 0) + 1);
            lookup.put(activity.finish, lookup.getOrDefault(activity.finish, 0) - 1);

            alookup.putIfAbsent(activity.finish, new ArrayList<>());
            alookup.get(activity.finish).add(activity);
        }

        int balance = 0;
        for (Map.Entry<Integer, Integer> entry: lookup.entrySet()) {
            balance += entry.getValue();

            if (balance >= 3) {
                return IMPOSSIBLE;
            }

            // balance is 0 or 1 or 2

            int time = entry.getKey();
            List<Activity> endedActivities = alookup.getOrDefault(time, Collections.emptyList());

            if (endedActivities.size() == 1) {
                if (lastKnownTimeForCameron <= endedActivities.get(0).start) {
                    lastKnownTimeForCameron = endedActivities.get(0).finish;
                    endedActivities.get(0).asignee = CAMERON;
                } else {
                    lastKnownTimeForJamie = endedActivities.get(0).finish;
                    endedActivities.get(0).asignee = JAMIE;
                }
            } else if (endedActivities.size() == 2) {
                Activity one = endedActivities.get(0);
                Activity another = endedActivities.get(1);

                Activity earlier = one.start > another.start ? another : one;
                Activity later = one.start > another.start ? one : another;

                if (lastKnownTimeForCameron <= earlier.start) {
                    earlier.asignee = CAMERON;
                    lastKnownTimeForCameron = earlier.finish;
                    later.asignee = JAMIE;
                    lastKnownTimeForJamie = later.finish;
                } else if (lastKnownTimeForJamie <= earlier.start && lastKnownTimeForCameron <= later.start) {
                    earlier.asignee = JAMIE;
                    lastKnownTimeForJamie = earlier.finish;
                    later.asignee = CAMERON;
                    lastKnownTimeForCameron = later.finish;
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Activity activity: activities) {
            builder.append(activity.asignee);
        }

        return builder.toString();
    }
}