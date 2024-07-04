import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int activities = scanner.nextInt();
            boolean impossible = false;
            StringBuilder result = new StringBuilder();
            int[][] cameron = new int[1002][2];
            int cameronCount = 0;
            int[][] jamie = new int[1002][2];
            int jamieCount = 0;

            for (int p = 0; p < activities; p++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (impossible) {
                    continue;
                }

                if (canSchedule(cameron, cameronCount, start, end)) {
                    result.append("C");
                    cameronCount++;
                } else if (canSchedule(jamie, jamieCount, start, end)) {
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
            if (!(start >= schedule[i][1] || end <= schedule[i][0])) {
                return false;
            }
        }
        schedule[count][0] = start;
        schedule[count][1] = end;
        return true;
    }
}