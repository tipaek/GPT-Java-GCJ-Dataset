import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int numIntervals = scanner.nextInt();
            int[][] intervals = new int[numIntervals][3];
            char[] assignments = new char[numIntervals];

            for (int i = 0; i < numIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[i] = new int[]{i, start, end};
            }

            Arrays.sort(intervals, (a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                } else {
                    return Integer.compare(a[1], b[1]);
                }
            });

            int endTimeC = Integer.MIN_VALUE;
            int endTimeJ = Integer.MIN_VALUE;
            boolean isPossible = true;

            for (int[] interval : intervals) {
                if (endTimeC <= interval[1]) {
                    assignments[interval[0]] = 'C';
                    endTimeC = interval[2];
                } else if (endTimeJ <= interval[1]) {
                    assignments[interval[0]] = 'J';
                    endTimeJ = interval[2];
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + new String(assignments));
            }
        }
    }
}