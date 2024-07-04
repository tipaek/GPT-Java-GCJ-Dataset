import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                String[] tokens = scanner.nextLine().split(" ");
                intervals[j][0] = Integer.parseInt(tokens[0]);
                intervals[j][1] = Integer.parseInt(tokens[1]);
            }
            
            int[][] sortedIntervals = sortIntervals(intervals);
            String result = schedule(sortedIntervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private static int[][] sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        return intervals;
    }
    
    private static String schedule(int[][] intervals) {
        int cEnd = 0;
        int jEnd = 0;
        StringBuilder schedule = new StringBuilder();
        
        for (int[] interval : intervals) {
            if (interval[0] >= cEnd) {
                cEnd = interval[1];
                schedule.append("C");
            } else if (interval[0] >= jEnd) {
                jEnd = interval[1];
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }
}