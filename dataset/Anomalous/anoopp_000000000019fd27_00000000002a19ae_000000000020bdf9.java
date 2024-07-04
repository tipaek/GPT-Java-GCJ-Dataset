import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int numActivities = scanner.nextInt();
            TreeMap<Integer, Integer> scheduleJ = new TreeMap<>();
            TreeMap<Integer, Integer> scheduleC = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;

            for (int j = 0; j < numActivities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isImpossible) {
                    continue;
                }

                if (canAssign(scheduleJ, start, end)) {
                    scheduleJ.put(start, end);
                    result.append("J");
                } else if (canAssign(scheduleC, start, end)) {
                    scheduleC.put(start, end);
                    result.append("C");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    isImpossible = true;
                }
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }
        scanner.close();
    }

    private static boolean canAssign(TreeMap<Integer, Integer> schedule, int start, int end) {
        Entry<Integer, Integer> previous = schedule.floorEntry(start);
        if (previous != null && previous.getValue() > start) {
            return false;
        }

        Entry<Integer, Integer> next = schedule.ceilingEntry(start);
        if (next != null && next.getKey() < end) {
            return false;
        }

        return true;
    }
}