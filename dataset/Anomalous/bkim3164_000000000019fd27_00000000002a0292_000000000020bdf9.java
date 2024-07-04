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
        int[] originalStartTimes = new int[N];
        boolean[] isJobAssigned = new boolean[N];
        StringBuilder assignment = new StringBuilder();

        for (int i = 0; i < N; i++) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
            originalStartTimes[i] = intervals[i][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        boolean cameronBusy = false;
        boolean jamieBusy = false;
        int cameronEndTime = 0;
        int jamieEndTime = 0;

        for (int i = 0; i < N; i++) {
            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            if (!cameronBusy || cameronEndTime <= startTime) {
                cameronBusy = true;
                cameronEndTime = endTime;
                assignment.append('C');
            } else if (!jamieBusy || jamieEndTime <= startTime) {
                jamieBusy = true;
                jamieEndTime = endTime;
                assignment.append('J');
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }

            if (endTime == cameronEndTime) {
                cameronBusy = false;
            }
            if (endTime == jamieEndTime) {
                jamieBusy = false;
            }
        }

        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            int startTime = originalStartTimes[i];
            for (int j = 0; j < N; j++) {
                if (intervals[j][0] == startTime && !isJobAssigned[j]) {
                    result[i] = assignment.charAt(j);
                    isJobAssigned[j] = true;
                    break;
                }
            }
        }

        System.out.println(new String(result));
    }
}