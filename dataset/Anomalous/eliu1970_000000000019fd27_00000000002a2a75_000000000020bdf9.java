import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] intervals = new int[N][2];
            int[][] originalIntervals = new int[N][2];
            String[] assignments = new String[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
                intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            String result = "";
            int cEnd = 0, jEnd = 0;

            for (int i = 0; i < N; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int originalIndex = findOriginalIndex(originalIntervals, start, end);

                if (start >= cEnd) {
                    assignments[originalIndex] = "C";
                    cEnd = end;
                } else if (start >= jEnd) {
                    assignments[originalIndex] = "J";
                    jEnd = end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = String.join("", assignments);
            }

            writer.println("Case #" + t + ": " + result);
        }

        writer.close();
    }

    private static int findOriginalIndex(int[][] originalIntervals, int start, int end) {
        for (int i = 0; i < originalIntervals.length; i++) {
            if (originalIntervals[i][0] == start && originalIntervals[i][1] == end) {
                originalIntervals[i][0] = Integer.MAX_VALUE; // Mark as visited
                return i;
            }
        }
        return -1;
    }
}