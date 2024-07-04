import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int activities = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[activities];
            int[] endTimes = new int[activities];

            for (int j = 0; j < activities; j++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[j] = Integer.parseInt(times[0]);
                endTimes[j] = Integer.parseInt(times[1]);
            }

            String result = assignActivities(startTimes, endTimes);
            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }

    public static String assignActivities(int[] startTimes, int[] endTimes) {
        int numActivities = startTimes.length;
        char[] assignments = new char[numActivities];
        Arrays.fill(assignments, 'X');
        boolean isJFree = true;
        boolean isCFree = true;

        for (int currentTime = 0; currentTime <= 24 * 60; currentTime++) {
            for (int i = 0; i < numActivities; i++) {
                if (currentTime == endTimes[i]) {
                    if (assignments[i] == 'J') {
                        isJFree = true;
                    } else if (assignments[i] == 'C') {
                        isCFree = true;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }

            for (int i = 0; i < numActivities; i++) {
                if (currentTime == startTimes[i]) {
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
            }
        }

        for (char c : assignments) {
            if (c == 'X') {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}