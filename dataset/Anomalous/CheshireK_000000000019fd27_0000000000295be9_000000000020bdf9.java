import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    public static boolean isCompatible(List<Integer[]> currentTimestamps, Integer[] newTimestamp) {
        for (Integer[] timestamp : currentTimestamps) {
            int start = newTimestamp[0];
            int end = newTimestamp[1];
            int tStart = timestamp[0];
            int tEnd = timestamp[1];

            if ((start == tStart && end == tEnd) || (start == tStart) || (end == tEnd) ||
                (start < tStart && end > tEnd) || (start > tStart && start < tEnd) ||
                (start < tStart && end > tStart) || (start > tStart && end < tEnd)) {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<Integer[]> activities) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<Integer[]> jamieActivities = new ArrayList<>();
        List<Integer[]> cameronActivities = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean impossible = false;

        for (Integer[] activity : activities) {
            if (isCompatible(jamieActivities, activity)) {
                jamieActivities.add(activity);
                freeJamie -= activity[1] - activity[0];
                result.append("C");
            } else if (isCompatible(cameronActivities, activity)) {
                cameronActivities.add(activity);
                freeCameron -= activity[1] - activity[0];
                result.append("J");
            } else {
                impossible = true;
            }
        }

        if (freeCameron < 0 || freeJamie < 0) {
            impossible = true;
        }

        return impossible ? "IMPOSSIBLE" : result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            List<Integer[]> activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                Integer[] activity = new Integer[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activities.add(activity);
            }

            System.out.println("Case #" + i + ": " + solve(activities));
        }
        
        scanner.close();
    }
}