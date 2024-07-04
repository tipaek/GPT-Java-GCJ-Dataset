import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (numCases > 0) {
            int numIntervals = Integer.parseInt(scanner.next());
            boolean[] cameronSchedule = new boolean[1441];
            boolean[] jamieSchedule = new boolean[1441];
            StringBuilder scheduleOrder = new StringBuilder();

            while (numIntervals > 0) {
                int startTime = Integer.parseInt(scanner.next());
                int endTime = Integer.parseInt(scanner.next());

                if (scheduleOrder.toString().equals("IMPOSSIBLE")) {
                    // Do nothing, already impossible
                } else if (isAvailable(startTime, endTime, cameronSchedule)) {
                    markBusy(startTime, endTime, cameronSchedule);
                    scheduleOrder.append("C");
                } else if (isAvailable(startTime, endTime, jamieSchedule)) {
                    markBusy(startTime, endTime, jamieSchedule);
                    scheduleOrder.append("J");
                } else {
                    scheduleOrder = new StringBuilder("IMPOSSIBLE");
                }

                numIntervals--;
            }

            System.out.println("Case #" + caseNumber + ": " + scheduleOrder.toString());
            caseNumber++;
            numCases--;
        }
    }

    private static boolean isAvailable(int startTime, int endTime, boolean[] schedule) {
        for (int time = startTime; time < endTime; time++) {
            if (schedule[time]) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int startTime, int endTime, boolean[] schedule) {
        for (int time = startTime; time < endTime; time++) {
            schedule[time] = true;
        }
    }
}