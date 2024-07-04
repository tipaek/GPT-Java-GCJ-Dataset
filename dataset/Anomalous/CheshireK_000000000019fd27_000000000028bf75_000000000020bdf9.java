import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<int[]> currentTimestamps, int[] newTimestamp) {
        for (int[] timestamp : currentTimestamps) {
            int start = newTimestamp[0];
            int end = newTimestamp[1];
            
            if ((start > timestamp[0] && start < timestamp[1]) || 
                (end > timestamp[0] && end < timestamp[1]) || 
                (start <= timestamp[0] && end >= timestamp[1])) {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<int[]> activities) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<int[]> Jamie = new ArrayList<>();
        List<int[]> Cameron = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (int[] activity : activities) {
            if (isCompatible(Jamie, activity)) {
                Jamie.add(activity);
                freeJamie -= (activity[1] - activity[0]);
                result.append("C");
            } else if (isCompatible(Cameron, activity)) {
                Cameron.add(activity);
                freeCameron -= (activity[1] - activity[0]);
                result.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }
            System.out.println("Case #" + i + ": " + solve(activities));
        }
        scanner.close();
    }
}