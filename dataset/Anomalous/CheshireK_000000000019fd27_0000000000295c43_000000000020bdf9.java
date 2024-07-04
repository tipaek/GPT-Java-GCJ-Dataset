import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<Integer[]> currentTimestamps, Integer[] newTimestamp) {
        for (Integer[] timestamp : currentTimestamps) {
            Integer start = newTimestamp[0];
            Integer end = newTimestamp[1];

            // Check for overlapping conditions
            if (start.equals(timestamp[0]) && end.equals(timestamp[1]) || 
                start.equals(timestamp[0]) || 
                end.equals(timestamp[1]) || 
                (start < timestamp[0] && end > timestamp[1]) || 
                (start > timestamp[0] && start < timestamp[1]) || 
                (start < timestamp[0] && end > timestamp[0]) || 
                (start > timestamp[0] && end < timestamp[1])) {
                return false;
            }
        }
        return true;
    }

    public static String allocateTasks(List<Integer[]> activities) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<Integer[]> Jamie = new ArrayList<>();
        List<Integer[]> Cameron = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean impossible = false;

        for (Integer[] activity : activities) {
            if (isCompatible(Jamie, activity)) {
                Jamie.add(activity);
                freeJamie -= activity[1] - activity[0];
                result.append("C");
            } else if (isCompatible(Cameron, activity)) {
                Cameron.add(activity);
                freeCameron -= activity[1] - activity[0];
                result.append("J");
            } else {
                impossible = true;
            }
        }

        if (freeCameron < 0 || freeJamie < 0 || impossible) {
            return "IMPOSSIBLE";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int activitiesCount = scanner.nextInt();
            List<Integer[]> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                Integer[] activity = new Integer[2];
                activity[0] = scanner.nextInt();
                activity[1] = scanner.nextInt();
                activities.add(activity);
            }

            System.out.println("Case #" + i + ": " + allocateTasks(activities));
        }
    }
}