import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int j = 0; j < activityCount; j++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.add(new int[]{startTime, endTime});
            }
            System.out.println("Case #" + testCase + ": " + assignActivities(activities));
        }
    }

    private static String assignActivities(List<int[]> activities) {
        StringBuilder schedule = new StringBuilder("J");
        int cEnd = 0, cStart = 0, jEnd = activities.get(0)[1], jStart = activities.get(0)[0];
        int end = jEnd, start = jStart;

        for (int i = 1; i < activities.size(); i++) {
            int currentStart = activities.get(i)[0];
            int currentEnd = activities.get(i)[1];

            if (currentEnd < cStart) {
                schedule.append("C");
                cStart = Math.min(cStart, currentStart);
            } else if (currentEnd < jStart) {
                schedule.append("J");
                jStart = Math.min(jStart, currentStart);
            } else if (currentStart < end) {
                if (cEnd <= currentStart) {
                    cEnd = currentEnd;
                    cStart = Math.min(cStart, currentStart);
                    schedule.append("C");
                } else if (jEnd <= currentStart) {
                    jEnd = currentEnd;
                    jStart = Math.min(jStart, currentStart);
                    schedule.append("J");
                } else {
                    return "IMPOSSIBLE";
                }
                end = Math.max(currentEnd, end);
            } else {
                schedule.append("C");
                cEnd = currentEnd;
                end = currentEnd;
            }
        }
        return schedule.toString();
    }
}