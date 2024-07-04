import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character after the integer input

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            in.nextLine(); // Consume the newline character after the integer input

            int[][] intervals = new int[n][2];
            char[] results = new char[n];
            Arrays.fill(results, 'C');

            for (int j = 0; j < n; j++) {
                String line = in.nextLine();
                if (line.isEmpty()) {
                    j--;
                    continue;
                }
                String[] parts = line.split(" ");
                intervals[j][0] = Integer.parseInt(parts[0]);
                intervals[j][1] = Integer.parseInt(parts[1]);
            }

            boolean impossible = false;
            int[] overlapCount = new int[n];
            int[][] overlaps = new int[n][2];

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (intervalsOverlap(intervals[j], intervals[k])) {
                        overlapCount[j]++;
                        if (overlapCount[j] >= 3) {
                            System.out.println("Case #" + i + ": IMPOSSIBLE");
                            impossible = true;
                            break;
                        }
                        overlaps[j][overlapCount[j] - 1] = k;

                        if (overlapCount[j] == 2) {
                            int firstOverlapIndex = overlaps[j][0];
                            int secondOverlapIndex = overlaps[j][1];
                            if (intervalsOverlap(intervals[firstOverlapIndex], intervals[secondOverlapIndex])) {
                                System.out.println("Case #" + i + ": IMPOSSIBLE");
                                impossible = true;
                                break;
                            } else {
                                results[firstOverlapIndex] = 'J';
                                results[secondOverlapIndex] = 'J';
                            }
                        }
                    }
                }
                if (impossible) break;
            }

            if (impossible) continue;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (intervalsOverlap(intervals[j], intervals[k]) && results[k] == 'C') {
                        results[j] = 'J';
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

    private static boolean intervalsOverlap(int[] interval1, int[] interval2) {
        return interval1[0] < interval2[1] && interval2[0] < interval1[1];
    }
}