import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numIntervals = scanner.nextInt();
            int[] startTimes = new int[numIntervals];
            int[] endTimes = new int[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            System.out.println("Case #" + testCase + ": " + findSchedule(startTimes, endTimes));
        }
        scanner.close();
    }

    static String findSchedule(int[] startTimes, int[] endTimes) {
        if (startTimes == null || endTimes == null || startTimes.length != endTimes.length || startTimes.length == 0) {
            return "IMPOSSIBLE";
        }
        if (startTimes.length == 1) {
            return "C";
        }

        int numIntervals = startTimes.length;
        HashMap<Integer, Integer> intervalMap = new HashMap<>();
        for (int i = 0; i < numIntervals; i++) {
            intervalMap.put(endTimes[i], startTimes[i]);
        }
        Arrays.sort(endTimes);
        for (int i = 0; i < numIntervals; i++) {
            startTimes[i] = intervalMap.get(endTimes[i]);
        }

        int[] assignments = new int[numIntervals];
        assignments[0] = 1; // 1 for Cameron, 2 for Jamie
        boolean lastAssignedToCameron = true;

        for (int i = 1; i < numIntervals; i++) {
            if (startTimes[i] < endTimes[i - 1]) {
                boolean overlapsWithCameron = false;
                boolean overlapsWithJamie = false;

                for (int j = i - 1; j >= 0; j--) {
                    if (startTimes[i] >= endTimes[j]) break;

                    if (assignments[j] == 1) overlapsWithCameron = true;
                    if (assignments[j] == 2) overlapsWithJamie = true;

                    if (overlapsWithCameron && overlapsWithJamie) return "IMPOSSIBLE";
                }

                if (overlapsWithCameron && overlapsWithJamie) {
                    return "IMPOSSIBLE";
                } else if (overlapsWithCameron) {
                    assignments[i] = 2;
                    lastAssignedToCameron = false;
                } else if (overlapsWithJamie) {
                    assignments[i] = 1;
                    lastAssignedToCameron = true;
                } else {
                    assignments[i] = assignments[i - 1];
                }
            } else {
                assignments[i] = lastAssignedToCameron ? 1 : 2;
            }
        }

        StringBuilder schedule = new StringBuilder();
        for (int i = 0; i < numIntervals; i++) {
            schedule.append(assignments[i] == 1 ? "C" : "J");
        }
        return schedule.toString();
    }
}