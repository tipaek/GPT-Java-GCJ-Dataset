import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int activities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();

            List<WorkTime> cSchedule = new ArrayList<>();
            List<WorkTime> jSchedule = new ArrayList<>();

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                WorkTime currentActivity = new WorkTime(start, end);

                if (canBeScheduled(cSchedule, currentActivity)) {
                    cSchedule.add(currentActivity);
                    schedule.append("C");
                } else if (canBeScheduled(jSchedule, currentActivity)) {
                    jSchedule.add(currentActivity);
                    schedule.append("J");
                } else {
                    results[i] = "IMPOSSIBLE";
                    schedule = null;
                    break;
                }
            }

            if (schedule != null) {
                results[i] = schedule.toString();
            }
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(String.format("Case #%d: %s", i + 1, results[i]));
        }
    }

    private static boolean canBeScheduled(List<WorkTime> schedule, WorkTime activity) {
        for (WorkTime scheduledActivity : schedule) {
            if (!(activity.getStart() >= scheduledActivity.getEnd() || activity.getEnd() <= scheduledActivity.getStart())) {
                return false;
            }
        }
        return true;
    }

    private static class WorkTime {
        private final int start;
        private final int end;

        private WorkTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}