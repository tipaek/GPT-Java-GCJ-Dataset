import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String[] results = new String[t];
        
        for (int testCase = 0; testCase < t; testCase++) {
            int n = input.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = input.nextInt();
                intervals[i][1] = input.nextInt();
            }
            
            String schedule = assignTasks(intervals);
            results[testCase] = schedule;
        }
        
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }
    
    private static String assignTasks(int[][] intervals) {
        int n = intervals.length;
        int[] cameron = new int[2];
        int[] jamie = new int[2];
        StringBuilder assignments = new StringBuilder();
        
        cameron[0] = intervals[0][0];
        cameron[1] = intervals[0][1];
        assignments.append('C');
        
        if (n > 1) {
            jamie[0] = intervals[1][0];
            jamie[1] = intervals[1][1];
            assignments.append('J');
        }
        
        for (int i = 2; i < n; i++) {
            if (intervals[i][0] >= cameron[1] || intervals[i][1] <= cameron[0]) {
                assignments.append('C');
                cameron[0] = intervals[i][0];
                cameron[1] = intervals[i][1];
            } else if (intervals[i][0] >= jamie[1] || intervals[i][1] <= jamie[0]) {
                assignments.append('J');
                jamie[0] = intervals[i][0];
                jamie[1] = intervals[i][1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return assignments.toString();
    }
}