import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activities = scanner.nextInt();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            int[][] cameronSchedule = new int[1002][2];
            int cameronCount = 0;
            int[][] jamieSchedule = new int[1002][2];
            int jamieCount = 0;

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                if (canSchedule(cameronSchedule, cameronCount, start, end)) {
                    schedule.append("C");
                    cameronCount++;
                } else if (canSchedule(jamieSchedule, jamieCount, start, end)) {
                    schedule.append("J");
                    jamieCount++;
                } else {
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + (isImpossible ? "IMPOSSIBLE" : schedule.toString()));
        }

        scanner.close();
    }

    private static boolean canSchedule(int[][] schedule, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if ((end - 1 >= schedule[i][0] && end - 1 <= schedule[i][1]) ||
                (start >= schedule[i][0] && start <= schedule[i][1])) {
                return false;
            }
        }
        schedule[count][0] = start;
        schedule[count][1] = end - 1;
        return true;
    }
}