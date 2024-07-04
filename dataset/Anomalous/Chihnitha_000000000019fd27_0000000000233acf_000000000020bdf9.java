import java.util.*;

public class ActivityScheduler {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();

        // Process each test case
        for (int caseIndex = 1; caseIndex <= numCases; caseIndex++) {
            int[] schedule = new int[1440];
            int[] activityCount = new int[2];

            // Read the number of activities for each person
            for (int i = 0; i < 2; i++) {
                activityCount[i] = stdin.nextInt();
            }

            // Populate the schedule with who is required at each minute
            for (int person = 1; person <= 2; person++) {
                for (int i = 0; i < activityCount[person - 1]; i++) {
                    int start = stdin.nextInt();
                    int end = stdin.nextInt();
                    for (int j = start; j < end; j++) {
                        schedule[j] = person;
                    }
                }
            }

            // dp[i][j][k] represents the minimum transitions to get to person 1 = i minutes,
            // person 2 = j minutes with person k+1 getting the last minute
            int[][][] dp = new int[721][721][2];
            for (int i = 0; i <= 720; i++) {
                for (int j = 0; j <= 720; j++) {
                    Arrays.fill(dp[i][j], 10000);
                }
            }

            // Initialize the first minute for DP
            if (schedule[0] == 1 || schedule[0] == 0) dp[1][0][0] = 0;
            if (schedule[0] == 2 || schedule[0] == 0) dp[0][1][1] = 0;

            // Fill the DP table
            for (int i = 0; i <= 720; i++) {
                for (int j = 0; j <= 720; j++) {
                    if (i + j < 2) continue;

                    if ((schedule[i + j - 1] == 1 || schedule[i + j - 1] == 0) && i > 0) {
                        dp[i][j][0] = Math.min(dp[i][j][0], Math.min(dp[i - 1][j][0], dp[i - 1][j][1] + 1));
                    }
                    if ((schedule[i + j - 1] == 2 || schedule[i + j - 1] == 0) && j > 0) {
                        dp[i][j][1] = Math.min(dp[i][j][1], Math.min(dp[i][j - 1][1], dp[i][j - 1][0] + 1));
                    }
                }
            }

            // Determine the final result
            int result;
            if (schedule[1439] == 0) {
                result = Math.min(dp[720][720][0], dp[720][720][1]);
            } else {
                result = schedule[1439] == 1 ? dp[720][720][0] : dp[720][720][1];
            }

            // Adjust for a switch at midnight
            if (result % 2 == 1) result++;

            System.out.println("Case #" + caseIndex + ": " + result);
        }
    }
}