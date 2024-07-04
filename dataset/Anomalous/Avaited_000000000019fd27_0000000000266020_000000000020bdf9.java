import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numActivities = scanner.nextInt();
            char[] schedule = new char[numActivities];
            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            boolean impossible = false;

            for (int activityIndex = 0; activityIndex < numActivities; activityIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(cameron, start, end)) {
                    fillSchedule(cameron, start, end);
                    schedule[activityIndex] = 'C';
                } else if (isAvailable(jamie, start, end)) {
                    fillSchedule(jamie, start, end);
                    schedule[activityIndex] = 'J';
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + caseNumber + ": ");
                System.out.println(new String(schedule));
            }
        }

        scanner.close();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
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