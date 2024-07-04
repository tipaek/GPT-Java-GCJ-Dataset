import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int k = 1; k <= t; ++k) {
            int n = in.nextInt();
            int[][] activities = new int[n][3];
            StringBuilder sb = new StringBuilder();
            boolean notValid = false;
            int solvedActivities = 0;
            int minStart, maxDuration, taskId, lastTime;

            // Read activities
            for (int i = 0; i < n; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                activities[i][0] = startTime;
                activities[i][1] = endTime;
                activities[i][2] = 0;
            }

            // Assign activities to Cameron (1) first
            solvedActivities = assignActivities(activities, n, 1);
            if (solvedActivities != n) {
                // Assign remaining activities to Jamie (2)
                solvedActivities = assignActivities(activities, n, 2);
            }

            // Validate and build the result string
            for (int i = 0; i < n; i++) {
                if (activities[i][2] == 0) {
                    notValid = true;
                    break;
                } else if (activities[i][2] == 1) {
                    sb.append("C");
                } else {
                    sb.append("J");
                }
            }

            String result = notValid ? "IMPOSSIBLE" : sb.toString();
            System.out.println("Case #" + k + ": " + result);
        }
    }

    private static int assignActivities(int[][] activities, int n, int person) {
        int solvedActivities = 0;
        int lastTime = 0;
        boolean notValid;

        while (solvedActivities != n) {
            int minStart = 24 * 60;
            int maxDuration = 0;
            int taskId = -1;
            notValid = true;

            for (int i = 0; i < n; i++) {
                if (lastTime <= activities[i][0] && activities[i][2] == 0) {
                    if (activities[i][0] < minStart || (activities[i][0] == minStart && maxDuration < activities[i][1] - activities[i][0])) {
                        minStart = activities[i][0];
                        maxDuration = activities[i][1] - activities[i][0];
                        taskId = i;
                    }
                }
            }

            if (maxDuration > 0) {
                lastTime = activities[taskId][1];
                notValid = false;
                solvedActivities++;
                activities[taskId][2] = person;
            }

            if (notValid) {
                break;
            }
        }

        return solvedActivities;
    }
}