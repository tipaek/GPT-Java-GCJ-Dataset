import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int ts = 1;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = sc.nextInt();
                intervals[j][1] = sc.nextInt();
            }

            String result = assignTasks(intervals);
            System.out.printf("Case #%d: %s\n", ts++, result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int[] c = new int[1500];
        int[] j = new int[1500];
        int cIndex = 0, jIndex = 0;

        StringBuilder schedule = new StringBuilder();
        schedule.append('C');

        for (int k = intervals[0][0]; k < intervals[0][1]; k++) {
            c[cIndex++] = k;
        }

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean canAssignC = true, canAssignJ = true;

            for (int k = 0; k < cIndex; k++) {
                if (c[k] == start || c[k] == end - 1) {
                    canAssignC = false;
                    break;
                }
            }

            for (int k = 0; k < jIndex; k++) {
                if (j[k] == start || j[k] == end - 1) {
                    canAssignJ = false;
                    break;
                }
            }

            if (canAssignC) {
                schedule.append('C');
                for (int k = start; k < end; k++) {
                    c[cIndex++] = k;
                }
            } else if (canAssignJ) {
                schedule.append('J');
                for (int k = start; k < end; k++) {
                    j[jIndex++] = k;
                }
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}