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
        int[][] intervals = new int[N][2];
        int[] startTimes = new int[N];
        int[] sortedStartTimes = new int[N];
        boolean isCameronBusy = false;
        int cameronIndex = 0;
        boolean isJamieBusy = false;
        int jamieIndex = 0;
        boolean isImpossible = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            intervals[i][0] = in.nextInt();
            startTimes[i] = intervals[i][0];
            intervals[i][1] = in.nextInt();
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        outerLoop: for (int time = intervals[0][0]; time <= intervals[N - 1][1]; time++) {
            for (int j = 0; j < N; j++) {
                if (time == intervals[j][0]) {
                    if (isCameronBusy && isJamieBusy) {
                        isImpossible = true;
                        break outerLoop;
                    } else if (isCameronBusy) {
                        isJamieBusy = true;
                        jamieIndex = j;
                        sortedStartTimes[j] = intervals[j][0];
                        result.append("J");
                    } else {
                        isCameronBusy = true;
                        cameronIndex = j;
                        sortedStartTimes[j] = intervals[j][0];
                        result.append("C");
                    }
                }

                if (time == intervals[j][1]) {
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
            char[] resultArray = result.toString().toCharArray();
            StringBuilder finalResult = new StringBuilder();

            for (int i = 0; i < startTimes.length; i++) {
                for (int j = 0; j < sortedStartTimes.length; j++) {
                    if (startTimes[i] == sortedStartTimes[j]) {
                        finalResult.append(resultArray[j]);
                    }
                }
            }
            System.out.println(finalResult);
        }
    }
}