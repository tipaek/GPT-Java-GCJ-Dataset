import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[2 * numIntervals][2];

            for (int i = 0; i < numIntervals; i++) {
                intervals[2 * i][0] = scanner.nextInt();
                intervals[2 * i + 1][0] = scanner.nextInt();
                intervals[2 * i][1] = intervals[2 * i + 1][0];
                intervals[2 * i + 1][1] = -1;
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });

            int cEnd = -1;
            int jEnd = -1;
            boolean possible = true;

            for (int i = 0; i < 2 * numIntervals; i++) {
                if (intervals[i][1] >= 0) {
                    if (cEnd < 0) {
                        result.append('C');
                        cEnd = intervals[i][1];
                    } else if (jEnd < 0) {
                        result.append('J');
                        jEnd = intervals[i][1];
                    } else {
                        result = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                } else {
                    if (cEnd == intervals[i][0]) {
                        cEnd = -1;
                    } else {
                        jEnd = -1;
                    }
                }
            }

            if (possible) {
                System.out.println(String.format("Case #%d: %s", t, result.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }
}