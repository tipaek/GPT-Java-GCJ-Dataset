import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static class Activity {
        int index;
        int start;
        int end;
        char actor;

        public Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    private static boolean isPossible(List<Activity> activities) {
        int[] minutes = new int[60 * 24];
        for (Activity activity : activities) {
            for (int d = activity.start; d < activity.end; d++) {
                minutes[d]++;
            }
        }

        return !Arrays.stream(minutes).anyMatch(i -> i > 2);
    }

    private static String schedule(List<Activity> activities) {
        if (!isPossible(activities)) {
            return "IMPOSSIBLE";
        }

        activities.sort(Comparator.comparingInt(o -> o.start));

        activities.get(0).actor = 'C';
        int end = activities.get(0).end;
        char actorOfEnd = activities.get(0).actor;

        for (int i = 1; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (activity.start < end) {
                activity.actor = actorOfEnd == 'C' ? 'J' : 'C';
            } else {
                activity.actor = actorOfEnd;
            }

            end = Math.max(activity.end, end);
            if (end == activity.end) {
                actorOfEnd = activity.actor;
            }
        }

        activities.sort(Comparator.comparing(o -> o.index));
        return activities.stream().map(a -> Character.toString(a.actor)).collect(Collectors.joining(""));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= t; ++testCase) {
            int activitiesCount = in.nextInt();

            List<Activity> activitiesDuration = new ArrayList<>();
            for (int i = 1; i <= activitiesCount; i++) {
                activitiesDuration.add(new Activity(i, in.nextInt(), in.nextInt()));
            }

            System.out.println(String.format("Case #%d: %s", testCase, schedule(activitiesDuration)));
        }
    }
}
