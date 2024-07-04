import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] jamieSchedule = new char[1441];
            char[] cameronSchedule = new char[1441];
            for (int i = 0; i < 1441; i++) {
                jamieSchedule[i] = '0';
                cameronSchedule[i] = '0';
            }

            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;
            for (int activity = 0; activity < activities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (isAvailable(jamieSchedule, startTime, endTime)) {
                    result.append("J");
                    fillSchedule(jamieSchedule, startTime, endTime);
                } else if (isAvailable(cameronSchedule, startTime, endTime)) {
                    result.append("C");
                    fillSchedule(cameronSchedule, startTime, endTime);
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }

        scanner.close();
    }

    private static boolean isAvailable(char[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == '1') {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(char[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = '1';
        }
    }
}