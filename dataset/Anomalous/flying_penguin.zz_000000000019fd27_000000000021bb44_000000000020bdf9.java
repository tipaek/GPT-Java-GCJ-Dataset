import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activities = scanner.nextInt();
            boolean[] cSchedule = new boolean[24 * 60 + 1];
            boolean[] jSchedule = new boolean[24 * 60 + 1];

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

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
                result = new StringBuilder("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result);
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