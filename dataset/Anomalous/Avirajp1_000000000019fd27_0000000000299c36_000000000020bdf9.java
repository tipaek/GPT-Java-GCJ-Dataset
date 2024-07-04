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
            System.out.printf("Case #%d: %s%n", ts++, result);
        }
    }

    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        int[] c = new int[10000];
        int[] j = new int[10000];
        int cIndex = 0, jIndex = 0;
        StringBuilder schedule = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean canAssignToC = true;
            boolean canAssignToJ = true;

            for (int k = 0; k < cIndex; k++) {
                if (start < c[k] && end > c[k]) {
                    canAssignToC = false;
                    break;
                }
            }

            for (int k = 0; k < jIndex; k++) {
                if (start < j[k] && end > j[k]) {
                    canAssignToJ = false;
                    break;
                }
            }

            if (canAssignToC) {
                schedule.append('C');
                for (int t = start; t < end; t++) {
                    c[cIndex++] = t;
                }
            } else if (canAssignToJ) {
                schedule.append('J');
                for (int t = start; t < end; t++) {
                    j[jIndex++] = t;
                }
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}