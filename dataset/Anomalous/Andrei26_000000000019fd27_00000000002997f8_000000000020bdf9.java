import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = scanner.nextInt();
            boolean[] c = new boolean[1441];
            boolean[] j = new boolean[1441];

            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (int ac = 0; ac < activities; ac++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                // Try to assign to C
                if (isAvailable(c, start, end)) {
                    assign(c, start, end);
                    schedule.append("C");
                    assigned = true;
                } 
                // Try to assign to J
                else if (isAvailable(j, start, end)) {
                    assign(j, start, end);
                    schedule.append("J");
                    assigned = true;
                } 

                // If neither C nor J is available
                if (!assigned) {
                    possible = false;
                }
            }

            if (!possible) {
                schedule.setLength(0);
                schedule.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
        }
    }

    private static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time]) {
                return false;
            }
        }
        return true;
    }

    private static void assign(boolean[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = true;
        }
    }
}