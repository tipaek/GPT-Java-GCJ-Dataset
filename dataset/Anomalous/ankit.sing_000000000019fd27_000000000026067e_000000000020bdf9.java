import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int scheduleCount = scanner.nextInt();
            int[][] schedules = new int[scheduleCount][2];
            
            for (int i = 0; i < scheduleCount; i++) {
                schedules[i][0] = scanner.nextInt();
                schedules[i][1] = scanner.nextInt();
            }
            
            System.out.println("Case #" + testCase + ": " + assignSchedules(schedules));
        }
        
        scanner.close();
    }
    
    private static String assignSchedules(int[][] schedules) {
        int endC = 0, endJ = 0;
        int maxStartC = Integer.MAX_VALUE, maxStartJ = Integer.MAX_VALUE;
        int overlapCountC = 0, overlapCountJ = 0;
        StringBuilder result = new StringBuilder();
        
        HashSet<Integer> startTimes = new HashSet<>();
        HashSet<Integer> endTimes = new HashSet<>();
        
        for (int[] schedule : schedules) {
            int startTime = schedule[0];
            int endTime = schedule[1];
            
            if (!startTimes.add(startTime)) {
                if (++overlapCountC >= 2) {
                    return "IMPOSSIBLE";
                }
            }
            
            if (!endTimes.add(endTime)) {
                if (++overlapCountJ >= 2) {
                    return "IMPOSSIBLE";
                }
            }
            
            if (startTime >= endC || endTime <= maxStartC) {
                result.append("C");
                maxStartC = startTime;
                endC = endTime;
            } else if (startTime >= endJ || endTime <= maxStartJ) {
                result.append("J");
                maxStartJ = startTime;
                endJ = endTime;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result.toString();
    }
}