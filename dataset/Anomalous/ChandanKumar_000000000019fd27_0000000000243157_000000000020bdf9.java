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
            WorkTime currentC = new WorkTime(0, 0);
            WorkTime currentJ = new WorkTime(0, 0);
            List<WorkTime> workTimes = new ArrayList<>();

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                workTimes.add(new WorkTime(start, end));
            }

            boolean possible = true;
            for (WorkTime workTime : workTimes) {
                if (currentC.isAvailable(workTime)) {
                    currentC = workTime;
                    schedule.append("C");
                } else if (currentJ.isAvailable(workTime)) {
                    currentJ = workTime;
                    schedule.append("J");
                } else {
                    results[i] = "IMPOSSIBLE";
                    possible = false;
                    break;
                }
            }

            if (possible) {
                results[i] = schedule.toString();
            }
        }

        for (int i = 0; i < results.length; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, results[i]);
        }
    }

    private static class WorkTime {
        private final int start;
        private final int end;

        WorkTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isAvailable(WorkTime other) {
            return other.start >= this.end || other.end <= this.start;
        }
    }
}