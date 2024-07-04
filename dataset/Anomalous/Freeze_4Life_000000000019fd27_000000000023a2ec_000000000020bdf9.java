package parenting;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int t = 0; t < testCases; t++) {
                int activitiesCount = scanner.nextInt();
                int[][] activities = new int[activitiesCount][4];
                for (int n = 0; n < activitiesCount; n++) {
                    activities[n][0] = scanner.nextInt();
                    activities[n][1] = scanner.nextInt();
                    activities[n][2] = n;
                    activities[n][3] = 0;
                }
                processActivities(activities, t);
            }
        }
    }

    private static void processActivities(int[][] activities, int caseNumber) {
        StringBuilder result = new StringBuilder();
        result.append("Case #").append(caseNumber + 1).append(": ");
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
        
        int cEnd = 0, jEnd = 0;
        for (int[] activity : activities) {
            int start = activity[0];
            int end = activity[1];
            if (start >= cEnd) {
                cEnd = end;
                activity[3] = 1;
            } else if (start >= jEnd) {
                jEnd = end;
                activity[3] = 2;
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber + 1));
                return;
            }
        }
        
        Arrays.sort(activities, (a, b) -> Integer.compare(a[2], b[2]));
        for (int[] activity : activities) {
            result.append(activity[3] == 1 ? "C" : "J");
        }
        
        System.out.println(result.toString());
    }
}