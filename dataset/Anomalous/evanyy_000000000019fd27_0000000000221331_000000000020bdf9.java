import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
            }
            
            System.out.println("Case #" + caseNum + ": " + assignTasks(intervals));
        }
    }

    public static String assignTasks(int[][] intervals) {
        StringBuilder result = new StringBuilder();
        int[][] cameron = new int[intervals.length][2];
        int[][] jamie = new int[intervals.length][2];
        int cameronIndex = 0;
        int jamieIndex = 0;

        for (int i = 0; i < intervals.length; i++) {
            boolean assignedToCameron = true;

            for (int c = 0; c < cameronIndex; c++) {
                if (!(cameron[c][1] <= intervals[i][0] || cameron[c][0] >= intervals[i][1])) {
                    for (int j = 0; j < jamieIndex; j++) {
                        if (!(jamie[j][1] <= intervals[i][0] || jamie[j][0] >= intervals[i][1])) {
                            return "IMPOSSIBLE";
                        }
                    }
                    jamie[jamieIndex][0] = intervals[i][0];
                    jamie[jamieIndex][1] = intervals[i][1];
                    jamieIndex++;
                    result.append("J");
                    assignedToCameron = false;
                    break;
                }
            }

            if (assignedToCameron) {
                cameron[cameronIndex][0] = intervals[i][0];
                cameron[cameronIndex][1] = intervals[i][1];
                cameronIndex++;
                result.append("C");
            }
        }
        return result.toString();
    }
}