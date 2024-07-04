import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            char[] results = new char[n];
            Arrays.fill(results, 'C');

            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            boolean impossible = false;
            int[] overlapsCount = new int[n];
            int[][] overlaps = new int[n][2];

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (intervalsOverlap(intervals[j], intervals[k])) {
                        overlapsCount[j]++;
                        if (overlapsCount[j] >= 3) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                        overlaps[j][overlapsCount[j] - 1] = k;
                        if (overlapsCount[j] == 2 && intervalsOverlap(intervals[overlaps[j][0]], intervals[overlaps[j][1]])) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        } else if (overlapsCount[j] == 2) {
                            results[overlaps[j][0]] = 'J';
                            results[overlaps[j][1]] = 'J';
                        }
                    }
                }
                if (impossible) break;
            }

            if (!impossible) {
                for (int j = 0; j < n; j++) {
                    if (results[j] == 'J') continue;
                    for (int k = j + 1; k < n; k++) {
                        if (results[k] == 'J') continue;
                        if (intervalsOverlap(intervals[j], intervals[k])) {
                            results[j] = 'J';
                            break;
                        }
                    }
                }

                System.out.print("Case #" + i + ": ");
                for (char result : results) {
                    System.out.print(result);
                }
                System.out.println();
            }
        }
    }

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}