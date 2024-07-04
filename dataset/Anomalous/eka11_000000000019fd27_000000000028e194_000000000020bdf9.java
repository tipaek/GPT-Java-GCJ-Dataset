import java.util.Scanner;

public class Solution {

    void markOccupied(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int[] jSchedule = new int[1440];
            int[] cSchedule = new int[1440];
            boolean isPossible = true;

            int numJobs = scanner.nextInt();
            int[] startTimes = new int[numJobs];
            int[] endTimes = new int[numJobs];
            char[] assignments = new char[numJobs];

            for (int i = 0; i < numJobs; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            Solution solution = new Solution();
            solution.markOccupied(jSchedule, startTimes[0], endTimes[0]);
            assignments[0] = 'J';

            for (int i = 1; i < numJobs; i++) {
                int start = startTimes[i];
                int end = endTimes[i];

                if (isFree(jSchedule, start, end)) {
                    solution.markOccupied(jSchedule, start, end);
                    assignments[i] = 'J';
                } else if (isFree(cSchedule, start, end)) {
                    solution.markOccupied(cSchedule, start, end);
                    assignments[i] = 'C';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(assignments));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isFree(int[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i] == 1) {
                return false;
            }
        }
        return true;
    }
}