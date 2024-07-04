import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {        
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activitiesCount = Integer.parseInt(scanner.nextLine());
            int[] startTimes = new int[activitiesCount];
            int[] endTimes = new int[activitiesCount];

            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                String[] times = scanner.nextLine().split(" ");
                startTimes[activityIndex] = Integer.parseInt(times[0]);
                endTimes[activityIndex] = Integer.parseInt(times[1]);
            }

            String result = assignActivities(startTimes, endTimes);
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }

    public static String assignActivities(int[] startTimes, int[] endTimes) {
        int activitiesCount = startTimes.length;
        char[] assignments = new char[activitiesCount];
        boolean isJAvailable = true;
        boolean isCAvailable = true;

        for (int currentTime = 0; currentTime <= 24 * 60; currentTime++) {
            for (int activityIndex = 0; activityIndex < activitiesCount; activityIndex++) {
                if (currentTime == startTimes[activityIndex]) {
                    if (isJAvailable) {
                        assignments[activityIndex] = 'J';
                        isJAvailable = false;
                    } else if (isCAvailable) {
                        assignments[activityIndex] = 'C';
                        isCAvailable = false;
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
                if (currentTime == endTimes[activityIndex]) {
                    if (assignments[activityIndex] == 'J') {
                        isJAvailable = true;
                    } else {
                        isCAvailable = true;
                    }
                }
            }
        }

        return new String(assignments);
    }
}