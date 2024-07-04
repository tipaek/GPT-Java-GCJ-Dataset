import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int[] cameron = {0, 0};
            int[] jaimie = {0, 0};
            StringBuilder schedule = new StringBuilder();
            int activities = scanner.nextInt();
            scanner.nextLine();

            for (int activity = 0; activity < activities; activity++) {
                String[] timeRange = scanner.nextLine().split(" ");
                int startTime = Integer.parseInt(timeRange[0]);
                int endTime = Integer.parseInt(timeRange[1]);

                if (isAvailable(cameron, startTime, endTime)) {
                    updateSchedule(cameron, startTime, endTime);
                    schedule.append("C");
                } else if (isAvailable(jaimie, startTime, endTime)) {
                    updateSchedule(jaimie, startTime, endTime);
                    schedule.append("J");
                }
            }

            System.out.println("Case #" + caseNum + ": " + schedule.toString());
        }

        scanner.close();
    }

    private static boolean isAvailable(int[] schedule, int startTime, int endTime) {
        return (schedule[0] == 0 && schedule[1] == 0) || schedule[1] <= startTime || schedule[0] >= endTime;
    }

    private static void updateSchedule(int[] schedule, int startTime, int endTime) {
        schedule[0] = startTime;
        schedule[1] = endTime;
    }
}