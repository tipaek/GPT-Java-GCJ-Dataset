import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int[] scheduleC = new int[1440];
            int[] scheduleJ = new int[1440];

            int n = sc.nextInt();
            int[][] events = new int[n][2];

            for (int row = 0; row < n; row++) {
                events[row][0] = sc.nextInt();
                events[row][1] = sc.nextInt();
            }

            String result = scheduleEvents(n, scheduleC, scheduleJ, events);

            if (result.length() != n) {
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + result);
        }

        sc.close();
    }

    private static String scheduleEvents(int n, int[] scheduleC, int[] scheduleJ, int[][] events) {
        StringBuilder result = new StringBuilder();
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int end = events[i][1];

            if (isAvailable(start, end, scheduleC)) {
                markSchedule(start, end, scheduleC);
                result.append('C');
            } else if (isAvailable(start, end, scheduleJ)) {
                markSchedule(start, end, scheduleJ);
                result.append('J');
            } else {
                possible = false;
                break;
            }
        }

        return possible ? result.toString() : "IMPOSSIBLE";
    }

    private static boolean isAvailable(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}