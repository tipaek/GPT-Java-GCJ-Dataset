import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];

            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }

            int[][] overlaps = new int[n * n][2];
            int overlapCount = 0;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((intervals[j][1] > intervals[k][0] && intervals[j][1] < intervals[k][1]) ||
                        (intervals[k][1] > intervals[j][0] && intervals[j][0] > intervals[k][0]) ||
                        (intervals[k][1] <= intervals[j][1] && intervals[k][0] >= intervals[j][0]) ||
                        (intervals[k][1] >= intervals[j][1] && intervals[k][0] <= intervals[j][0])) {
                        overlaps[overlapCount][0] = j;
                        overlaps[overlapCount][1] = k;
                        overlapCount++;
                    }
                }
            }

            char[] assignments = new char[n];
            for (int j = 0; j < n; j++) {
                assignments[j] = 'J';
            }

            boolean impossible = false;
            for (int j = 0; j < overlapCount; j++) {
                int a = overlaps[j][0];
                int b = overlaps[j][1];

                if (assignments[a] == assignments[b]) {
                    if (assignments[a] == 'J') {
                        assignments[b] = 'C';
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                result.append(assignments[j]);
            }

            if (impossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            } else {
                System.out.printf("Case #%d: %s%n", i + 1, result.toString());
            }
        }
    }
}