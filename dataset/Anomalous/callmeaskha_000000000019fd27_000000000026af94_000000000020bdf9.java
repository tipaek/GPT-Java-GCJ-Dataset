import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            boolean[] cSchedule = new boolean[24 * 60];
            boolean[] jSchedule = new boolean[24 * 60];

            int activitiesCount = Integer.parseInt(reader.readLine());
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int a = 0; a < activitiesCount; a++) {
                String[] times = reader.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (canSchedule(cSchedule, start, end)) {
                    schedule.append("C");
                    markSchedule(cSchedule, start, end);
                } else if (canSchedule(jSchedule, start, end)) {
                    schedule.append("J");
                    markSchedule(jSchedule, start, end);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + schedule);
            }
        }
    }

    private static boolean canSchedule(boolean[] schedule, int start, int end) {
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