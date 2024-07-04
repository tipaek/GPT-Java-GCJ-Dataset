import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static String IMPOSSIBLE = "IMPOSSIBLE";
    public static String JAMIE = "J";
    public static String CAMERON = "C";

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder planning = new StringBuilder();
            int n = in.nextInt();
            Set<ActivityTiming> jamiePlanning = new HashSet<>();
            Set<ActivityTiming> cameronPlanning = new HashSet<>();
            boolean isImpossible = false;
            for (int activity = 0; activity < n; activity++) {
                int start = in.nextInt();
                int end = in.nextInt();
                if (!isImpossible) {
                    ActivityTiming activityTimings = new ActivityTiming(start, end);
                    if (isOverlapWithActivities(jamiePlanning, activityTimings)) {
                        if (isOverlapWithActivities(cameronPlanning, activityTimings)) {
                            isImpossible = true;
                        } else {
                            planning.append(CAMERON);
                            cameronPlanning.add(activityTimings);
                        }
                    } else {
                        planning.append(JAMIE);
                        jamiePlanning.add(activityTimings);
                    }
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
        int start;
        int end;

        public ActivityTiming(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ActivityTiming that = (ActivityTiming) o;
            return start == that.start &&
                    end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }
}