import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int N = scanner.nextInt();
            int[][] day = new int[24 * 60][2];
            StringBuilder order = new StringBuilder();
            boolean possible = true;

            for (int i = 0; i < N; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (possible) {
                    if (!scheduleJob(day, start, end, i + 1, order)) {
                        possible = false;
                    }
                }
            }

            printResult(t + 1, possible ? order.toString() : "IMPOSSIBLE");
        }
        scanner.close();
    }

    private static boolean scheduleJob(int[][] day, int start, int end, int jobId, StringBuilder order) {
        if (canSchedule(day, start, end, 0)) {
            order.append("C");
            fillSchedule(day, start, end, 0, jobId);
            return true;
        }

        if (canSchedule(day, start, end, 1)) {
            order.append("J");
            fillSchedule(day, start, end, 1, jobId);
            return true;
        }

        return false;
    }

    private static boolean canSchedule(int[][] day, int start, int end, int person) {
        for (int j = start; j < end; j++) {
            if (day[j][person] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[][] day, int start, int end, int person, int jobId) {
        for (int j = start; j < end; j++) {
            day[j][person] = jobId;
        }
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}