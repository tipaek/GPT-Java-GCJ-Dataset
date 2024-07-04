import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            int[][] cameronSchedule = new int[1002][2];
            int cameronCount = 0;
            int[][] jamieSchedule = new int[1002][2];
            int jamieCount = 0;

            for (int p = 0; p < activities; p++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (impossible) {
                    continue;
                }

                if (canSchedule(cameronSchedule, cameronCount, start, end)) {
                    result.append("C");
                    cameronCount++;
                } else if (canSchedule(jamieSchedule, jamieCount, start, end)) {
                    result.append("J");
                    jamieCount++;
                } else {
                    impossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : result.toString()));
        }
        scanner.close();
    }

    private static boolean canSchedule(int[][] schedule, int count, int start, int end) {
        for (int i = 0; i < count; i++) {
            if ((end > schedule[i][0] && end <= schedule[i][1] + 1) || 
                (start >= schedule[i][0] && start < schedule[i][1] + 1) ||
                (start <= schedule[i][0] && end > schedule[i][1])) {
                return false;
            }
        }
        schedule[count][0] = start;
        schedule[count][1] = end - 1;
        return true;
    }
}