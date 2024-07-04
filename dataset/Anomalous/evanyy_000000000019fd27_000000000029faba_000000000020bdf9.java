import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
            
            System.out.println("Case #" + caseNumber + ": " + assignTasks(intervals));
        }
    }

    public static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int[][] cameronIntervals = new int[intervals.length][2];
        int[][] jamieIntervals = new int[intervals.length][2];
        
        for (int i = 0; i < intervals.length; i++) {
            boolean assignedToCameron = true;
            
            for (int[] cameronInterval : cameronIntervals) {
                if (!(cameronInterval[1] <= intervals[i][0] || cameronInterval[0] >= intervals[i][1])) {
                    assignedToCameron = false;
                    break;
                }
            }
            
            if (assignedToCameron) {
                cameronIntervals[i][0] = intervals[i][0];
                cameronIntervals[i][1] = intervals[i][1];
                result.append('C');
            } else {
                boolean assignedToJamie = true;
                
                for (int[] jamieInterval : jamieIntervals) {
                    if (!(jamieInterval[1] <= intervals[i][0] || jamieInterval[0] >= intervals[i][1])) {
                        return "IMPOSSIBLE";
                    }
                }
                
                jamieIntervals[i][0] = intervals[i][0];
                jamieIntervals[i][1] = intervals[i][1];
                result.append('J');
            }
        }
        
        return result.toString();
    }
}