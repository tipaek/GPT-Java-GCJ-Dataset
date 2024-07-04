import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            System.out.println("Case #" + i + ": " + assignTasks(intervals));
        }
    }

    public static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int[][] cameron = new int[intervals.length][2];
        int[][] jamie = new int[intervals.length][2];
        int cameronCount = 0;
        int jamieCount = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            boolean assignedToCameron = true;
            
            for (int j = 0; j < cameronCount; j++) {
                if (!(cameron[j][1] <= intervals[i][0] || cameron[j][0] >= intervals[i][1])) {
                    for (int k = 0; k < jamieCount; k++) {
                        if (!(jamie[k][1] <= intervals[i][0] || jamie[k][0] >= intervals[i][1])) {
                            return "IMPOSSIBLE";
                        }
                    }
                    jamie[jamieCount][0] = intervals[i][0];
                    jamie[jamieCount][1] = intervals[i][1];
                    jamieCount++;
                    result.append('C');
                    assignedToCameron = false;
                    break;
                }
            }
            
            if (assignedToCameron) {
                cameron[cameronCount][0] = intervals[i][0];
                cameron[cameronCount][1] = intervals[i][1];
                cameronCount++;
                result.append('J');
            }
        }
        
        return result.toString();
    }
}