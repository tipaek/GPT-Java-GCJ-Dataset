import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numCases];
        
        for (int i = 0; i < numCases; i++) {
            int numActivities = Integer.parseInt(scanner.nextLine());
            List<String> cIntervals = new ArrayList<>();
            List<String> jIntervals = new ArrayList<>();
            results[i] = "";
            
            for (int j = 0; j < numActivities; j++) {
                String activity = scanner.nextLine();
                if (isActivityPossible(cIntervals, activity)) {
                    results[i] += "C";
                    cIntervals.add(activity);
                } else if (isActivityPossible(jIntervals, activity)) {
                    results[i] += "J";
                    jIntervals.add(activity);
                } else {
                    results[i] = "IMPOSSIBLE";
                    // Skip remaining activities for this case
                    scanner.nextLine(); // consume the remaining lines
                    break;
                }
            }
        }

        for (int i = 0; i < numCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
        
        scanner.close();
    }

    private static boolean isActivityPossible(List<String> intervals, String interval) {
        for (String existingInterval : intervals) {
            if (isOverlapping(existingInterval, interval)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOverlapping(String interval1, String interval2) {
        int start1 = Integer.parseInt(interval1.split(" ")[0]);
        int end1 = Integer.parseInt(interval1.split(" ")[1]);
        int start2 = Integer.parseInt(interval2.split(" ")[0]);
        int end2 = Integer.parseInt(interval2.split(" ")[1]);

        return !(end1 <= start2 || end2 <= start1);
    }
}