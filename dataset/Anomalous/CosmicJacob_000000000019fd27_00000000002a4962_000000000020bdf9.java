import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int[] schedule1 = new int[1440];
            int[] schedule2 = new int[1440];
            int n = sc.nextInt();
            int[][] events = new int[n][2];

            for (int row = 0; row < n; row++) {
                events[row][0] = sc.nextInt();
                events[row][1] = sc.nextInt();
            }

            String ansString = schedule(n - 1, schedule1, schedule2, events, 'C', 'J');

            if (ansString.length() > n) {
                ansString = "IMPOSSIBLE";
            }
            System.out.println("Case #" + i + ": " + ansString);
        }

        sc.close();
    }

    private static String schedule(int eventsCount, int[] schedule1, int[] schedule2, int[][] events, char p1, char p2) {
        if (eventsCount < 0) {
            return "";
        }

        if (isTimeSlotAvailable(events[eventsCount][0], events[eventsCount][1], schedule1)) {
            markTimeSlot(events[eventsCount][0], events[eventsCount][1], schedule1);
            return p1 + schedule(eventsCount - 1, schedule1, schedule2, events, p1, p2);
        } else if (isTimeSlotAvailable(events[eventsCount][0], events[eventsCount][1], schedule2)) {
            markTimeSlot(events[eventsCount][0], events[eventsCount][1], schedule2);
            return p2 + schedule(eventsCount - 1, schedule1, schedule2, events, p1, p2);
        }

        return "IMPOSSIBLE";
    }

    private static boolean isTimeSlotAvailable(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markTimeSlot(int start, int end, int[] schedule) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}