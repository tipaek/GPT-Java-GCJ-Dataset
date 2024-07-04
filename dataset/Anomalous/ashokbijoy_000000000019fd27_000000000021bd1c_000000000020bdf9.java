import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            System.out.println("Case #" + t + ": " + findSchedule(startTimes, endTimes));
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
        
        int n = startTimes.length;
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            timeMap.put(endTimes[i], startTimes[i]);
        }
        Arrays.sort(endTimes);
        for (int i = 0; i < n; i++) {
            startTimes[i] = timeMap.get(endTimes[i]);
        }

        int[] assignments = new int[n];
        assignments[0] = 1;
        boolean lastAssignedC = true;

        for (int i = 1; i < n; i++) {
            if (startTimes[i] < endTimes[i - 1]) {
                boolean overlapsWithC = false, overlapsWithJ = false;

                for (int j = i - 1; j >= 0; j--) {
                    if (startTimes[i] >= endTimes[j]) break;
                    if (assignments[j] == 1) overlapsWithC = true;
                    if (assignments[j] == 2) overlapsWithJ = true;
                    if (overlapsWithC && overlapsWithJ) return "IMPOSSIBLE";
                }

                if (overlapsWithC) {
                    assignments[i] = 2;
                    lastAssignedC = false;
                } else if (overlapsWithJ) {
                    assignments[i] = 1;
                    lastAssignedC = true;
                } else {
                    assignments[i] = assignments[i - 1];
                }
            } else {
                assignments[i] = lastAssignedC ? 1 : 2;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int assignment : assignments) {
            result.append(assignment == 1 ? "C" : "J");
        }
        return result.toString();
    }
}