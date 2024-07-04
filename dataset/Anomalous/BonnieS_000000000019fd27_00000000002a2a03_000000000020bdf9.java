import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (numberOfCases > 0) {
            int numActivities = Integer.parseInt(scanner.next());
            int[] cSchedule = new int[1441];
            int[] jSchedule = new int[1441];
            StringBuilder scheduleOrder = new StringBuilder();

            for (int i = 0; i < numActivities; i++) {
                int startTime = Integer.parseInt(scanner.next());
                int endTime = Integer.parseInt(scanner.next());

                if (scheduleOrder.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                if (isAvailable(startTime, endTime, cSchedule)) {
                    markBusy(startTime, endTime, cSchedule);
                    scheduleOrder.append("C");
                } else if (isAvailable(startTime, endTime, jSchedule)) {
                    markBusy(startTime, endTime, jSchedule);
                    scheduleOrder.append("J");
                } else {
                    scheduleOrder = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + scheduleOrder.toString());
            caseNumber++;
            numberOfCases--;
        }
    }

    private static boolean isAvailable(int startTime, int endTime, int[] schedule) {
        if (startTime == endTime) {
            return schedule[startTime] != 1;
        }
        for (int i = startTime; i < endTime; i++) {
            if (schedule[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int startTime, int endTime, int[] schedule) {
        schedule[startTime] = 3;
        schedule[endTime] = 3;
        for (int i = startTime + 1; i < endTime; i++) {
            schedule[i] = 1;
        }
    }
}