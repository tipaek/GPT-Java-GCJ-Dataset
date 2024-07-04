import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static String IMPOSSIBLE = "IMPOSSIBLE";
    public static String JAMIE = "J";
    public static String CAMERON = "C";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            StringBuilder planning = new StringBuilder(n);
            Set<ActivityTiming> allActivities = new TreeSet<>(Comparator.comparingInt(o -> o.start));
            Set<ActivityTiming> jamiePlanning = new HashSet<>();
            Set<ActivityTiming> cameronPlanning = new HashSet<>();
            boolean isImpossible = false;
            for (int activity = 0; activity < n; activity++) {
                planning.append("J");
                int start = in.nextInt();
                int end = in.nextInt();
                ActivityTiming activityTimings = new ActivityTiming(start, end, activity);
                allActivities.add(activityTimings);
            }
            Iterator<ActivityTiming> iterator = allActivities.iterator();
            while (iterator.hasNext() && !isImpossible) {
                ActivityTiming activityTimings = iterator.next();
                if (isOverlapWithActivities(jamiePlanning, activityTimings)) {
                    if (isOverlapWithActivities(cameronPlanning, activityTimings)) {
                        isImpossible = true;
                    } else {
                        planning.setCharAt(activityTimings.id, 'C');
                        cameronPlanning.add(activityTimings);
                    }
                } else {
                    planning.setCharAt(activityTimings.id, 'J');
                    jamiePlanning.add(activityTimings);
                }
            }
            if (isImpossible) {
                System.out.println("Case #" + i + ": " + IMPOSSIBLE);
            } else {
                System.out.println("Case #" + i + ": " + planning.toString());
            }
        }
    }

    private static boolean isOverlapWithActivities(Set<ActivityTiming> activities, ActivityTiming activityTiming) {
        boolean isOverlap = false;
        for (ActivityTiming activity : activities) {
            isOverlap = isOverlap || isOverlap(activity, activityTiming);
        }
        return isOverlap;
    }

    private static boolean isOverlap(ActivityTiming activityTiming1, ActivityTiming activityTiming2) {
        return (activityTiming2.start >= activityTiming1.start && activityTiming2.start < activityTiming1.end) ||
                (activityTiming2.end > activityTiming1.start && activityTiming2.end <= activityTiming1.end) ||
                (activityTiming2.start <= activityTiming1.start && activityTiming2.end >= activityTiming1.end);
    }

    static class ActivityTiming {
        int id;
        int start;
        int end;

        public ActivityTiming(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
    }
}