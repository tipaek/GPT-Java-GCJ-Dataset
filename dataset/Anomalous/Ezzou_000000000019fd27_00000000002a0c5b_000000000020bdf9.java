import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        processTasks();
    }

    static void processTasks() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            int[] schedule = new int[1441]; // Array to keep track of minutes
            StringBuilder result = new StringBuilder();

            boolean isImpossible = false;
            for (int j = 0; j < numIntervals; j++) {
                String[] interval = scanner.nextLine().split(" ");
                int start = Integer.parseInt(interval[0]);
                int end = Integer.parseInt(interval[1]);

                if (canSchedule(schedule, start, end)) {
                    int assigned = schedule[start];
                    result.append(assigned == 1 ? "C" : "J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (!isImpossible) {
                for (int j = 0; j < numIntervals; j++) {
                    String[] interval = scanner.nextLine().split(" ");
                    int start = Integer.parseInt(interval[0]);
                    int end = Integer.parseInt(interval[1]);

                    if (canSchedule(schedule, start, end)) {
                        int assigned = schedule[start];
                        result.append(assigned == 1 ? "C" : "J");
                    } else {
                        result.setLength(0);
                        result.append("IMPOSSIBLE");
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %s%n", i, result.toString());
        }
    }

    static boolean canSchedule(int[] schedule, int start, int end) {
        for (int minute = Math.max(0, start); minute <= Math.min(schedule.length - 1, end); minute++) {
            if (schedule[minute] > 1 && minute != start && minute != end) {
                return false;
            }
            schedule[minute]++;
        }
        return true;
    }
}