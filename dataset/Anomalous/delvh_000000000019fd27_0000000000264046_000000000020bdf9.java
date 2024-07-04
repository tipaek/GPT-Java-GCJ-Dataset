import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private Scanner scanner = new Scanner(System.in);

    private void solve() throws Exception {
        int n = scanner.nextInt();
        int cEnd = 0, jEnd = 0;
        int[][] intervals = new int[n][4];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
            intervals[i][2] = i;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

        for (int[] interval : intervals) {
            if (cEnd <= interval[0]) {
                cEnd = interval[1];
                interval[3] = 'C';
            } else if (jEnd <= interval[0]) {
                jEnd = interval[1];
                interval[3] = 'J';
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        // Sort intervals back to their original order
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[2], interval2[2]));

        for (int[] interval : intervals) {
            System.out.print((char) interval[3]);
        }
        System.out.println();
    }

    private void run() throws Exception {
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            System.out.printf("Case #%d: ", i);
            solve();
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}