import java.util.*;
import java.io.*;

public class Solution {
    public static int[][] buildIntervals(int N, Scanner in) {
        int[][] intervals = new int[N][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                intervals[i][j] = in.nextInt();
            }
        }

        return intervals;
    }

    public static void process(int testCaseCount, int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int res = a[0] - b[0];
            if(res == 0) return a[1] - b[1];
            return res;
        });

        int jLast = -1;
        int cLast = - 1;

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if(cLast == -1) {
                cLast = interval[1];
                builder.append("C");
            } else if(jLast == -1) {
                jLast = interval[1];
                builder.append("J");
            } else if(interval[0] >= cLast) {
                cLast = Math.max(cLast, interval[1]);
                builder.append("C");
            } else if(interval[0] >= jLast) {
                jLast = Math.max(jLast, interval[1]);
                builder.append("J");
            } else {
                System.out.println("Case #" + testCaseCount + ": IMPOSSIBLE");
                return;
            }
        }

        System.out.println("Case #" + testCaseCount + ": " + builder.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = in.nextInt();

        for (int i = 1; i <= testCaseCount; ++i) {
            int N = in.nextInt();

            int[][] intervals = buildIntervals(N, in);

            process(i, intervals);
        }
    }
}