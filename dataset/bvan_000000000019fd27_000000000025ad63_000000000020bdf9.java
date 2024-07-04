import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int tests = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            int activitiesCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(activitiesCount);
            for (int i = 0; i < activitiesCount; i++) {
                activities.add(new Activity(i, scanner.nextInt(), scanner.nextInt()));
            }
            String schedule = buildSchedule(activities);
            System.out.println(String.format("Case #%d: %s", t, schedule));
        }
    }

    private static String buildSchedule(List<Activity> activities) {
        activities.sort(Comparator.comparing(a -> a.start));

        char[] res = new char[activities.size()];
        int cameronEnd = 0;
        int jamieEnd = 0;
        for (Activity activity : activities) {
            boolean cameronWork = cameronEnd <= activity.start;
            boolean jamieWork = jamieEnd <= activity.start;
            if (cameronWork) {
                res[activity.index] = 'C';
                cameronEnd = activity.end;
            } else if (jamieWork) {
                res[activity.index] = 'J';
                jamieEnd = activity.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(res);
    }

    private static class Activity {

        private final int index;
        private final int start;
        private final int end;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}

class FastScanner {

    private final StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt()  {
        try {
            streamTokenizer.nextToken();
            return (int) streamTokenizer.nval;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
