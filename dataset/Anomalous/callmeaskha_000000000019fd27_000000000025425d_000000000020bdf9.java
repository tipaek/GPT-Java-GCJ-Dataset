import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            boolean[] cSchedule = new boolean[24 * 60];
            boolean[] jSchedule = new boolean[24 * 60];
            int activities = Integer.parseInt(reader.readLine());

            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                String[] timeBounds = reader.readLine().split(" ");
                int start = Integer.parseInt(timeBounds[0]);
                int end = Integer.parseInt(timeBounds[1]);

                if (isAvailable(cSchedule, start, end)) {
                    schedule.append("C");
                    markSchedule(cSchedule, start, end);
                } else if (isAvailable(jSchedule, start, end)) {
                    schedule.append("J");
                    markSchedule(jSchedule, start, end);
                } else {
                    possible = false;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + schedule);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}