import java.util.Scanner;

public class Solution {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            n = sc.nextInt();
            int[][] intervals = new int[n][2];
            int[][] sortedIntervals = new int[n][2];
            StringBuilder result = new StringBuilder();

            for (int l = 0; l < n; l++) {
                intervals[l][0] = sc.nextInt();
                intervals[l][1] = sc.nextInt();
                sortedIntervals[l][0] = intervals[l][0];
                sortedIntervals[l][1] = intervals[l][1];
            }

            sortIntervals(sortedIntervals);

            int[][] C = new int[n][2];
            int[][] J = new int[n][2];
            int cCount = 0, jCount = 0;
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();

            for (int l = 0; l < n; l++) {
                int start = sortedIntervals[l][0];
                int end = sortedIntervals[l][1];

                if (cCount == 0 || start >= C[cCount - 1][1]) {
                    C[cCount][0] = start;
                    C[cCount][1] = end;
                    schedule.append("C");
                    cCount++;
                } else if (jCount == 0 || start >= J[jCount - 1][1]) {
                    J[jCount][0] = start;
                    J[jCount][1] = end;
                    schedule.append("J");
                    jCount++;
                } else {
                    isImpossible = true;
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!isImpossible) {
                StringBuilder finalSchedule = new StringBuilder();
                for (int l = 0; l < n; l++) {
                    for (int k = 0; k < n; k++) {
                        if (intervals[l][0] == sortedIntervals[k][0] && intervals[l][1] == sortedIntervals[k][1]) {
                            finalSchedule.append(schedule.charAt(k));
                            sortedIntervals[k][0] = -1; // Mark as processed
                            break;
                        }
                    }
                }
                System.out.println("Case #" + i + ": " + finalSchedule.toString());
            }
        }
    }

    static void sortIntervals(int[][] intervals) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int tempStart = intervals[j][0];
                    int tempEnd = intervals[j][1];
                    intervals[j][0] = intervals[j + 1][0];
                    intervals[j][1] = intervals[j + 1][1];
                    intervals[j + 1][0] = tempStart;
                    intervals[j + 1][1] = tempEnd;
                }
            }
        }
    }
}