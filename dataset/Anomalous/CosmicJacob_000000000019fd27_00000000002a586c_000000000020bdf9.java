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
            boolean isValid = true;

            for (int j = 0; j < n; j++) {
                events[j][0] = sc.nextInt();
                events[j][1] = sc.nextInt();
                if (events[j][1] > 1440) {
                    isValid = false;
                }
            }

            String ansString = isValid ? scheduleEvents(n, events) : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + ansString);
        }

        sc.close();
    }

    private static String scheduleEvents(int n, int[][] events) {
        int[] scheduleC = new int[1440];
        int[] scheduleJ = new int[1440];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            if (isAvailable(events[i][0], events[i][1], scheduleC)) {
                markSchedule(events[i][0], events[i][1], scheduleC);
                result[i] = 'C';
            } else if (isAvailable(events[i][0], events[i][1], scheduleJ)) {
                markSchedule(events[i][0], events[i][1], scheduleJ);
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    private static boolean isAvailable(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
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