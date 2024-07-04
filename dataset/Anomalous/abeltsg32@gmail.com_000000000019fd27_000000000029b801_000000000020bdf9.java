import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static String schedule(int[][] intervals, int caseNumber) {
        int n = intervals.length;
        int[] assignment = new int[n]; // 1 for Jamie, 2 for Cameron
        int[][] indexedIntervals = new int[n][3];

        for (int i = 0; i < n; i++) {
            indexedIntervals[i][0] = i;
            indexedIntervals[i][1] = intervals[i][0];
            indexedIntervals[i][2] = intervals[i][1];
        }

        Arrays.sort(indexedIntervals, Comparator.comparingInt(a -> a[1]));

        int cameronEnd = 0;
        int jamieEnd = 0;

        for (int[] interval : indexedIntervals) {
            int index = interval[0];
            int start = interval[1];
            int end = interval[2];

            if (jamieEnd <= start) {
                assignment[index] = 1;
                jamieEnd = end;
            } else if (cameronEnd <= start) {
                assignment[index] = 2;
                cameronEnd = end;
            } else {
                return "Case #" + (caseNumber + 1) + ": IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder("Case #" + (caseNumber + 1) + ": ");
        for (int assign : assignment) {
            result.append(assign == 1 ? "C" : "J");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 0; caseNumber < numTestCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] intervals = new int[size][2];

            for (int i = 0; i < size; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }

            result.append(schedule(intervals, caseNumber)).append("\n");
        }

        System.out.print(result.toString());
    }
}