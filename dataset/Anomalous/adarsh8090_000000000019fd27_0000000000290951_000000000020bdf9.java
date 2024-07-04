import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
            }

            String result = assignTasks(n, startTimes, endTimes);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(int n, int[] startTimes, int[] endTimes) {
        int currentCameronEnd = 0, currentJamieEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (int j = 0; j < n; j++) {
            int start = startTimes[j];
            int end = endTimes[j];

            if (start >= currentCameronEnd) {
                currentCameronEnd = end;
                schedule.append("C");
            } else if (start >= currentJamieEnd) {
                currentJamieEnd = end;
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}