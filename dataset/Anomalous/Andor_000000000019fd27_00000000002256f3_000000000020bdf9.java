import java.util.Scanner;

public class Solution {
    private static int t, n;
    private static int[][] intervals;
    private static int[] cSchedule, jSchedule;
    private static String[] assignments;
    private static boolean isImpossible;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        for (int a = 1; a <= t; a++) {
            n = input.nextInt();
            intervals = new int[n][2];
            assignments = new String[n];
            isImpossible = false;

            for (int i = 0; i < n; i++) {
                intervals[i][0] = input.nextInt();
                intervals[i][1] = input.nextInt();
            }

            System.out.print("Case #" + a + ": ");
            cSchedule = new int[1440];
            jSchedule = new int[1440];

            for (int i = 0; i < n; i++) {
                if (assignToJ(intervals[i][0], intervals[i][1])) {
                    assignments[i] = "J";
                } else if (assignToC(intervals[i][0], intervals[i][1])) {
                    assignments[i] = "C";
                } else {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (String assignment : assignments) {
                    System.out.print(assignment);
                }
            }
            System.out.println();
        }
    }

    private static boolean assignToC(int start, int end) {
        for (int i = start; i < end; i++) {
            cSchedule[i]++;
            if (cSchedule[i] >= 2) {
                for (int j = i; j >= start; j--) {
                    cSchedule[j]--;
                }
                return false;
            }
        }
        return true;
    }

    private static boolean assignToJ(int start, int end) {
        for (int i = start; i < end; i++) {
            jSchedule[i]++;
            if (jSchedule[i] >= 2) {
                for (int j = i; j >= start; j--) {
                    jSchedule[j]--;
                }
                return false;
            }
        }
        return true;
    }
}