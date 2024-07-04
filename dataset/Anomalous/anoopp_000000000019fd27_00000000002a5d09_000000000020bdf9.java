import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int activities = scanner.nextInt();
            TreeMap<Integer, Integer> scheduleJ = new TreeMap<>();
            TreeMap<Integer, Integer> scheduleC = new TreeMap<>();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            
            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (impossible) {
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
                    impossible = true;
                }
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }

    private static boolean canAssign(TreeMap<Integer, Integer> schedule, int start, int end) {
        Entry<Integer, Integer> floorEntry = schedule.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }
        
        Entry<Integer, Integer> ceilingEntry = schedule.ceilingEntry(start);
        if (ceilingEntry != null && ceilingEntry.getKey() < end) {
            return false;
        }
        
        return true;
    }
}