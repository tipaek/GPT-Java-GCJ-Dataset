import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = in.nextInt();
            boolean[] c = new boolean[1441];
            boolean[] j = new boolean[1441];
            StringBuilder result = new StringBuilder();

            for (int ac = 0; ac < activities; ac++) {
                int activityStart = in.nextInt();
                int activityEnd = in.nextInt();
                boolean assigned = false;

                if (isAvailable(c, activityStart, activityEnd)) {
                    assign(c, activityStart, activityEnd);
                    result.append("C");
                    assigned = true;
                } else if (isAvailable(j, activityStart, activityEnd)) {
                    assign(j, activityStart, activityEnd);
                    result.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    // Skip remaining activities for this case
                    for (int skip = ac + 1; skip < activities; skip++) {
                        in.nextInt(); // skip start
                        in.nextInt(); // skip end
                    }
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int t = start; t < end; t++) {
            if (schedule[t]) {
                return false;
            }
        }
        return true;
    }

    private static void assign(boolean[] schedule, int start, int end) {
        for (int t = start; t < end; t++) {
            schedule[t] = true;
        }
    }
}