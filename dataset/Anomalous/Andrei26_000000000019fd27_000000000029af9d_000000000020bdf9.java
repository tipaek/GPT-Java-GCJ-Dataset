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

                // Try to assign to C
                if (isAvailable(c, activityStart, activityEnd)) {
                    assign(c, activityStart, activityEnd);
                    last.append("C");
                    assigned = true;
                } 
                // Try to assign to J
                if (!assigned && isAvailable(j, activityStart, activityEnd)) {
                    assign(j, activityStart, activityEnd);
                    last.append("J");
                    assigned = true;
                } 
                // If neither C nor J can take the activity
                if (!assigned) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                last.setLength(0);
                last.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + last.toString());
        }
    }

    private static boolean isAvailable(byte[] schedule, int start, int end) {
        for (int x = start; x < end; x++) {
            if (schedule[x] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assign(byte[] schedule, int start, int end) {
        for (int x = start; x < end; x++) {
            schedule[x] = 1;
        }
    }
}