import java.util.Scanner;

public class Solution {

    private static boolean isTimeSlotAvailable(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            calendar[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int[] cameronCalendar = new int[1440];
            int[] jamieCalendar = new int[1440];
            StringBuilder schedule = new StringBuilder();

            int events = scanner.nextInt();
            boolean possible = true;

            for (int i = 0; i < events; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isTimeSlotAvailable(cameronCalendar, start, end)) {
                    markTimeSlot(cameronCalendar, start, end);
                    schedule.append('C');
                } else if (isTimeSlotAvailable(jamieCalendar, start, end)) {
                    markTimeSlot(jamieCalendar, start, end);
                    schedule.append('J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseIndex);
            } else {
                System.out.printf("Case #%d: %s\n", caseIndex, schedule.toString());
            }
        }

        scanner.close();
    }
}