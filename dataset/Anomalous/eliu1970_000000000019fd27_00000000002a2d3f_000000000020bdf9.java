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
            int[][] original = new int[N][2];
            String[] assignments = new String[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
                intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
                original[i][0] = intervals[i][0];
                original[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int cEndTime = 0;
            int jEndTime = 0;
            String result = "";

            for (int i = 0; i < N; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];
                int index = findOriginalIndex(original, start, end);
                original[index][0] = Integer.MAX_VALUE; // Mark as used

                if (start >= cEndTime) {
                    assignments[index] = "C";
                    cEndTime = end;
                } else if (start >= jEndTime) {
                    assignments[index] = "J";
                    jEndTime = end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder sb = new StringBuilder();
                for (String assignment : assignments) {
                    sb.append(assignment);
                }
                result = sb.toString();
            }

            writer.println("Case #" + t + ": " + result);
        }
        writer.close();
    }

    private static int findOriginalIndex(int[][] original, int start, int end) {
        for (int i = 0; i < original.length; i++) {
            if (original[i][0] == start && original[i][1] == end) {
                return i;
            }
        }
        return -1; // Should never reach here if input is valid
    }
}