import java.io.IOException;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        processCases();
    }

    static void processCases() {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine().trim());
            int[] schedule = new int[1441];
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(timeRange[0]);
                int endTime = Integer.parseInt(timeRange[1]);

                if (!impossible && canScheduleActivity(schedule, startTime, endTime)) {
                    int assignedPerson = schedule[startTime];
                    result.append(assignedPerson == 1 ? "C" : "J");
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
    }

    static boolean canScheduleActivity(int[] schedule, int start, int end) {
        for (int i = Math.max(0, start); i <= Math.min(schedule.length - 1, end); i++) {
            if (schedule[i] > 1 && i != start && i != end) {
                return false;
            }
            schedule[i]++;
        }
        return true;
    }
}