import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            boolean[] jamieSchedule = new boolean[1441];
            boolean[] cameronSchedule = new boolean[1441];
            int activities = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean possible = true;

            for (int activity = 0; activity < activities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jamieSchedule, startTime, endTime)) {
                    fillSchedule(jamieSchedule, startTime, endTime);
                    solution.append("J");
                } else if (isAvailable(cameronSchedule, startTime, endTime)) {
                    fillSchedule(cameronSchedule, startTime, endTime);
                    solution.append("C");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                solution = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + caseNum + ": " + solution);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}