import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; ++t) {
            int activities = scanner.nextInt();
            StringBuilder schedule = new StringBuilder();
            int[] timeSlots = new int[24 * 60];
            Arrays.fill(timeSlots, -1);

            boolean isPossible = true;

            for (int a = 0; a < activities; a++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int freePerson = -1;

                for (int minute = start; minute < end; minute++) {
                    if (timeSlots[minute] == 1) {
                        freePerson = 1;
                    } else if (timeSlots[minute] == 0) {
                        freePerson = 0;
                    } else if (timeSlots[minute] == 2) {
                        freePerson = 2;
                    }
                }

                if (freePerson == -1 || freePerson == 0) {
                    schedule.append('C');
                    updateSchedule(timeSlots, start, end, 2);
                } else if (freePerson == 1) {
                    schedule.append('J');
                    updateSchedule(timeSlots, start, end, 1);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            System.out.println("Case #" + t + ": " + schedule);
        }
    }

    private static void updateSchedule(int[] timeSlots, int start, int end, int person) {
        for (int minute = start; minute < end; minute++) {
            timeSlots[minute] = person;
        }
    }
}