import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            int numberOfActivities = scanner.nextInt();
            TreeMap<Integer, Integer> activities = new TreeMap<>();
            for (int activityIndex = 0; activityIndex < numberOfActivities; activityIndex++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                activities.put(startTime, endTime);
            }
            System.out.println("Case #" + caseIndex + ": " + assignActivities(activities));
        }
    }

    private static StringBuilder assignActivities(SortedMap<Integer, Integer> activities) {
        StringBuilder result = new StringBuilder();
        int cEndTime = Integer.MIN_VALUE;
        int jEndTime = Integer.MIN_VALUE;
        
        for (var entry : activities.entrySet()) {
            int startTime = entry.getKey();
            int endTime = entry.getValue();
            
            if (cEndTime == Integer.MIN_VALUE || cEndTime <= startTime) {
                cEndTime = endTime;
                result.append("C");
            } else if (jEndTime == Integer.MIN_VALUE || jEndTime <= startTime) {
                jEndTime = endTime;
                result.append("J");
            } else {
                return new StringBuilder("IMPOSSIBLE");
            }
        }
        return result;
    }
}