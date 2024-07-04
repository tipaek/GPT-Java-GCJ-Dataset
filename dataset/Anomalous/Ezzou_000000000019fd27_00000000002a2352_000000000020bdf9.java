import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        processTasks();
    }

    static void processTasks() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int taskCount = Integer.parseInt(scanner.nextLine().trim());
            int[] schedule = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int task = 0; task < taskCount; task++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(timeRange[0]);
                int endTime = Integer.parseInt(timeRange[1]);

                if (!isImpossible && canScheduleTask(schedule, startTime, endTime)) {
                    int assignedPerson = schedule[startTime + 1];
                    result.append(assignedPerson == 1 ? "C" : "J");
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }

    static boolean canScheduleTask(int[] schedule, int start, int end) {
        for (int time = Math.max(0, start); time <= Math.min(schedule.length - 1, end); time++) {
            if (schedule[time] > 1) {
                return false;
            }
            if (time != start && time != end) {
                schedule[time]++;
            }
        }
        return true;
    }
}