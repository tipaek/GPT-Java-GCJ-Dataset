import java.util.*;

public class Solution {

    void markAsOccupied(int[] arr, int start, int end) {
        Arrays.fill(arr, start, end, 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] jSchedule = new int[1441];
            int[] cSchedule = new int[1441];
            boolean isPossible = true;

            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] jobAssignments = new char[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            Solution solution = new Solution();

            for (int i = 0; i < n; i++) {
                int start = startTimes[i];
                int end = endTimes[i];

                if (isTimeSlotAvailable(jSchedule, start, end)) {
                    solution.markAsOccupied(jSchedule, start, end);
                    jobAssignments[i] = 'J';
                } else if (isTimeSlotAvailable(cSchedule, start, end)) {
                    solution.markAsOccupied(cSchedule, start, end);
                    jobAssignments[i] = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(jobAssignments));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isTimeSlotAvailable(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }
}