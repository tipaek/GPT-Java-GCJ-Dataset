import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final int MINUTES_IN_DAY = 1440;
    private static final char PERSON_1 = 'C';
    private static final char PERSON_2 = 'J';

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = sc.nextInt();

        for (int i = 1; i <= numCases; i++) {
            int[] schedule1 = new int[MINUTES_IN_DAY];
            int[] schedule2 = new int[MINUTES_IN_DAY];

            int n = sc.nextInt();
            int[][] events = new int[n][2];

            boolean validInput = true;
            for (int row = 0; row < n; row++) {
                events[row][0] = sc.nextInt();
                events[row][1] = sc.nextInt();
                if (events[row][0] >= MINUTES_IN_DAY || events[row][1] > MINUTES_IN_DAY) {
                    validInput = false;
                }
            }

            String ansString = validInput ? schedule(n - 1, schedule1, schedule2, events) : "IMPOSSIBLE";

            if (ansString.length() > n) {
                ansString = "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + ansString);
        }

        sc.close();
    }

    private static String schedule(int eventsCount, int[] schedule1, int[] schedule2, int[][] events) {
        if (eventsCount < 0) {
            return "";
        } else {
            int start = events[eventsCount][0];
            int end = events[eventsCount][1];

            if (isAvailable(start, end, schedule1)) {
                markSchedule(start, end, schedule1);
                return schedule(eventsCount - 1, schedule1, schedule2, events) + PERSON_1;
            } else if (isAvailable(start, end, schedule2)) {
                markSchedule(start, end, schedule2);
                return schedule(eventsCount - 1, schedule1, schedule2, events) + PERSON_2;
            }
        }

        return "IMPOSSIBLE";
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