import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[][] originalIntervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int[] assignments = new int[n];
            boolean isPossible = true;
            StringBuilder result = new StringBuilder();

            for (int i = 1; i < n; i++) {
                int parentIndex = -1;
                int parentCount = 0;

                for (int j = 0; j < i; j++) {
                    if (intervals[i][0] >= intervals[j][0] && intervals[i][0] < intervals[j][1]) {
                        parentCount++;
                        parentIndex = assignments[j];
                    }
                }

                if (parentCount == 0) {
                    assignments[i] = 0;
                } else if (parentCount == 1) {
                    assignments[i] = 1 - parentIndex;
                } else {
                    result.append("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                for (int i = 0; i < n; i++) {
                    int start = originalIntervals[i][0];
                    int end = originalIntervals[i][1];

                    for (int j = 0; j < n; j++) {
                        if (intervals[j][0] == start && intervals[j][1] == end) {
                            result.append(assignments[j] == 0 ? "C" : "J");
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }
    }
}