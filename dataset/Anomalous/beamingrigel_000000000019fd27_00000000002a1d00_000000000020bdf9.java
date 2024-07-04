import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = Integer.parseInt(scanner.nextLine().trim());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] chores = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                chores[j][0] = Integer.parseInt(line[0]);
                chores[j][1] = Integer.parseInt(line[1]);
            }
            
            calculateChores(chores, i + 1);
        }
        
        scanner.close();
    }
    
    public static void calculateChores(int[][] chores, int caseNumber) {
        boolean[] cameronSchedule = new boolean[24 * 60 + 1];
        boolean[] jamieSchedule = new boolean[24 * 60 + 1];
        StringBuilder result = new StringBuilder();
        
        for (int[] chore : chores) {
            int start = chore[0];
            int end = chore[1];
            
            if (isAvailable(cameronSchedule, start, end)) {
                assignSchedule(cameronSchedule, start, end);
                result.append("C");
            } else if (isAvailable(jamieSchedule, start, end)) {
                assignSchedule(jamieSchedule, start, end);
                result.append("J");
            } else {
                result = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }
        
        System.out.println("Case #" + caseNumber + ": " + result);
    }
    
    public static boolean isAvailable(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            if (schedule[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void assignSchedule(boolean[] schedule, int start, int end) {
        for (int i = start; i < end; i++) {
            schedule[i] = true;
        }
    }
}