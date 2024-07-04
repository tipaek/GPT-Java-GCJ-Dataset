import java.util.*;

public class Solution {
    
    private static Map<Integer, Integer> cSchedule = new HashMap<>();
    private static Map<Integer, Integer> jSchedule = new HashMap<>();
    private static Map<Integer, Integer> scheduleEntries = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int test = 0; test < testCases; test++) {
            int n = scanner.nextInt();
            scheduleEntries.clear();
            int[] startTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                startTimes[i] = start;
                scheduleEntries.put(start, end);
            }
            
            Arrays.sort(startTimes);
            System.out.print("Case #" + (test + 1) + ": ");
            System.out.println(assignTasks(startTimes));
        }
        scanner.close();
    }

    private static String assignTasks(int[] startTimes) {
        StringBuilder result = new StringBuilder();
        
        for (int startTime : startTimes) {
            int endTime = scheduleEntries.get(startTime);
            if (canAssignToC(startTime, endTime)) {
                result.append("C");
            } else if (canAssignToJ(startTime, endTime)) {
                result.append("J");
            } else {
                cSchedule.clear();
                jSchedule.clear();
                return "IMPOSSIBLE";
            }
        }
        
        cSchedule.clear();
        jSchedule.clear();
        return result.toString();
    }

    private static boolean canAssignToC(int startTime, int endTime) {
        for (Map.Entry<Integer, Integer> entry : cSchedule.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();
            if (isOverlapping(startTime, endTime, existingStart, existingEnd)) {
                return false;
            }
        }
        cSchedule.put(startTime, endTime);
        return true;
    }

    private static boolean canAssignToJ(int startTime, int endTime) {
        for (Map.Entry<Integer, Integer> entry : jSchedule.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();
            if (isOverlapping(startTime, endTime, existingStart, existingEnd)) {
                return false;
            }
        }
        jSchedule.put(startTime, endTime);
        return true;
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }
}