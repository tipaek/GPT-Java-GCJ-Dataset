import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = in.nextInt();
            byte[] c = new byte[1441];
            byte[] j = new byte[1441];

            StringBuilder schedule = new StringBuilder();
            boolean impossible = false;

            for (int ac = 0; ac < activities; ac++) {
                int activityStart = in.nextInt();
                int activityEnd = in.nextInt();
                boolean assigned = false;

                // Try to assign to 'C'
                if (!impossible && canAssign(c, activityStart, activityEnd)) {
                    assign(c, activityStart, activityEnd);
                    schedule.append("C");
                    assigned = true;
                }

                // If not assigned to 'C', try to assign to 'J'
                if (!assigned && !impossible) {
                    if (canAssign(j, activityStart, activityEnd)) {
                        assign(j, activityStart, activityEnd);
                        schedule.append("J");
                    } else {
                        schedule.append("IMPOSSIBLE");
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                schedule.setLength(0);
                schedule.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }

    // Helper method to check if we can assign the activity to a given person's schedule
    private static boolean canAssign(byte[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    // Helper method to assign the activity to a given person's schedule
    private static void assign(byte[] schedule, int start, int end) {
        for (int i = start; i <= end; i++) {
            schedule[i] = 1;
        }
    }
}