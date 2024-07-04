import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];
        
        for (int i = 0; i < numCases; i++) {
            results[i] = handleCase(scanner);
        }
        
        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
        
        scanner.close();
    }

    private static String handleCase(Scanner scanner) {
        int numActivities = Integer.parseInt(scanner.nextLine());
        List<String> cIntervals = new ArrayList<>();
        List<String> jIntervals = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        
        for (int j = 0; j < numActivities; j++) {
            String activity = scanner.nextLine();
            if (canSchedule(cIntervals, activity)) {
                result.append("C");
                cIntervals.add(activity);
            } else if (canSchedule(jIntervals, activity)) {
                result.append("J");
                jIntervals.add(activity);
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }

    private static boolean canSchedule(List<String> intervals, String newInterval) {
        for (String interval : intervals) {
            if (overlaps(interval, newInterval)) {
                return false;
            }
        }
        return true;
    }

    private static boolean overlaps(String interval1, String interval2) {
        int start1 = Integer.parseInt(interval1.split(" ")[0]);
        int end1 = Integer.parseInt(interval1.split(" ")[1]);
        int start2 = Integer.parseInt(interval2.split(" ")[0]);
        int end2 = Integer.parseInt(interval2.split(" ")[1]);
        
        return !(end1 <= start2 || end2 <= start1);
    }
}