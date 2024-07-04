import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] cSchedule = new boolean[24 * 60];
            boolean[] jSchedule = new boolean[24 * 60];

            int activities = Integer.parseInt(br.readLine());
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < activities; i++) {
                String[] times = br.readLine().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                if (canAssign(cSchedule, start, end)) {
                    assignSchedule(cSchedule, start, end);
                    result.append("C");
                } else if (canAssign(jSchedule, start, end)) {
                    assignSchedule(jSchedule, start, end);
                    result.append("J");
                } else {
                    impossible = true;
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }

    private static boolean canAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}