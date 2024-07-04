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
                    if (isOverlapping(intervals[j], intervals[k])) {
                        overlaps[overlapCount][0] = j;
                        overlaps[overlapCount][1] = k;
                        overlapCount++;
                    }
                }
            }

            char[] assignments = new char[n];
            Arrays.fill(assignments, 'C');

            boolean isImpossible = false;
            for (int j = 0; j < overlapCount; j++) {
                int a = overlaps[j][0];
                int b = overlaps[j][1];

                if (assignments[a] == assignments[b]) {
                    assignments[b] = (assignments[a] == 'C') ? 'J' : 'C';
                    if (assignments[a] == assignments[b]) {
                        isImpossible = true;
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("Case #").append(i + 1).append(": IMPOSSIBLE");
            } else {
                result.append("Case #").append(i + 1).append(": ");
                for (char assignment : assignments) {
                    result.append(assignment);
                }
            }
            System.out.println(result.toString());
        }
    }

    private static boolean isOverlapping(int[] interval1, int[] interval2) {
        return (interval1[1] > interval2[0] && interval1[0] < interval2[1]);
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static int nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
}