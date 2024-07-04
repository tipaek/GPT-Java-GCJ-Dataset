import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                int[] startTimes = new int[N];
                int[] endTimes = new int[N];

                for (int i = 0; i < N; i++) {
                    startTimes[i] = sc.nextInt();
                    endTimes[i] = sc.nextInt();
                }
                System.out.println("Case #" + test_case + ": " + findSchedule(startTimes, endTimes));
            }
        }
    }

    static String findSchedule(int[] startTimes, int[] endTimes) {
        if (startTimes == null || endTimes == null || startTimes.length != endTimes.length || startTimes.length == 0) {
            return "IMPOSSIBLE";
        }

        int N = startTimes.length;

        // Create a map to associate end times with start times
        HashMap<Integer, Integer> timeMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            timeMap.put(endTimes[i], startTimes[i]);
        }

        // Sort end times and rearrange start times accordingly
        Arrays.sort(endTimes);
        for (int i = 0; i < N; i++) {
            startTimes[i] = timeMap.get(endTimes[i]);
        }

        StringBuilder schedule = new StringBuilder();
        schedule.append("C");
        boolean isPreviousC = true;

        if (N == 1) {
            return schedule.toString();
        }

        for (int i = 1; i < N; i++) {
            if (startTimes[i] < endTimes[i - 1]) {
                // Overlapping intervals
                schedule.append(isPreviousC ? "J" : "C");
                isPreviousC = !isPreviousC;
            } else {
                // Non-overlapping intervals
                schedule.append(isPreviousC ? "C" : "J");
            }
        }

        return schedule.toString();
    }
}