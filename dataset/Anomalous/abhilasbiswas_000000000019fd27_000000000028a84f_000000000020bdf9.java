import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int i = 1; i <= T; i++) {
            String result = processTestCase(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String processTestCase(Scanner input) {
        boolean[] c = new boolean[1441];
        boolean[] j = new boolean[1441];
        char[] result = new char[input.nextInt()];
        int[][] intervals = new int[result.length][2];

        for (int i = 0; i < intervals.length; i++) {
            intervals[i][0] = input.nextInt();
            intervals[i][1] = input.nextInt();
        }

        intervals = sortIntervals(intervals);
        if (intervals == null) {
            return "IMPOSSIBLE";
        }

        int cEnd = 0, jEnd = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (isAvailable(c, start, end)) {
                fill(c, start, end);
                result[i] = 'C';
                cEnd = end;
            } else if (isAvailable(j, start, end)) {
                fill(j, start, end);
                result[i] = 'J';
                jEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(result);
    }

    public static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }

    public static void fill(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }

    public static int[][] sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        return intervals;
    }
}