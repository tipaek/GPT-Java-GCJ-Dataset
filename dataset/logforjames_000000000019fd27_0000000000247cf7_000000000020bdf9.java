import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    private static class Activity {
        private final int id;
        private final int start;
        private final int end;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int caso = 1; caso <= t; ++caso) {
            int n = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            for (int i = 0;i < n;i++) {
                activities.add(new Activity(i, in.nextInt(), in.nextInt()));
            }

            Optional<Map<Activity, Character>> schedule = generateSchedule(activities);

            if (schedule.isPresent()) {
                String result = schedule.get().entrySet().stream()
                        .sorted(Comparator.comparingInt(e -> e.getKey().id))
                        .map(Map.Entry::getValue)
                        .map(String::valueOf)
                        .collect(Collectors.joining());
                System.out.println("Case #" + caso + ": " + result);
            } else {
                System.out.println("Case #" + caso + ": IMPOSSIBLE");
            }
        }
    }

    private static Optional<Map<Activity, Character>> generateSchedule(List<Activity> activities) {
        Map<Character, Integer> freeAt = new HashMap<>();
        freeAt.put('C', 0);
        freeAt.put('J', 0);

        activities.sort(Comparator.comparingInt(a -> a.start));

        Map<Activity, Character> schedule = new HashMap<>();
        for (Activity activity : activities) {
            Optional<Map.Entry<Character, Integer>> activityTaker =
                    freeAt.entrySet().stream().filter(e -> e.getValue() <= activity.start)
                    .findAny();
            if (activityTaker.isPresent()) {
                Character parent = activityTaker.get().getKey();
                schedule.put(activity, parent);
                freeAt.put(parent, activity.end);
            } else {
                return Optional.empty();
            }
        }

        return Optional.of(schedule);
    }
}
