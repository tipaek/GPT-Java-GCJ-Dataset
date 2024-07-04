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
        int[] originalOrder = new int[N];
        int[] startTimes = new int[N];

        for (int i = 0; i < N; i++) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
            originalOrder[i] = i;
            startTimes[i] = intervals[i][0];
        }

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] sortedOrder = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (intervals[j][0] == startTimes[i]) {
                    sortedOrder[i] = j;
                }
            }
        }

        boolean cameronBusy = false;
        int cameronEnd = 0;
        boolean jamieBusy = false;
        int jamieEnd = 0;
        boolean impossible = false;
        StringBuilder schedule = new StringBuilder();

        for (int i = intervals[0][0]; i <= intervals[N - 1][1] + 1; i++) {
            for (int j = 0; j < N; j++) {
                if (i == intervals[j][0]) {
                    if (cameronBusy && jamieBusy) {
                        impossible = true;
                        break;
                    } else if (cameronBusy) {
                        jamieBusy = true;
                        jamieEnd = intervals[j][1];
                        schedule.append('J');
                    } else {
                        cameronBusy = true;
                        cameronEnd = intervals[j][1];
                        schedule.append('C');
                    }
                }
                if (i == intervals[j][1]) {
                    if (j == cameronEnd) {
                        cameronBusy = false;
                    } else if (j == jamieEnd) {
                        jamieBusy = false;
                    }
                }
            }
            if (impossible) break;
        }

        if (impossible) {
            System.out.println("IMPOSSIBLE");
        } else {
            char[] scheduleArray = schedule.toString().toCharArray();
            StringBuilder finalSchedule = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < scheduleArray.length; j++) {
                    if (originalOrder[i] == sortedOrder[j]) {
                        finalSchedule.append(scheduleArray[j]);
                    }
                }
            }
            System.out.println(finalSchedule);
        }
    }
}