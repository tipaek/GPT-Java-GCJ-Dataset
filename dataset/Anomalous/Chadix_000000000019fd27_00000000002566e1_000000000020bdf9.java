import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();

        // Process each case.
        for (int loop = 1; loop <= numCases; loop++) {
            int[] schedule = new int[1440];
            int[] numTasks = new int[2];

            for (int i = 0; i < 2; i++) {
                numTasks[i] = stdin.nextInt();
            }

            // Fill in who is required at each minute.
            for (int person = 1; person <= 2; person++) {
                for (int i = 0; i < numTasks[person - 1]; i++) {
                    int start = stdin.nextInt();
                    int end = stdin.nextInt();
                    for (int j = start; j < end; j++) {
                        schedule[j] = person;
                    }
                }
            }

            // dp[i][j][k] is min transitions to get to person 1 = i minutes, person 2 = j minutes with person k+1 getting the last minute.
            int[][][] dp = new int[721][721][2];
            for (int i = 0; i <= 720; i++) {
                for (int j = 0; j <= 720; j++) {
                    Arrays.fill(dp[i][j], 10000);
                }
            }

            // Set up the first minute for DP.
            if (schedule[0] == 1 || schedule[0] == 0) dp[1][0][0] = 0;
            if (schedule[0] == 2 || schedule[0] == 0) dp[0][1][1] = 0;

            // Go through person 1's minutes.
            for (int i = 0; i <= 720; i++) {
                // And person 2's minutes.
                for (int j = 0; j <= 720; j++) {
                    // Skip already filled in minutes.
                    if (i + j < 2) continue;

                    // Build off the previous minute - allow both options if possible.
                    if ((schedule[i + j - 1] == 1 || schedule[i + j - 1] == 0) && i > 0) {
                        dp[i][j][0] = min(dp[i][j][0], dp[i - 1][j][0], dp[i - 1][j][1] + 1);
                    }
                    if ((schedule[i + j - 1] == 2 || schedule[i + j - 1] == 0) && j > 0) {
                        dp[i][j][1] = min(dp[i][j][1], dp[i][j - 1][1], dp[i][j - 1][0] + 1);
                    }
                }
            }

            // Look at the appropriate DP square to get the final result.
            int result;
            if (schedule[1439] == 0) {
                result = Math.min(dp[720][720][0], dp[720][720][1]);
            } else if (schedule[1439] == 1) {
                result = dp[720][720][0];
            } else {
                result = dp[720][720][1];
            }

            // This will take care of a switch at midnight.
            if (result % 2 == 1) result++;

            System.out.println("Case #" + loop + ": " + result);
        }
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}