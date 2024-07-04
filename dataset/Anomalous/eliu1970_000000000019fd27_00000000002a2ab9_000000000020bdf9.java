import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = Integer.parseInt(br.readLine());
            int[][] activities = new int[activityCount][2];
            int[][] originalActivities = new int[activityCount][2];
            String[] assigned = new String[activityCount];

            for (int i = 0; i < activityCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                activities[i][0] = Integer.parseInt(st.nextToken());
                activities[i][1] = Integer.parseInt(st.nextToken());
                originalActivities[i][0] = activities[i][0];
                originalActivities[i][1] = activities[i][1];
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int cEndTime = 0, jEndTime = 0;
            String result = "";

            for (int i = 0; i < activityCount; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                int index = findAndMark(originalActivities, start, end);

                if (start >= cEndTime) {
                    assigned[index] = "C";
                    cEndTime = end;
                } else if (start >= jEndTime) {
                    assigned[index] = "J";
                    jEndTime = end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                StringBuilder sb = new StringBuilder();
                for (String s : assigned) {
                    sb.append(s);
                }
                result = sb.toString();
            }

            out.println("Case #" + testCase + ": " + result);
        }
        out.close();
    }

    private static int findAndMark(int[][] originalActivities, int start, int end) {
        for (int i = 0; i < originalActivities.length; i++) {
            if (originalActivities[i][0] == start && originalActivities[i][1] == end) {
                originalActivities[i][0] = Integer.MAX_VALUE; // mark as used
                return i;
            }
        }
        return -1; // should never reach here
    }
}