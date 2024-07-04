import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][2];
            int[] originalIndices = new int[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                originalIndices[i] = i;
            }

            // Sort intervals by start time using bubble sort
            for (int i = 0; i < numIntervals; i++) {
                for (int j = i + 1; j < numIntervals; j++) {
                    if (intervals[i][0] > intervals[j][0]) {
                        int[] tempInterval = intervals[i];
                        intervals[i] = intervals[j];
                        intervals[j] = tempInterval;

                        int tempIndex = originalIndices[i];
                        originalIndices[i] = originalIndices[j];
                        originalIndices[j] = tempIndex;
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            int endJ = 0, endC = 0;
            boolean possible = true;

            for (int i = 0; i < numIntervals; i++) {
                if (endJ <= intervals[i][0]) {
                    endJ = intervals[i][1];
                    answer.append('J');
                } else if (endC <= intervals[i][0]) {
                    endC = intervals[i][1];
                    answer.append('C');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                char[] result = new char[numIntervals];
                for (int i = 0; i < numIntervals; i++) {
                    result[originalIndices[i]] = answer.charAt(i);
                }
                System.out.println("Case #" + (t + 1) + ": " + new String(result));
            }
        }
    }
}