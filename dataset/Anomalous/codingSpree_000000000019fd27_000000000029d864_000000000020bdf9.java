import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[][] activities = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = scanner.nextInt();
                activities[i][1] = scanner.nextInt();
                activities[i][2] = i;
            }
            
            String result = findSchedule(activities, n);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
    
    private static String findSchedule(int[][] activities, int n) {
        Arrays.sort(activities, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        char[] schedule = new char[n];
        int endC = 0, endJ = 0;
        
        for (int i = 0; i < n; i++) {
            if (endC <= activities[i][0]) {
                schedule[i] = 'C';
                endC = activities[i][1];
            } else if (endJ <= activities[i][0]) {
                schedule[i] = 'J';
                endJ = activities[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder finalSchedule = new StringBuilder();
        for (int i = 0; i < n; i++) {
            finalSchedule.append('C');
        }
        
        for (int i = 0; i < n; i++) {
            finalSchedule.setCharAt(activities[i][2], schedule[i]);
        }
        
        return finalSchedule.toString();
    }
}