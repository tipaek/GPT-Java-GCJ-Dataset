import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = scanner.nextInt();
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            int[][] cameronActivities = new int[1002][2];
            int cameronCount = 0;
            int[][] jamieActivities = new int[1002][2];
            int jamieCount = 0;

            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (impossible) {
                    continue;
                }

                if (canScheduleActivity(cameronActivities, cameronCount, start, end)) {
                    result.append("C");
                    cameronCount++;
                } else if (canScheduleActivity(jamieActivities, jamieCount, start, end)) {
                    result.append("J");
                    jamieCount++;
                } else {
                    impossible = true;
                }
            }

            System.out.println("Case #" + testCase + ": " + (impossible ? "IMPOSSIBLE" : result.toString()));
        }

        scanner.close();
    }

    private static boolean canScheduleActivity(int[][] schedule, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if ((end - 1 >= schedule[i][0] && end - 1 <= schedule[i][1]) ||
                (start >= schedule[i][0] && start <= schedule[i][1]) ||
                (start <= schedule[i][0] && end - 1 >= schedule[i][1])) {
                return false;
            }
        }

        schedule[count][0] = start;
        schedule[count][1] = end - 1;
        return true;
    }
}