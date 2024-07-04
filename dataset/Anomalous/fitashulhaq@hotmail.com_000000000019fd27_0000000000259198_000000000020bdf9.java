import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            char[] assignments = new char[n];
            Arrays.fill(assignments, 'C');

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            boolean isImpossible = false;
            int[] overlapCount = new int[n];
            int[][] overlapIndices = new int[n][2];

            for (int i = 0; i < n; i++) {
                boolean hasOverlap = false;
                int firstOverlapIndex = -1;

                for (int j = i + 1; j < n; j++) {
                    if (intervals[i][0] < intervals[j][1] && intervals[j][0] < intervals[i][1]) {
                        if (!hasOverlap) {
                            firstOverlapIndex = j;
                        }
                        hasOverlap = true;
                        overlapCount[i]++;

                        if (overlapCount[i] >= 3) {
                            System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                            isImpossible = true;
                            break;
                        }

                        overlapIndices[i][overlapCount[i] - 1] = j;

                        if (overlapCount[i] == 2) {
                            int idx0 = overlapIndices[i][0];
                            int idx1 = overlapIndices[i][1];
                            if (intervals[idx0][0] < intervals[idx1][1] && intervals[idx1][0] < intervals[idx0][1]) {
                                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            } else {
                                if (assignments[idx0] != 'J') {
                                    assignments[idx0] = 'J';
                                }
                                if (assignments[idx1] != 'J') {
                                    assignments[idx1] = 'J';
                                }
                            }
                        }
                    }
                }

                if (isImpossible) {
                    break;
                }

                if (hasOverlap && assignments[i] == 'C') {
                    assignments[firstOverlapIndex] = 'J';
                }
            }

            if (!isImpossible) {
                System.out.print("Case #" + testCase + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
    }
}