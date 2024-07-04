import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[][] intervals) {
        // Sort intervals by start time, and by end time if start times are equal
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        char[] result = new char[intervals.length];
        int endC = 0, endJ = 0;

        for (int[] interval : intervals) {
            if (interval[0] >= endC) {
                endC = interval[1];
                result[interval[2]] = 'C';
            } else if (interval[0] >= endJ) {
                endJ = interval[1];
                result[interval[2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();

        InputStream inputStream = DEBUG ? new FileInputStream("src/main/resources/codejam/y2020/qualification/parentingparentingreturns-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                int n = scanner.nextInt();
                int[][] intervals = new int[n][3];
                for (int i = 0; i < n; i++) {
                    intervals[i][0] = scanner.nextInt();
                    intervals[i][1] = scanner.nextInt();
                    intervals[i][2] = i;
                }
                System.out.println("Case #" + testCase + ": " + solve(intervals));
            }
        }

        System.err.println("Execution completed in " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
    }
}