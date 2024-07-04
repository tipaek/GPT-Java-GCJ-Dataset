import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        int[][] intervals = new int[N][2];
        int[] startTimes = new int[N];
        int[] sortedStartTimes = new int[N];
        boolean isCameronBusy = false;
        int cameronIndex = 0;
        boolean isJamieBusy = false;
        int jamieIndex = 0;
        boolean isImpossible = false;
        String schedule = "";

        for (int i = 0; i < N; i++) {
            intervals[i][0] = scanner.nextInt();
            startTimes[i] = intervals[i][0];
            intervals[i][1] = scanner.nextInt();
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        outerLoop:
        for (int currentTime = intervals[0][0]; currentTime <= intervals[N - 1][1]; currentTime++) {
            for (int j = 0; j < N; j++) {
                if (currentTime == intervals[j][0]) {
                    if (isCameronBusy && isJamieBusy) {
                        isImpossible = true;
                        break outerLoop;
                    } else if (isCameronBusy) {
                        isJamieBusy = true;
                        jamieIndex = j;
                        sortedStartTimes[j] = intervals[j][0];
                        schedule += 'J';
                    } else {
                        isCameronBusy = true;
                        cameronIndex = j;
                        sortedStartTimes[j] = intervals[j][0];
                        schedule += 'C';
                    }
                }
                if (currentTime == intervals[j][1]) {
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
            char[] scheduleChars = schedule.toCharArray();
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