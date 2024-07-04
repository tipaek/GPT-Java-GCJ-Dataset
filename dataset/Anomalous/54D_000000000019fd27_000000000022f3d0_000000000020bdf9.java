import java.util.Scanner;

public class Solution {

    static boolean isTimeSlotAvailable(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            if (calendar[i] == 1) {
                return false;
            }
        }
        return true;
    }

    static void markTimeSlot(int[] calendar, int start, int end) {
        for (int i = start; i < end; i++) {
            calendar[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int[] cameronCalendar = new int[1440];
            int[] jamieCalendar = new int[1440];
            StringBuilder scheduleOrder = new StringBuilder();
            boolean isImpossible = false;
            int events = scanner.nextInt();

            for (int event = 0; event < events; event++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!isImpossible) {
                    if (isTimeSlotAvailable(cameronCalendar, start, end)) {
                        markTimeSlot(cameronCalendar, start, end);
                        scheduleOrder.append("C");
                    } else if (isTimeSlotAvailable(jamieCalendar, start, end)) {
                        markTimeSlot(jamieCalendar, start, end);
                        scheduleOrder.append("J");
                    } else {
                        scheduleOrder = new StringBuilder("IMPOSSIBLE");
                        isImpossible = true;
                    }
                }
            }
            System.out.printf("Case #%d: %s\n", caseNumber, scheduleOrder.toString());
        }

        scanner.close();
    }
}