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
            List<WorkTime<Integer, Integer>> cameronSchedule = new ArrayList<>();
            List<WorkTime<Integer, Integer>> jamieSchedule = new ArrayList<>();

            boolean possible = true;
            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                WorkTime<Integer, Integer> currentActivity = new WorkTime<>(start, end);

                if (canSchedule(cameronSchedule, currentActivity)) {
                    cameronSchedule.add(currentActivity);
                    schedule.append("C");
                } else if (canSchedule(jamieSchedule, currentActivity)) {
                    jamieSchedule.add(currentActivity);
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            results[i] = possible ? schedule.toString() : "IMPOSSIBLE";
        }

        for (int i = 0; i < results.length; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, results[i]);
        }
    }

    private static boolean canSchedule(List<WorkTime<Integer, Integer>> schedule, WorkTime<Integer, Integer> newActivity) {
        for (WorkTime<Integer, Integer> activity : schedule) {
            if (!(newActivity.getStart() >= activity.getEnd() || newActivity.getEnd() <= activity.getStart())) {
                return false;
            }
        }
        return true;
    }

    protected static class WorkTime<Start, End> {
        private final Start start;
        private final End end;

        public WorkTime(Start start, End end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return (Integer) start;
        }

        public int getEnd() {
            return (Integer) end;
        }
    }
}