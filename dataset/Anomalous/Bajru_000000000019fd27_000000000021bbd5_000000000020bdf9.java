import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();

            if (n == 2) {
                System.out.println("Case #" + testCase + ": CJ");
            } else {
                int[][] intervals = new int[n][3];
                for (int i = 0; i < n; i++) {
                    intervals[i][0] = scanner.nextInt();
                    intervals[i][1] = scanner.nextInt();
                    intervals[i][2] = i;
                }
                assignTasks(intervals, n, testCase);
            }
        }
    }

    private static void sortIntervals(int[][] intervals, int column) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[column]));
    }

    private static void assignTasks(int[][] intervals, int n, int testCase) {
        int cEnd = 0, jEnd = 0;
        sortIntervals(intervals, 0);

        StringBuilder result = new StringBuilder("C");
        cEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= cEnd) {
                result.append("C");
                cEnd = intervals[i][1];
            } else if (intervals[i][0] >= jEnd) {
                result.append("J");
                jEnd = intervals[i][1];
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                return;
            }
        }

        char[] output = new char[n];
        for (int i = 0; i < n; i++) {
            output[intervals[i][2]] = result.charAt(i);
        }

        System.out.println("Case #" + testCase + ": " + new String(output));
    }
}