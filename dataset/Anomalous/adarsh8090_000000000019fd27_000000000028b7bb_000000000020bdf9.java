import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int conflictFlag = 0;
            StringBuilder schedule = new StringBuilder();
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[] startTimes = new int[n];
            String[] assignments = new String[n];
            int cameronEnd = 0, jamieEnd = 0;
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                startTimes[i] = intervals[i][0];
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(startTimes);
            
            for (int g = 0; g < n; g++) {
                for (int j = 0; j < n; j++) {
                    if (startTimes[g] == intervals[j][0]) {
                        if (intervals[j][0] >= cameronEnd || intervals[j][1] <= cameronEnd) {
                            cameronEnd = intervals[j][1];
                            assignments[j] = "C";
                        } else if (intervals[j][0] < cameronEnd && (intervals[j][0] >= jamieEnd || intervals[j][1] <= jamieEnd)) {
                            jamieEnd = intervals[j][1];
                            assignments[j] = "J";
                        } else {
                            conflictFlag = 1;
                        }
                    }
                }
            }
            
            if (conflictFlag == 1) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                for (String assignment : assignments) {
                    schedule.append(assignment);
                }
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
        
        scanner.close();
    }
}