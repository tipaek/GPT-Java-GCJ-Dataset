import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (testCases > 0) {
            int activities = Integer.parseInt(scanner.next());
            int[] cSchedule = new int[1440];
            int[] jSchedule = new int[1440];
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;
            for (int i = 0; i < activities; i++) {
                int startTime = Integer.parseInt(scanner.next());
                int endTime = Integer.parseInt(scanner.next());

                if (!possible) {
                    continue;
                }

                if (isAvailable(startTime, endTime, cSchedule)) {
                    markSchedule(startTime, endTime, cSchedule);
                    schedule.append("C");
                } else if (isAvailable(startTime, endTime, jSchedule)) {
                    markSchedule(startTime, endTime, jSchedule);
                    schedule.append("J");
                } else {
                    possible = false;
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            caseNumber++;
            testCases--;
        }
    }

    private static boolean isAvailable(int startTime, int endTime, int[] schedule) {
        for (int i = startTime; i < endTime; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(int startTime, int endTime, int[] schedule) {
        for (int i = startTime; i < endTime; i++) {
            schedule[i] = 1;
        }
    }
}