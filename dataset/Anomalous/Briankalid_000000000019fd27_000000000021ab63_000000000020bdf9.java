import java.util.*;

public class ScheduleTransitions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int[] schedule = new int[1440];
            int[] taskCount = new int[2];

            for (int i = 0; i < 2; i++) {
                taskCount[i] = scanner.nextInt();
            }

            for (int person = 1; person <= 2; person++) {
                for (int i = 0; i < taskCount[person - 1]; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    for (int j = start; j < end; j++) {
                        schedule[j] = person;
                    }
                }
            }

            int[][][] dp = new int[721][721][2];
            for (int i = 0; i <= 720; i++) {
                for (int j = 0; j <= 720; j++) {
                    Arrays.fill(dp[i][j], 10000);
                }
            }

            if (schedule[0] == 1 || schedule[0] == 0) dp[1][0][0] = 0;
            if (schedule[0] == 2 || schedule[0] == 0) dp[0][1][1] = 0;

            for (int i = 0; i <= 720; i++) {
                for (int j = 0; j <= 720; j++) {
                    if (i + j < 2) continue;

                    if ((schedule[i + j - 1] == 1 || schedule[i + j - 1] == 0) && i > 0) {
                        dp[i][j][0] = min(dp[i][j][0], dp[i - 1][j][0], dp[i - 1][j][1] + 1);
                    }
                    if ((schedule[i + j - 1] == 2 || schedule[i + j - 1] == 0) && j > 0) {
                        dp[i][j][1] = min(dp[i][j][1], dp[i][j - 1][1], dp[i][j - 1][0] + 1);
                    }
                }
            }

            int result;
            if (schedule[1439] == 0) {
                result = Math.min(dp[720][720][0], dp[720][720][1]);
            } else if (schedule[1439] == 1) {
                result = dp[720][720][0];
            } else {
                result = dp[720][720][1];
            }

            if (result % 2 == 1) result++;

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}