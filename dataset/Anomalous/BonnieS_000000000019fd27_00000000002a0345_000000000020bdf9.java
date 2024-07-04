import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class ParentingPartnering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (testCases-- > 0) {
            int activities = Integer.parseInt(scanner.next());
            boolean[] cSchedule = new boolean[1441];
            boolean[] jSchedule = new boolean[1441];
            StringBuilder result = new StringBuilder();

            while (activities-- > 0) {
                int startTime = Integer.parseInt(scanner.next());
                int endTime = Integer.parseInt(scanner.next());

                if (result.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                if (isAvailable(startTime, endTime, cSchedule)) {
                    markBusy(startTime, endTime, cSchedule);
                    result.append("C");
                } else if (isAvailable(startTime, endTime, jSchedule)) {
                    markBusy(startTime, endTime, jSchedule);
                    result.append("J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }

    private static boolean isAvailable(int start, int end, boolean[] schedule) {
        for (int time = start; time < end; time++) {
            if (schedule[time]) {
                return false;
            }
        }
        return true;
    }

    private static void markBusy(int start, int end, boolean[] schedule) {
        for (int time = start; time < end; time++) {
            schedule[time] = true;
        }
    }
}