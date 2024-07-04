import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int activitiesCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            System.out.println("Case #" + (t + 1) + ": " + assignActivities(activities));
        }
    }

    static String assignActivities(List<int[]> activities) {
        StringBuilder result = new StringBuilder("C");
        int cEnd = activities.get(0)[1];
        int jEnd = 0;

        for (int i = 1; i < activities.size(); i++) {
            int currentStart = activities.get(i)[0];
            int currentEnd = activities.get(i)[1];

            if (currentStart >= cEnd) {
                result.append("C");
                cEnd = currentEnd;
            } else if (currentStart >= jEnd) {
                result.append("J");
                jEnd = currentEnd;
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }
}