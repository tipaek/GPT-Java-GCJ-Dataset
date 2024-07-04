import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activitiesCount = scanner.nextInt();
            char[] schedule = new char[activitiesCount];
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            boolean isImpossible = false;

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(cameronSchedule, start, end)) {
                    markSchedule(cameronSchedule, start, end);
                    schedule[j] = 'C';
                } else if (isAvailable(jamieSchedule, start, end)) {
                    markSchedule(jamieSchedule, start, end);
                    schedule[j] = 'J';
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + i + ": ");
                System.out.println(schedule);
            }
        }

        scanner.close();
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