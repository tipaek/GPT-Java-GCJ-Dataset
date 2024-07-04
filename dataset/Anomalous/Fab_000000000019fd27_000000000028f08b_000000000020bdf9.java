import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numSchedules = Integer.parseInt(scanner.nextLine());

            int[] cameronSchedule = new int[60 * 24];
            int[] jamieSchedule = new int[60 * 24];
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;

            for (int scheduleIndex = 0; scheduleIndex < numSchedules; scheduleIndex++) {
                String[] times = scanner.nextLine().trim().split(" ");
                int startTime = Integer.parseInt(times[0]);
                int endTime = Integer.parseInt(times[1]);

                if (isScheduleAvailable(cameronSchedule, startTime, endTime)) {
                    fillSchedule(cameronSchedule, startTime, endTime);
                    result.append("C");
                } else if (isScheduleAvailable(jamieSchedule, startTime, endTime)) {
                    fillSchedule(jamieSchedule, startTime, endTime);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        scanner.close();
    }

    private static boolean isScheduleAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}