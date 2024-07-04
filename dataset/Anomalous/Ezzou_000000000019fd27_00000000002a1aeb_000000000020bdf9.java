import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        runAlgorithm();
    }

    static void runAlgorithm() {
        Scanner scanner = new Scanner("4\n" +
                "3\n" +
                "360 480\n" +
                "420 540\n" +
                "600 660\n" +
                "3\n" +
                "0 1440\n" +
                "1 3\n" +
                "2 4\n" +
                "5\n" +
                "99 150\n" +
                "1 100\n" +
                "100 301\n" +
                "2 5\n" +
                "150 250\n" +
                "2\n" +
                "0 720\n" +
                "720 1440");
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int numActivities = Integer.parseInt(scanner.nextLine().trim());
            int[] schedule = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int j = 0; j < numActivities; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (!impossible && canSchedule(schedule, start, end)) {
                    int assignedPerson = schedule[start];
                    result.append(assignedPerson == 1 ? "C" : "J");
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", i, result.toString());
        }
    }

    static boolean canSchedule(int[] schedule, int start, int end) {
        for (int i = Math.max(0, start); i <= Math.min(schedule.length - 1, end); i++) {
            if (schedule[i] > 1 && i != start && i != end) {
                return false;
            }
            schedule[i]++;
        }
        return true;
    }
}