import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] intervals = new int[N][2];
            
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                intervals[j][0] = Integer.parseInt(st.nextToken());
                intervals[j][1] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            intervals = adjustIntervals(intervals);
            
            StringBuilder result = new StringBuilder();
            boolean isPossible = assignTasks(intervals, result);
            
            if (isPossible) {
                pw.println("Case #" + i + ": " + result.toString());
            } else {
                pw.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        pw.close();
    }
    
    private static boolean assignTasks(int[][] intervals, StringBuilder result) {
        int[] endTimes = new int[2];  // endTimes[0] for Cameron, endTimes[1] for Jamie
        
        for (int[] interval : intervals) {
            if (interval[0] >= endTimes[0]) {
                endTimes[0] = interval[1];
                result.append('C');
            } else if (interval[0] >= endTimes[1]) {
                endTimes[1] = interval[1];
                result.append('J');
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    private static int[][] adjustIntervals(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0] && intervals[i][1] < intervals[i - 1][1]) {
                int temp = intervals[i][1];
                intervals[i][1] = intervals[i - 1][1];
                intervals[i - 1][1] = temp;
            }
        }
        return intervals;
    }
}