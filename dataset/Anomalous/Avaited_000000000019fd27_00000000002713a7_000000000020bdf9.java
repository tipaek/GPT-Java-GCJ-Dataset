import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            char[] schedule = new char[activities];
            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            boolean impossible = false;

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(cameron, start, end)) {
                    markSchedule(cameron, start, end);
                    schedule[j] = 'C';
                } else if (isAvailable(jamie, start, end)) {
                    markSchedule(jamie, start, end);
                    schedule[j] = 'J';
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + i + ": ");
                System.out.println(schedule);
            }
        }
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            if (schedule[k] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int k = start; k < end; k++) {
            schedule[k] = 1;
        }
    }
}