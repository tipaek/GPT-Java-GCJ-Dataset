import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
                intervals[i][3] = 0;
            }

            processIntervals(intervals, t);
        }
    }

    private static void processIntervals(int[][] intervals, int caseNumber) {
        StringBuilder result = new StringBuilder();
        result.append("Case #").append(caseNumber + 1).append(": ");

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int cEnd = 0, jEnd = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= cEnd) {
                cEnd = end;
                interval[3] = 1;
            } else if (start >= jEnd) {
                jEnd = end;
                interval[3] = 2;
            } else {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber + 1);
                return;
            }
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] interval : intervals) {
            result.append(interval[3] == 1 ? "C" : "J");
        }

        System.out.println(result.toString());
    }
}