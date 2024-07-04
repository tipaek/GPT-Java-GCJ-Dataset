import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int numberOfTests = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(numberOfActivities);
            for (int i = 0; i < numberOfActivities; i++) {
                activities.add(new Activity(i, scanner.nextInt(), scanner.nextInt()));
            }
            String scheduleResult = generateSchedule(activities);
            System.out.println(String.format("Case #%d: %s", testCase, scheduleResult));
        }
    }

    private static String generateSchedule(List<Activity> activities) {
        activities.sort(Comparator.comparingInt(a -> a.startTime));

        char[] schedule = new char[activities.size()];
        int cameronAvailableTime = 0;
        int jamieAvailableTime = 0;

        for (Activity activity : activities) {
            if (cameronAvailableTime <= activity.startTime) {
                schedule[activity.index] = 'C';
                cameronAvailableTime = activity.endTime;
            } else if (jamieAvailableTime <= activity.startTime) {
                schedule[activity.index] = 'J';
                jamieAvailableTime = activity.endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(schedule);
    }

    private static class Activity {
        private final int index;
        private final int startTime;
        private final int endTime;

        Activity(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}

class FastScanner {
    private final StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public int nextInt() {
        try {
            tokenizer.nextToken();
            return (int) tokenizer.nval;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}