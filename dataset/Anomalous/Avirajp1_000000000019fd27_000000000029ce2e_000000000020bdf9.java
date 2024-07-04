import java.util.Arrays;
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
        int[] c = new int[9999];
        int[] h = new int[9999];
        Arrays.fill(c, -1);
        Arrays.fill(h, -1);

        StringBuilder schedule = new StringBuilder();
        int x = 0, y = 0;

        for (int j = intervals[0][0]; j < intervals[0][1]; j++) {
            c[x++] = j;
        }
        schedule.append('C');

        for (int j = 1; j < intervals.length; j++) {
            int inc = 0, inj = 0;

            for (int k = 0; k < c.length; k++) {
                if (intervals[j][0] == c[k] || intervals[j][1] - 1 == c[k]) {
                    inc++;
                }
                if (intervals[j][0] == h[k] || intervals[j][1] - 1 == h[k]) {
                    inj++;
                }
            }

            if (inc > 0 && inj == 0) {
                schedule.append('J');
                for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                    h[y++] = l;
                }
            } else if (inc == 0 && inj > 0) {
                schedule.append('C');
                for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                    c[x++] = l;
                }
            } else if (inc == 0 && inj == 0) {
                schedule.append('J');
                for (int l = intervals[j][0]; l < intervals[j][1]; l++) {
                    c[x++] = l;
                }
            } else {
                return "IMPOSSIBLE";
            }
        }

        return schedule.toString();
    }
}