import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            int[][] cameronSchedule = new int[activities][2];
            int[][] jamieSchedule = new int[activities][2];
            StringBuilder schedule = new StringBuilder();

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(cameronSchedule, start, end)) {
                    schedule.append('C');
                    assignSchedule(cameronSchedule, j, start, end);
                } else if (isAvailable(jamieSchedule, start, end)) {
                    schedule.append('J');
                    assignSchedule(jamieSchedule, j, start, end);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + i + ": " + schedule);
        }
    }

    private static void assignSchedule(int[][] schedule, int index, int start, int end) {
        schedule[index][0] = start;
        schedule[index][1] = end;
    }

    private static boolean isAvailable(int[][] schedule, int start, int end) {
        for (int[] timeSlot : schedule) {
            int scheduledStart = timeSlot[0];
            int scheduledEnd = timeSlot[1];
            if (start < scheduledEnd && end > scheduledStart) {
                return false;
            }
        }
        return true;
    }
}