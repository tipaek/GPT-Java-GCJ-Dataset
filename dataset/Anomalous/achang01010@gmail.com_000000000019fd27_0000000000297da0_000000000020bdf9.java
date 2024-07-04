import java.util.Scanner;

public class Solution {
    private static final int MINUTES_IN_DAY = 1440;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int shifts = scanner.nextInt();
            boolean[] cameronSchedule = new boolean[MINUTES_IN_DAY];
            boolean[] jamieSchedule = new boolean[MINUTES_IN_DAY];
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int shiftIndex = 0; shiftIndex < shifts; shiftIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (canSchedule(cameronSchedule, start, end)) {
                    fillSchedule(cameronSchedule, start, end);
                    result.append("C");
                } else if (canSchedule(jamieSchedule, start, end)) {
                    fillSchedule(jamieSchedule, start, end);
                    result.append("J");
                } else {
                    isImpossible = true;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + caseIndex + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseIndex + ": " + result);
            }
        }
    }

    private static boolean canSchedule(boolean[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time]) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(boolean[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = true;
        }
    }
}