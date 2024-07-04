import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int activityCount = scanner.nextInt();
            int[][] activities = new int[activityCount][2];
            
            for (int i = 0; i < activityCount; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
            }
            
            System.out.print("Case #" + caseIndex + ": ");
            
            if (!findSchedule(activities, activityCount)) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    private static boolean findSchedule(int[][] activities, int activityCount) {
        int combinations = (int) Math.pow(2, activityCount);
        
        for (int i = 0; i < combinations; i++) {
            if (isValidSchedule(i, activities, activityCount)) {
                return true;
            }
        }
        
        return false;
    }
    
    private static boolean isValidSchedule(int combination, int[][] activities, int activityCount) {
        String binaryString = String.format("%" + activityCount + "s", Integer.toBinaryString(combination)).replace(' ', '0');
        Map<Integer, Integer> cSchedule = new HashMap<>();
        Map<Integer, Integer> jSchedule = new HashMap<>();
        
        for (int i = 0; i < activityCount; i++) {
            int start = activities[i][0];
            int end = activities[i][1];
            Map<Integer, Integer> currentSchedule = binaryString.charAt(i) == '1' ? jSchedule : cSchedule;
            
            for (int time = start; time < end; time++) {
                if (currentSchedule.containsKey(time)) {
                    return false;
                }
                currentSchedule.put(time, 0);
            }
        }
        
        for (int i = 0; i < activityCount; i++) {
            System.out.print(binaryString.charAt(i) == '1' ? "J" : "C");
        }
        
        return true;
    }
}