import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activities = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[activities];
            int[] endTimes = new int[activities];

            for (int activity = 0; activity < activities; activity++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[activity] = Integer.parseInt(times[0]);
                endTimes[activity] = Integer.parseInt(times[1]);
            }

            String result = scheduleActivities(startTimes, endTimes);
            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }

    public static String scheduleActivities(int[] startTimes, int[] endTimes) {
        int n = startTimes.length;
        char[] assignments = new char[n];
        Arrays.fill(assignments, 'X');
        boolean isJFree = true;
        boolean isCFree = true;

        for (int time = 0; time <= 24 * 60; time++) {
            for (int i = 0; i < n; i++) {
                if (time == startTimes[i]) {
                    if (isJFree) {
                        assignments[i] = 'J';
                        isJFree = false;
                    } else if (isCFree) {
                        assignments[i] = 'C';
                        isCFree = false;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
                if (time == endTimes[i]) {
                    if (assignments[i] == 'J') {
                        isJFree = true;
                    } else if (assignments[i] == 'C') {
                        isCFree = true;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }
        }

        for (char assignment : assignments) {
            if (assignment == 'X') {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}