import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        processSchedule();
    }

    static void processSchedule() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = Integer.parseInt(scanner.nextLine().trim());
            int[] schedule = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int activity = 0; activity < activities; activity++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);

                if (!isImpossible && canSchedule(schedule, start, end)) {
                    int assigned = schedule[start];
                    result.append(assigned == 1 ? "C" : "J");
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

    static boolean canSchedule(int[] schedule, int start, int end) {
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