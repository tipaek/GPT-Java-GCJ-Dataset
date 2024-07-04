import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            solve(scanner);
            System.out.println();
        }
        scanner.close();
    }

    static void solve(Scanner scanner) {
        int N = scanner.nextInt();
        int[][] activities = new int[N][2];
        int[] startTimes = new int[N];
        int[] sortedStartTimes = new int[N];
        boolean isCameronBusy = false;
        int cameronIndex = 0;
        boolean isJamieBusy = false;
        int jamieIndex = 0;
        boolean isImpossible = false;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < N; i++) {
            activities[i][0] = scanner.nextInt();
            startTimes[i] = activities[i][0];
            activities[i][1] = scanner.nextInt();
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

        outerLoop:
        for (int time = activities[0][0]; time < activities[N - 1][1] + 2; time++) {
            for (int j = 0; j < N; j++) {
                if (time == activities[j][0]) {
                    if (isCameronBusy && isJamieBusy) {
                        isImpossible = true;
                        break outerLoop;
                    } else if (isCameronBusy) {
                        isJamieBusy = true;
                        jamieIndex = j;
                        sortedStartTimes[j] = activities[j][0];
                        schedule.append('J');
                    } else {
                        isCameronBusy = true;
                        cameronIndex = j;
                        sortedStartTimes[j] = activities[j][0];
                        schedule.append('C');
                    }
                }

                if (time == activities[j][1]) {
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
            char[] scheduleArray = schedule.toString().toCharArray();
            StringBuilder finalSchedule = new StringBuilder();

            for (int i = 0; i < sortedStartTimes.length; i++) {
                for (int j = 0; j < sortedStartTimes.length; j++) {
                    if (startTimes[i] == sortedStartTimes[j]) {
                        finalSchedule.append(scheduleArray[j]);
                    }
                }
            }
            System.out.println(finalSchedule);
        }
    }
}