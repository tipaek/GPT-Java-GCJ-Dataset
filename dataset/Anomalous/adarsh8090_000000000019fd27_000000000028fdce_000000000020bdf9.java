import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            int[] sortedStartTimes = new int[n];
            String[] assignments = new String[n];
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = scanner.nextInt();
                intervals[j][1] = scanner.nextInt();
                sortedStartTimes[j] = intervals[j][0];
            }
            
            Arrays.sort(sortedStartTimes);
            int cameronEnd = 0, jamieEnd = 0;
            boolean isPossible = true;
            
            for (int startTime : sortedStartTimes) {
                for (int j = 0; j < n; j++) {
                    if (intervals[j][0] == startTime) {
                        if (intervals[j][0] >= cameronEnd) {
                            assignments[j] = "C";
                            cameronEnd = intervals[j][1];
                        } else if (intervals[j][0] >= jamieEnd) {
                            assignments[j] = "J";
                            jamieEnd = intervals[j][1];
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }
                if (!isPossible) break;
            }
            
            if (isPossible) {
                StringBuilder result = new StringBuilder("Case #" + i + ": ");
                for (String assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println(result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
}