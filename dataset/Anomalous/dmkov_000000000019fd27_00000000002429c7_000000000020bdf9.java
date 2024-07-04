import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int intervalsCount = scanner.nextInt();
            int[][] intervals = new int[2 * intervalsCount][3];
            char[] schedule = new char[intervalsCount];

            for (int j = 0; j < 2 * intervalsCount; j += 2) {
                int start = scanner.nextInt();
                intervals[j] = new int[]{j, start, 0};
                int end = scanner.nextInt();
                intervals[j + 1] = new int[]{j, end, 1};
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] == b[1]) {
                    return b[2] - a[2];
                } else {
                    return a[1] - b[1];
                }
            });

            int activeIntervals = 0;
            boolean isPossible = true;

            for (int[] interval : intervals) {
                if (interval[2] == 0) {
                    activeIntervals++;

                    if (activeIntervals == 1) {
                        schedule[interval[0] / 2] = 'C';
                    } else if (activeIntervals == 2) {
                        schedule[interval[0] / 2] = 'J';
                    } else {
                        isPossible = false;
                        break;
                    }
                } else {
                    activeIntervals--;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + new String(schedule));
            }
        }
    }
}