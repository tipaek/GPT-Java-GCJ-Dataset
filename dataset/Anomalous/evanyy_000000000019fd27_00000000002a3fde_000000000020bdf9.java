import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            String result = assignTasks(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int[][] cSchedule = new int[intervals.length][2];
        int[][] jSchedule = new int[intervals.length][2];
        
        for (int i = 0; i < intervals.length; i++) {
            boolean assignedToC = true;
            
            for (int l = 0; l < intervals.length; l++) {
                if (!(cSchedule[l][1] <= intervals[i][0] || cSchedule[l][0] >= intervals[i][1])) {
                    for (int k = 0; k < intervals.length; k++) {
                        if (!(jSchedule[k][1] <= intervals[i][0] || jSchedule[k][0] >= intervals[i][1])) {
                            return "IMPOSSIBLE";
                        }
                    }
                    jSchedule[i][0] = intervals[i][0];
                    jSchedule[i][1] = intervals[i][1];
                    result.append("C");
                    assignedToC = false;
                    break;
                }
            }
            
            if (assignedToC) {
                cSchedule[i][0] = intervals[i][0];
                cSchedule[i][1] = intervals[i][1];
                result.append("J");
            }
        }
        
        return result.toString();
    }
}