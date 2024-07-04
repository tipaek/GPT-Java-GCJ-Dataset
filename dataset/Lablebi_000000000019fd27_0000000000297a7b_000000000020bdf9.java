import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            List<ActivityTiming> jamiePlanning = new ArrayList<>();
            List<ActivityTiming> cameronPlanning = new ArrayList<>();
            for (int activity = 0; activity < n; activity++) {
                int start = in.nextInt();
                int end = in.nextInt();
                ActivityTiming activityTimings = new ActivityTiming(start, end);
                if (isOverlapWithActivities(jamiePlanning, activityTimings)) {
                    if (isOverlapWithActivities(cameronPlanning, activityTimings)) {
                        planning = new StringBuilder(IMPOSSIBLE);
                        break;
                    } else {
                        planning.append(CAMERON);
                        cameronPlanning.add(activityTimings);
                    }
                } else {
                    planning.append(JAMIE);
                    jamiePlanning.add(activityTimings);
                }
            }
            System.out.println("Case #" + i + ": " + planning.toString());
        }
    }

    private static boolean isOverlapWithActivities(List<ActivityTiming> activities, ActivityTiming activityTiming) {
        boolean isOverlap = false;
        for (ActivityTiming activity : activities) {
            isOverlap |= isOverlap(activity, activityTiming);
        }
        return isOverlap;
    }

    private static boolean isOverlap(ActivityTiming activityTiming1, ActivityTiming activityTiming2) {
        return (activityTiming2.start >= activityTiming1.start && activityTiming2.start < activityTiming1.end) ||
                (activityTiming2.end > activityTiming1.start && activityTiming2.end <= activityTiming1.end);
    }

    static class ActivityTiming {
        int start;
        int end;

        public ActivityTiming(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}