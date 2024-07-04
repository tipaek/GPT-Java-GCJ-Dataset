import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int k = 1; k <= T; k++) {
            int N = scanner.nextInt();
            int[][] intervals = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            String result = assignTasks(intervals);
            System.out.println("Case #" + k + ": " + result);
        }
        
        scanner.close();
    }
    
    private static String assignTasks(int[][] intervals) {
        List<Integer> cIntervals = new ArrayList<>();
        List<Integer> jIntervals = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        
        for (int[] interval : intervals) {
            if (canAssign(cIntervals, interval)) {
                addInterval(cIntervals, interval);
                output.append("C");
            } else if (canAssign(jIntervals, interval)) {
                addInterval(jIntervals, interval);
                output.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return output.toString();
    }
    
    private static boolean canAssign(List<Integer> intervals, int[] newInterval) {
        return intervals.isEmpty() || intervals.get(0) >= newInterval[1] || intervals.get(intervals.size() - 1) <= newInterval[0];
    }
    
    private static void addInterval(List<Integer> intervals, int[] newInterval) {
        intervals.add(newInterval[0]);
        intervals.add(newInterval[1]);
        Collections.sort(intervals);
    }
}