import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int activityCount = Integer.parseInt(reader.readLine());
            int[][] activities = new int[activityCount][2];
            int[][] originalActivities = new int[activityCount][2];
            String[] assignedTo = new String[activityCount];

            for (int i = 0; i < activityCount; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                activities[i][0] = Integer.parseInt(tokenizer.nextToken());
                activities[i][1] = Integer.parseInt(tokenizer.nextToken());
                originalActivities[i][0] = activities[i][0];
                originalActivities[i][1] = activities[i][1];
            }

            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

            int cEndTime = 0;
            int jEndTime = 0;
            String result = "";

            for (int i = 0; i < activityCount; i++) {
                int originalIndex = findOriginalIndex(originalActivities, activities[i]);
                if (activities[i][0] >= cEndTime) {
                    assignedTo[originalIndex] = "C";
                    cEndTime = activities[i][1];
                } else if (activities[i][0] >= jEndTime) {
                    assignedTo[originalIndex] = "J";
                    jEndTime = activities[i][1];
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            if (!result.equals("IMPOSSIBLE")) {
                result = String.join("", assignedTo);
            }

            writer.println("Case #" + testCase + ": " + result);
        }

        writer.close();
    }

    private static int findOriginalIndex(int[][] originalActivities, int[] activity) {
        for (int i = 0; i < originalActivities.length; i++) {
            if (originalActivities[i][0] == activity[0] && originalActivities[i][1] == activity[1]) {
                originalActivities[i][0] = Integer.MAX_VALUE; // Mark as used
                return i;
            }
        }
        return -1; // Should never reach here if input is valid
    }
}