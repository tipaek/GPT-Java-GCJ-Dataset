import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int activities = scanner.nextInt();
            int[][] activityTimes = new int[activities][2];
            int minTime = Integer.MAX_VALUE;
            int maxTime = Integer.MIN_VALUE;

            for (int i = 0; i < activities; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activityTimes[i][0] = startTime;
                activityTimes[i][1] = endTime;
                minTime = Math.min(minTime, startTime);
                maxTime = Math.max(maxTime, endTime);
            }

            solve(minTime, maxTime, activityTimes, caseNum);
        }
    }

    private static String checkAvailability(int[] scheduleJ, int[] scheduleC, int start, int end) {
        int countJ = 0;
        int countC = 0;

        for (int time = start; time <= end; time++) {
            if (scheduleJ[time] == 1) countJ++;
            if (scheduleC[time] == 1) countC++;
            if (countJ >= 2 && countC >= 2) return "IMPOSSIBLE";
        }

        if (countJ < 2) return "J";
        if (countC < 2) return "C";
        return "IMPOSSIBLE";
    }

    private static void solve(int min, int max, int[][] activities, int caseNum) {
        int[] scheduleJ = new int[max + 1];
        int[] scheduleC = new int[max + 1];
        StringBuilder result = new StringBuilder();

        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            String assignment = checkAvailability(scheduleJ, scheduleC, start, end);

            if (assignment.equals("J")) {
                for (int time = start; time <= end; time++) {
                    scheduleJ[time] = 1;
                }
                result.append("J");
            } else if (assignment.equals("C")) {
                for (int time = start; time <= end; time++) {
                    scheduleC[time] = 1;
                }
                result.append("C");
            } else {
                result.setLength(0);
                result.append("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + caseNum + ": " + result.toString());
    }
}