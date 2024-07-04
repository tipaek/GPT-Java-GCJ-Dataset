import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][3];
            int[][] sortedIntervals = new int[n][3];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i][0] = start;
                intervals[i][1] = end;
                intervals[i][2] = i;
                sortedIntervals[i][0] = start;
                sortedIntervals[i][1] = end;
                sortedIntervals[i][2] = i;
            }

            sortIntervals(sortedIntervals);

            boolean isImpossible = false;
            int cEnd = sortedIntervals[0][1];
            int jEnd = 0;
            intervals[sortedIntervals[0][2]][2] = 1; // 1 for 'C', 2 for 'J'

            for (int i = 1; i < n; i++) {
                int start = sortedIntervals[i][0];
                if (start >= cEnd) {
                    cEnd = sortedIntervals[i][1];
                    intervals[sortedIntervals[i][2]][2] = 1;
                } else if (start >= jEnd) {
                    jEnd = sortedIntervals[i][1];
                    intervals[sortedIntervals[i][2]][2] = 2;
                } else {
                    isImpossible = true;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (isImpossible) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    result.append(intervals[i][2] == 1 ? 'C' : 'J');
                }
            }
            System.out.println("Case #" + t + ": " + result.toString());
        }
        scanner.close();
    }

    private static void sortIntervals(int[][] intervals) {
        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            int[] key = intervals[i];
            int j = i - 1;

            while (j >= 0 && intervals[j][0] > key[0]) {
                intervals[j + 1] = intervals[j];
                j--;
            }
            intervals[j + 1] = key;
        }
    }
}