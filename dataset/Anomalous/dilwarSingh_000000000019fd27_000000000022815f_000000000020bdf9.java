import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][][] intervals = new int[n][2][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0][0] = scanner.nextInt();
                intervals[j][1][0] = scanner.nextInt();
                intervals[j][1][1] = j;
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0][0]));
            
            String result = assignActivities(intervals);
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    private static String assignActivities(int[][][] intervals) {
        String[] assignments = new String[intervals.length];
        int[] cameron = {-1, -1};
        int[] jamie = {-1, -1};
        
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0][0];
            int end = intervals[i][1][0];
            int index = intervals[i][1][1];
            
            if (isAvailable(cameron, start, end)) {
                assignments[index] = "C";
                cameron[0] = start;
                cameron[1] = end;
            } else if (isAvailable(jamie, start, end)) {
                assignments[index] = "J";
                jamie[0] = start;
                jamie[1] = end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String assignment : assignments) {
            result.append(assignment);
        }
        
        return result.toString();
    }
    
    private static boolean isAvailable(int[] person, int start, int end) {
        return person[0] == -1 || start >= person[1];
    }
}