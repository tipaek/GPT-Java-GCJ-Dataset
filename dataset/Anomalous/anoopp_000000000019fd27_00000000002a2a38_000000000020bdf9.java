import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            
            TreeMap<Integer, Integer> jActivities = new TreeMap<>();
            TreeMap<Integer, Integer> cActivities = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                if (canBeAssigned(jActivities, start, end)) {
                    jActivities.put(start, end);
                    result.append("J");
                } else if (canBeAssigned(cActivities, start, end)) {
                    cActivities.put(start, end);
                    result.append("C");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        scanner.close();
    }

    private static boolean canBeAssigned(TreeMap<Integer, Integer> activityMap, int start, int end) {
        Entry<Integer, Integer> floorEntry = activityMap.floorEntry(start);
        if (floorEntry != null) {
            if (floorEntry.getValue() <= start) {
                return true;
            } else {
                return false;
            }
        } else {
            Entry<Integer, Integer> ceilingEntry = activityMap.ceilingEntry(start);
            if (ceilingEntry != null) {
                if (ceilingEntry.getKey() >= end) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}