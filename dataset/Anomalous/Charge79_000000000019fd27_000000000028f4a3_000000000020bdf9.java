import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ParentingPartneringReturns {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            boolean[] cSchedule = new boolean[1440];
            boolean[] jSchedule = new boolean[1440];
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int j = 0; j < n; j++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                boolean cAvailable = isAvailable(cSchedule, start, end);
                boolean jAvailable = isAvailable(jSchedule, start, end);

                if (cAvailable) {
                    schedule.append("C");
                    fillSchedule(cSchedule, start, end);
                } else if (jAvailable) {
                    schedule.append("J");
                    fillSchedule(jSchedule, start, end);
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                results[i] = "IMPOSSIBLE";
            } else {
                results[i] = schedule.toString();
            }
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        reader.close();
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(boolean[] schedule, int start, int end) {
        Arrays.fill(schedule, start, end, true);
    }
}