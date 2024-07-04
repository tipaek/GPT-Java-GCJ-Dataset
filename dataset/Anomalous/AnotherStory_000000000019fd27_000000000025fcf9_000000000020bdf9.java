import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int[] assignments = new int[n];
            assignments[0] = 0;

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
                    isPossible = false;
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            if (isPossible) {
                char[] output = new char[n];
                for (int i = 0; i < n; i++) {
                    output[intervals[i][2]] = assignments[i] == 0 ? 'C' : 'J';
                }
                result.append(output);
            }

            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }
}