import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];

        for (int i = 0; i < numCases; i++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            boolean[] cBusy = new boolean[1441];
            boolean[] jBusy = new boolean[1441];
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < numActivities; j++) {
                String[] times = scanner.nextLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean cAvailable = isAvailable(cBusy, start, end);
                boolean jAvailable = isAvailable(jBusy, start, end);

                if (cAvailable) {
                    schedule.append("C");
                    Arrays.fill(cBusy, start, end, true);
                } else if (jAvailable) {
                    schedule.append("J");
                    Arrays.fill(jBusy, start, end, true);
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            results[i] = schedule.toString();
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }

    private static boolean isAvailable(boolean[] busyTimes, int start, int end) {
        for (int i = start; i < end; i++) {
            if (busyTimes[i]) {
                return false;
            }
        }
        return true;
    }
}