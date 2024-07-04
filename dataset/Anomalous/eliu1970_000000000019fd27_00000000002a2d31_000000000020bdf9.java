import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] intervals = new int[N][2];
            int[][] originalIntervals = new int[N][2];
            String[] assignments = new String[N];
            int cEndTime = 0, jEndTime = 0;
            String result = "";

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                intervals[i][0] = Integer.parseInt(st.nextToken());
                intervals[i][1] = Integer.parseInt(st.nextToken());
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < N; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int originalIndex = findOriginalIndex(originalIntervals, start, end);
                originalIntervals[originalIndex][0] = Integer.MAX_VALUE;

                if (start >= cEndTime && !result.equals("IMPOSSIBLE")) {
                    assignments[originalIndex] = "C";
                    cEndTime = end;
                } else if (start >= jEndTime && !result.equals("IMPOSSIBLE")) {
                    assignments[originalIndex] = "J";
                    jEndTime = end;
                } else {
                    result = "IMPOSSIBLE";
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = String.join("", assignments);
            }

            out.println("Case #" + t + ": " + result);
        }
        out.close();
    }

    private static int findOriginalIndex(int[][] originalIntervals, int start, int end) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (originalIntervals[i][0] == start && originalIntervals[i][1] == end) {
                return i;
            }
        }
        return -1;
    }
}