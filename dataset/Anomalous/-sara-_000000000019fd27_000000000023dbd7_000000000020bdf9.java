import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            boolean[] jamieSchedule = new boolean[1441];
            boolean[] cameronSchedule = new boolean[1441];
            int activitiesCount = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean impossible = false;

            for (int activity = 0; activity < activitiesCount; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jamieSchedule, startTime, endTime)) {
                    assignSchedule(jamieSchedule, startTime, endTime);
                    solution.append('J');
                } else if (isAvailable(cameronSchedule, startTime, endTime)) {
                    assignSchedule(cameronSchedule, startTime, endTime);
                    solution.append('C');
                } else {
                    solution = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + solution.toString());

            if (impossible) {
                // Skip remaining input for this test case
                for (int activity = activitiesCount - solution.length(); activity > 0; activity--) {
                    scanner.nextInt();
                    scanner.nextInt();
                }
            }
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(boolean[] schedule, int startTime, int endTime) {
        for (int i = startTime; i < endTime; i++) {
            schedule[i] = true;
        }
    }
}