import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(in);
        }
        in.close();
    }

    static void solve(Scanner in) {
        int N = in.nextInt();
        int[][] tasks = new int[N][2];
        int[] startTimes = new int[N];
        int[] sortedStartTimes = new int[N];
        boolean isCameronBusy = false;
        int cameronIndex = 0;
        boolean isJamieBusy = false;
        int jamieIndex = 0;
        boolean isImpossible = false;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < N; i++) {
            tasks[i][0] = in.nextInt();
            startTimes[i] = tasks[i][0];
            tasks[i][1] = in.nextInt();
        }

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        outerLoop: for (int currentTime = tasks[0][0]; currentTime < tasks[N - 1][1] + 2; currentTime++) {
            for (int j = 0; j < N; j++) {
                if (currentTime == tasks[j][0]) {
                    if (isCameronBusy && isJamieBusy) {
                        isImpossible = true;
                        break outerLoop;
                    } else if (isCameronBusy) {
                        isJamieBusy = true;
                        jamieIndex = j;
                        sortedStartTimes[j] = tasks[j][0];
                        schedule.append('J');
                    } else {
                        isCameronBusy = true;
                        cameronIndex = j;
                        sortedStartTimes[j] = tasks[j][0];
                        schedule.append('C');
                    }
                }
                if (currentTime == tasks[j][1]) {
                    if (j == cameronIndex) {
                        isCameronBusy = false;
                    } else if (j == jamieIndex) {
                        isJamieBusy = false;
                    }
                }
            }
        }

        if (isImpossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            char[] scheduleChars = schedule.toString().toCharArray();
            StringBuilder finalSchedule = new StringBuilder();
            for (int i = 0; i < sortedStartTimes.length; i++) {
                for (int j = 0; j < sortedStartTimes.length; j++) {
                    if (startTimes[i] == sortedStartTimes[j]) {
                        finalSchedule.append(scheduleChars[j]);
                    }
                }
            }
            System.out.println(finalSchedule.toString());
        }
    }
}