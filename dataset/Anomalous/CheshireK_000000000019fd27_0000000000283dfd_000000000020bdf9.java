import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static boolean isCompatible(List<Integer[]> schedule, Integer[] newInterval) {
        for (Integer[] interval : schedule) {
            int start = newInterval[0];
            int end = newInterval[1];
            int intervalStart = interval[0];
            int intervalEnd = interval[1];

            if ((start >= intervalStart && start < intervalEnd) || 
                (end > intervalStart && end <= intervalEnd) || 
                (start <= intervalStart && end >= intervalEnd)) {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<Integer[]> activities) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<Integer[]> jamieSchedule = new ArrayList<>();
        List<Integer[]> cameronSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean impossible = false;

        for (Integer[] activity : activities) {
            if (isCompatible(jamieSchedule, activity)) {
                jamieSchedule.add(activity);
                freeJamie -= activity[1] - activity[0];
                result.append("C");
            } else if (isCompatible(cameronSchedule, activity)) {
                cameronSchedule.add(activity);
                freeCameron -= activity[1] - activity[0];
                result.append("J");
            } else {
                impossible = true;
                break;
            }
        }

        if (freeJamie < 0 || freeCameron < 0 || impossible) {
            return "IMPOSSIBLE";
        }
        return result.toString();
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
    }
}