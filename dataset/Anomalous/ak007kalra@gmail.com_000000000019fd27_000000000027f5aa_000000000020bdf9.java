import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIndices = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = input.nextInt();
                intervals[j][1] = input.nextInt();
                originalIndices[j][0] = intervals[j][0];
                originalIndices[j][1] = intervals[j][1];
            }

            boolean impossible = false;
            for (int[] interval : intervals) {
                if (interval[1] <= interval[0]) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (impossible) continue;

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            int[] rem = new int[n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (originalIndices[j][0] == intervals[k][0] && originalIndices[j][1] == intervals[k][1]) {
                        rem[j] = k;
                        break;
                    }
                }
            }

            StringBuilder schedule = new StringBuilder();
            int[] c = {0, 0};
            int[] j = {0, 0};

            schedule.append('C');
            c[0] = intervals[0][0];
            c[1] = intervals[0][1];

            boolean isPossible = true;
            for (int m = 1; m < n; m++) {
                if (intervals[m][0] < c[1]) {
                    if (intervals[m][0] >= j[1]) {
                        schedule.append('J');
                        j[0] = intervals[m][0];
                        j[1] = intervals[m][1];
                    } else {
                        System.out.println("Case #" + i + ": IMPOSSIBLE");
                        isPossible = false;
                        break;
                    }
                } else {
                    schedule.append('C');
                    c[0] = intervals[m][0];
                    c[1] = intervals[m][1];
                }
            }

            if (isPossible) {
                StringBuilder output = new StringBuilder();
                for (int value : rem) {
                    output.append(schedule.charAt(value));
                }
                System.out.println("Case #" + i + ": " + output);
            }
        }
    }
}