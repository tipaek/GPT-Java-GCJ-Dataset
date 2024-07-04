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
            for (int j = 0; j < n; j++) {
                events[j][0] = sc.nextInt();
                events[j][1] = sc.nextInt();
            }

            String result = findSchedule(n, events);
            System.out.println("Case #" + i + ": " + result);
        }

        sc.close();
    }

    private static String findSchedule(int n, int[][] events) {
        int[] scheduleC = new int[1440];
        int[] scheduleJ = new int[1440];
        char[] assigned = new char[n];

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int end = events[i][1];

            if (isAvailable(scheduleC, start, end)) {
                markSchedule(scheduleC, start, end);
                assigned[i] = 'C';
            } else if (isAvailable(scheduleJ, start, end)) {
                markSchedule(scheduleJ, start, end);
                assigned[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assigned);
    }

    private static boolean isAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
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