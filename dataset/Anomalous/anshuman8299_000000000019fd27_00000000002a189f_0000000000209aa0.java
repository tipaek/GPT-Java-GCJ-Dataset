import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private boolean isTimeSlotFree(int[][] schedule, int start, int end) {
        for (int[] slot : schedule) {
            if (slot[0] == 0 && slot[1] == 0) continue;
            if ((slot[0] < start && slot[1] > start) || (slot[0] < end && slot[1] > end) ||
                (start < slot[0] && end > slot[0]) || (start < slot[1] && end > slot[1]) ||
                (slot[0] == start && slot[1] == end)) {
                return false;
            }
        }
        return true;
    }

    private String determineSchedule(int[][] timeSlots) {
        StringBuilder schedule = new StringBuilder();
        int[][] cameronSchedule = new int[timeSlots.length][2];
        int[][] jamieSchedule = new int[timeSlots.length][2];
        int cameronCount = 0;
        int jamieCount = 0;

        for (int[] slot : timeSlots) {
            if (isTimeSlotFree(cameronSchedule, slot[0], slot[1])) {
                schedule.append("C");
                cameronSchedule[cameronCount++] = slot;
            } else if (isTimeSlotFree(jamieSchedule, slot[0], slot[1])) {
                schedule.append("J");
                jamieSchedule[jamieCount++] = slot;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numberOfSlots = scanner.nextInt();
            int[][] timeSlots = new int[numberOfSlots][2];

            for (int j = 0; j < numberOfSlots; j++) {
                timeSlots[j][0] = scanner.nextInt();
                timeSlots[j][1] = scanner.nextInt();
            }

            String schedule = solution.determineSchedule(timeSlots);
            System.out.println("Case #" + i + ": " + schedule);
        }
    }
}