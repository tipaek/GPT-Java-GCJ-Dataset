import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            boolean[] cSchedule = new boolean[1441];
            boolean[] jSchedule = new boolean[1441];
            StringBuilder schedule = new StringBuilder();
            int activities = Integer.parseInt(scanner.nextLine());
            boolean possible = true;

            for (int j = 0; j < activities; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean cAvailable = isAvailable(cSchedule, start, end);
                boolean jAvailable = isAvailable(jSchedule, start, end);

                if (cAvailable) {
                    schedule.append("C");
                    Arrays.fill(cSchedule, start, end, true);
                } else if (jAvailable) {
                    schedule.append("J");
                    Arrays.fill(jSchedule, start, end, true);
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            results[i] = possible ? schedule.toString() : "IMPOSSIBLE";
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
}