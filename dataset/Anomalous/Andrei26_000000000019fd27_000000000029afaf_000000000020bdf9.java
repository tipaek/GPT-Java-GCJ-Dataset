import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            byte[] cSchedule = new byte[1441];
            byte[] jSchedule = new byte[1441];

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (int activity = 0; activity < activityCount; activity++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (!assignActivity(cSchedule, start, end)) {
                    if (!assignActivity(jSchedule, start, end)) {
                        result.append("IMPOSSIBLE");
                        impossible = true;
                        break;
                    } else {
                        result.append("J");
                    }
                } else {
                    result.append("C");
                }
            }

            if (impossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static boolean assignActivity(byte[] schedule, int start, int end) {
        for (int time = start; time < end; time++) {
            if (schedule[time] == 1) {
                return false;
            }
        }
        for (int time = start; time < end; time++) {
            schedule[time] = 1;
        }
        return true;
    }
}