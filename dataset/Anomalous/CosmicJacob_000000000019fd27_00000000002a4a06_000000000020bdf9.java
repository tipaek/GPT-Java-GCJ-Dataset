import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int n = sc.nextInt();
            int[][] events = new int[n][2];

            for (int row = 0; row < n; row++) {
                events[row][0] = sc.nextInt();
                events[row][1] = sc.nextInt();
            }

            String result = scheduleEvents(n, events);
            System.out.println("Case #" + i + ": " + result);
        }

        sc.close();
    }

    private static String scheduleEvents(int n, int[][] events) {
        int[] scheduleC = new int[1440];
        int[] scheduleJ = new int[1440];
        StringBuilder assignment = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int end = events[i][1];

            if (isAvailable(scheduleC, start, end)) {
                markSchedule(scheduleC, start, end);
                assignment.append('C');
            } else if (isAvailable(scheduleJ, start, end)) {
                markSchedule(scheduleJ, start, end);
                assignment.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }

        return assignment.toString();
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}