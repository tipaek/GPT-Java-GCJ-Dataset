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
            int[] jSchedule = new int[1441];
            int[] cSchedule = new int[1441];
            boolean possible = true;

            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            char[] assignedJobs = new char[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            Solution solution = new Solution();
            solution.markOccupied(jSchedule, startTimes[0], endTimes[0]);
            assignedJobs[0] = 'J';

            for (int i = 1; i < n; i++) {
                int start = startTimes[i];
                int end = endTimes[i];

                if (jSchedule[start] != 1 && jSchedule[end] != 1) {
                    solution.markOccupied(jSchedule, start, end);
                    assignedJobs[i] = 'J';
                } else if (cSchedule[start] != 1 && cSchedule[end] != 1) {
                    solution.markOccupied(cSchedule, start, end);
                    assignedJobs[i] = 'C';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(assignedJobs));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}