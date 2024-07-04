import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            int minTime = Integer.MAX_VALUE;
            int maxTime = Integer.MIN_VALUE;

            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                minTime = Math.min(minTime, activities[i][0]);
                maxTime = Math.max(maxTime, activities[i][1]);
            }
            
            processActivities(minTime, maxTime, activities, testCase);
        }
    }

    private static void processActivities(int minTime, int maxTime, int[][] activities, int testCase) {
        int[] jSchedule = new int[maxTime + 1];
        int[] cSchedule = new int[maxTime + 1];
        StringBuilder result = new StringBuilder();
        
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            String assignment = assignActivity(jSchedule, cSchedule, start, end);
            
            if ("IMPOSSIBLE".equals(assignment)) {
                result.setLength(0);  // Reset result as it's impossible to schedule
                result.append("IMPOSSIBLE");
                break;
            } else {
                result.append(assignment);
                if ("J".equals(assignment)) {
                    for (int i = start; i <= end; i++) {
                        jSchedule[i] = 1;
                    }
                } else {
                    for (int i = start; i <= end; i++) {
                        cSchedule[i] = 1;
                    }
                }
            }
        }
        
        System.out.println("Case #" + testCase + ": " + result.toString());
    }

    private static String assignActivity(int[] jSchedule, int[] cSchedule, int start, int end) {
        int jCount = 0;
        int cCount = 0;

        for (int i = start; i <= end; i++) {
            if (jSchedule[i] == 1) jCount++;
            if (cSchedule[i] == 1) cCount++;
            if (jCount > 1 && cCount > 1) return "IMPOSSIBLE";
        }

        if (jCount <= 1) return "J";
        if (cCount <= 1) return "C";
        return "IMPOSSIBLE";
    }
}