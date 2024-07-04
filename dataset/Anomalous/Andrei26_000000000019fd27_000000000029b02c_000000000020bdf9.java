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

            StringBuilder last = new StringBuilder();
            boolean possible = true;

            for (int ac = 0; ac < activities; ac++) {
                int activityStart = in.nextInt();
                int activityEnd = in.nextInt();
                boolean assigned = false;

                if (possible && canAssign(c, activityStart, activityEnd)) {
                    assign(c, activityStart, activityEnd);
                    last.append("C");
                    assigned = true;
                }

                if (!assigned && possible && canAssign(j, activityStart, activityEnd)) {
                    assign(j, activityStart, activityEnd);
                    last.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    possible = false;
                    last.setLength(0);
                    last.append("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + last.toString());
        }
    }

    private static boolean canAssign(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assign(byte[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }
}