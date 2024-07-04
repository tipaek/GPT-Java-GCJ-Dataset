import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int n = scanner.nextInt();
            String result = assignTasks(n, scanner);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }

    private static String assignTasks(int n, Scanner scanner) {
        StringBuilder solution = new StringBuilder();
        boolean[] jamie = new boolean[1441];
        boolean[] cameron = new boolean[1441];

        for (int j = 0; j < n; j++) {
            int beginTime = scanner.nextInt();
            int endTime = scanner.nextInt();

            if (isAvailable(jamie, beginTime, endTime)) {
                markBusy(jamie, beginTime, endTime);
                solution.append("J");
            } else if (isAvailable(cameron, beginTime, endTime)) {
                markBusy(cameron, beginTime, endTime);
                solution.append("C");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return solution.toString();
    }

    private static boolean isAvailable(boolean[] schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            if (schedule[k]) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(boolean[] schedule, int beginTime, int endTime) {
        for (int k = beginTime; k < endTime; k++) {
            schedule[k] = true;
        }
    }
}