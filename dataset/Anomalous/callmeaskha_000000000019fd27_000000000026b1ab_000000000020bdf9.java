import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            boolean[] cMins = new boolean[24 * 60];
            boolean[] jMins = new boolean[24 * 60];

            int N = Integer.parseInt(br.readLine());
            boolean isImpossible = false;
            StringBuilder resultRow = new StringBuilder();

            for (int curActivity = 0; curActivity < N; curActivity++) {
                String[] activityBoundaries = br.readLine().split(" ");
                int start = Integer.parseInt(activityBoundaries[0]);
                int end = Integer.parseInt(activityBoundaries[1]);

                if (canSchedule(cMins, start, end)) {
                    resultRow.append("C");
                    markSchedule(cMins, start, end);
                } else if (canSchedule(jMins, start, end)) {
                    resultRow.append("J");
                    markSchedule(jMins, start, end);
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + resultRow);
            }
        }
    }

    private static boolean canSchedule(boolean[] mins, int start, int end) {
        for (int i = start; i < end; i++) {
            if (mins[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markSchedule(boolean[] mins, int start, int end) {
        for (int i = start; i < end; i++) {
            mins[i] = true;
        }
    }
}