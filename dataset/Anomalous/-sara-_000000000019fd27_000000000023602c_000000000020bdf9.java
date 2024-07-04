import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] jamieSchedule = new boolean[1440];
            boolean[] cameronSchedule = new boolean[1440];
            int activities = scanner.nextInt();
            StringBuilder solution = new StringBuilder();

            boolean impossible = false;
            for (int activity = 0; activity < activities; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(jamieSchedule, start, end)) {
                    fillSchedule(jamieSchedule, start, end);
                    solution.append('J');
                } else if (isAvailable(cameronSchedule, start, end)) {
                    fillSchedule(cameronSchedule, start, end);
                    solution.append('C');
                } else {
                    solution = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + solution.toString());
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