import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; ++t) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            String result = assignIntervals(intervals);
            System.out.println("Case #" + t + ": " + result);
        }
    }
    
    private static String assignIntervals(int[][] intervals) {
        int n = intervals.length;
        int cEnd = 0, jEnd = 0;
        StringBuilder schedule = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            if (start >= cEnd) {
                schedule.append('C');
                cEnd = end;
            } else if (start >= jEnd) {
                schedule.append('J');
                jEnd = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }
}