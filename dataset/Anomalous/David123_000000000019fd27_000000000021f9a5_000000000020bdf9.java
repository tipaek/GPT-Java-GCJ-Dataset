import java.util.*;
import java.io.*;

public class Solution {

    public static String findSolution(TreeMap<Integer, int[]> activities, int numActivities) {
        StringBuilder solution = new StringBuilder();
        String[] assignment = new String[numActivities];

        boolean isJamieAvailable = true;
        boolean isCamAvailable = true;
        int jamieEndTime = -10;
        int camEndTime = -10;

        for (Map.Entry<Integer, int[]> activity : activities.entrySet()) {
            int startTime = activity.getValue()[0];
            int endTime = activity.getValue()[1];
            int activityIndex = activity.getValue()[2];

            if (startTime >= jamieEndTime) {
                isJamieAvailable = true;
            }

            if (startTime >= camEndTime) {
                isCamAvailable = true;
            }

            if (isJamieAvailable) {
                jamieEndTime = endTime;
                isJamieAvailable = false;
                assignment[activityIndex] = "J";
            } else if (isCamAvailable) {
                camEndTime = endTime;
                isCamAvailable = false;
                assignment[activityIndex] = "C";
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (String s : assignment) {
            solution.append(s);
        }

        return solution.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTestCase = in.nextInt();

        for (int i = 1; i <= numTestCase; ++i) {
            int numActivities = in.nextInt();
            TreeMap<Integer, int[]> activities = new TreeMap<>();

            for (int k = 0; k < numActivities; k++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                activities.put(startTime, new int[]{startTime, endTime, k});
            }

            String solution = findSolution(activities, numActivities);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}