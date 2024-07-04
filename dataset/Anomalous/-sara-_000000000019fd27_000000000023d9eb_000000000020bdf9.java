import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            StringBuilder jamieSchedule = new StringBuilder("0".repeat(1441));
            StringBuilder cameronSchedule = new StringBuilder("0".repeat(1441));
            StringBuilder result = new StringBuilder();

            boolean possible = true;

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(jamieSchedule, start, end)) {
                    assignTask(jamieSchedule, start, end);
                    result.append("J");
                } else if (isAvailable(cameronSchedule, start, end)) {
                    assignTask(cameronSchedule, start, end);
                    result.append("C");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }

        scanner.close();
    }

    private static boolean isAvailable(StringBuilder schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule.charAt(i) == '1') {
                return false;
            }
        }
        return true;
    }

    private static void assignTask(StringBuilder schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule.setCharAt(i, '1');
        }
    }
}