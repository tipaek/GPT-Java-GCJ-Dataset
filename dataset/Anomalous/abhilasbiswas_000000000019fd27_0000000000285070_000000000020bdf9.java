import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = solveCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String solveCase(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        int n = input.nextInt();
        int[][] intervals = new int[n][2];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sortIntervals(intervals);

        if (intervals == null) {
            return "IMPOSSIBLE";
        }

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (canAssign(c, start, end)) {
                fill(c, start, end);
                result[i] = 'C';
            } else if (canAssign(j, start, end)) {
                fill(j, start, end);
                result[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(result);
    }

    private static boolean canAssign(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    private static void fill(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    private static int[][] sortIntervals(int[][] intervals) {
        int n = intervals.length;
        int[][] sorted = new int[n][2];
        int[][] positions = new int[n][2];

        for (int i = 0; i < n; i++) {
            positions[i][0] = i;
            positions[i][1] = intervals[i][0];
        }

        Arrays.sort(positions, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < n; i++) {
            sorted[i] = intervals[positions[i][0]];
        }

        return sorted;
    }
}