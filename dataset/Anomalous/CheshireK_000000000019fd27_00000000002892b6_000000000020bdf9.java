import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static boolean isCompatible(List<Integer[]> currentTimestamps, Integer[] newTimestamp) {
        for (Integer[] timestamp : currentTimestamps) {
            int start = newTimestamp[0];
            int end = newTimestamp[1];
            int tsStart = timestamp[0];
            int tsEnd = timestamp[1];

            boolean overlaps = (start < tsEnd && end > tsStart);
            boolean exactMatch = start == tsStart && end == tsEnd;
            boolean contains = start < tsStart && end > tsEnd;

            if (overlaps || exactMatch || contains) {
                return false;
            }
        }
        return true;
    }

    public static String solve(List<Integer[]> activities) {
        int freeJamie = 24 * 60;
        int freeCameron = 24 * 60;
        List<Integer[]> JamieSchedule = new ArrayList<>();
        List<Integer[]> CameronSchedule = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean impossible = false;

        for (Integer[] activity : activities) {
            if (isCompatible(JamieSchedule, activity)) {
                JamieSchedule.add(activity);
                freeJamie -= activity[1] - activity[0];
                result.append("C");
            } else if (isCompatible(CameronSchedule, activity)) {
                CameronSchedule.add(activity);
                freeCameron -= activity[1] - activity[0];
                result.append("J");
            } else {
                impossible = true;
                break;
            }
        }

        if (freeCameron < 0 || freeJamie < 0 || impossible) {
            return "IMPOSSIBLE";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Integer[]> activities = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                Integer[] activity = new Integer[2];
                activity[0] = in.nextInt();
                activity[1] = in.nextInt();
                activities.add(activity);
            }
            System.out.println("Case #" + i + ": " + solve(activities));
        }
    }
}