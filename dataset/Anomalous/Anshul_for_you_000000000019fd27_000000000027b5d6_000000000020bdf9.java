import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            int[][] overlaps = new int[n * n + 1][2];
            int overlapCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((intervals[i][1] > intervals[j][0] && intervals[i][1] < intervals[j][1]) ||
                        (intervals[j][1] > intervals[i][0] && intervals[i][0] > intervals[j][0]) ||
                        (intervals[j][1] <= intervals[i][1] && intervals[j][0] >= intervals[i][0]) ||
                        (intervals[j][1] >= intervals[i][1] && intervals[j][0] <= intervals[i][0])) {
                        overlaps[overlapCount][0] = i;
                        overlaps[overlapCount][1] = j;
                        overlapCount++;
                    }
                }
            }

            char[] assignments = new char[n];
            for (int i = 0; i < n; i++) {
                assignments[i] = 'C';
            }

            boolean isImpossible = false;
            for (int i = 0; i < overlapCount; i++) {
                int a = overlaps[i][0];
                int b = overlaps[i][1];

                if (assignments[a] == assignments[b]) {
                    if (assignments[a] == 'C') {
                        assignments[b] = 'J';
                    } else {
                        assignments[b] = 'C';
                        isImpossible = true;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (char assignment : assignments) {
                result.append(assignment);
            }

            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + result.toString());
            }
        }

        scanner.close();
    }
}