
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int activities = scanner.nextInt();
            boolean[] J = new boolean[24 * 60 + 1];
            boolean[] C = new boolean[24 * 60 + 1];
            StringBuilder schedule = new StringBuilder();
            for (int activityIndex = 0; activityIndex < activities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                    if (isAvailable(J, start, end)) {
                        schedule.append("J");
                        bookAppointment(J, start, end);
                    } else if (isAvailable(C, start, end)) {
                        schedule.append("C");
                        bookAppointment(C, start, end);
                    } else schedule = new StringBuilder("IMPOSSIBLE");

            }
            System.out.println(String.format("Case #%s: %s", caseIndex, schedule.toString()));
        }
    }

    public static boolean isAvailable(boolean[] schedule, int from, int to) {
        for (int i = from+1; i <= to-1; i++) {
            if (schedule[i])
                return false;
        }
        return true;
    }

    public static void bookAppointment(boolean[] schedule, int from, int to) {
        for (int i = from; i <= to; i++) {
            schedule[i] = true;
        }
    }
}