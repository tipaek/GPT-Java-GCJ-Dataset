import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();

            for (int testCase = 1; testCase <= testCases; testCase++) {
                int N = scanner.nextInt();
                int[][] day = new int[24 * 60][2];
                StringBuilder schedule = new StringBuilder();
                boolean isPossible = true;

                for (int i = 0; i < N; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    if (!assignJob(day, start, end, i + 1, schedule)) {
                        isPossible = false;
                        break;
                    }
                }

                printResult(testCase, isPossible ? schedule.toString() : "IMPOSSIBLE");
            }
        }
    }

    private static boolean assignJob(int[][] day, int start, int end, int jobId, StringBuilder schedule) {
        if (canAssign(day, start, end, 0)) {
            schedule.append("C");
            markDay(day, start, end, 0, jobId);
            return true;
        } else if (canAssign(day, start, end, 1)) {
            schedule.append("J");
            markDay(day, start, end, 1, jobId);
            return true;
        }
        return false;
    }

    private static boolean canAssign(int[][] day, int start, int end, int person) {
        for (int time = start; time < end; time++) {
            if (day[time][person] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markDay(int[][] day, int start, int end, int person, int jobId) {
        for (int time = start; time < end; time++) {
            day[time][person] = jobId;
        }
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}