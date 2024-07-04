import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activitiesCount = scanner.nextInt();
            byte[] cSchedule = new byte[1441];
            byte[] jSchedule = new byte[1441];

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int activity = 0; activity < activitiesCount; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;

                if (!impossible) {
                    if (canAssign(cSchedule, start, end)) {
                        assignSchedule(cSchedule, start, end);
                        result.append('C');
                        assigned = true;
                    } else if (canAssign(jSchedule, start, end)) {
                        assignSchedule(jSchedule, start, end);
                        result.append('J');
                        assigned = true;
                    } else {
                        impossible = true;
                    }
                }

                if (impossible) {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static boolean canAssign(byte[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assignSchedule(byte[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
    }
}