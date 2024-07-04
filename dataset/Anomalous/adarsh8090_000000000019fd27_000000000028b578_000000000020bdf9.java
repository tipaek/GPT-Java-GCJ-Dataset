import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            int[] startTimes = new int[n];
            String[] assignments = new String[n];
            boolean impossible = false;
            
            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                startTimes[j] = intervals[j][0];
                intervals[j][1] = in.nextInt();
            }
            
            Arrays.sort(startTimes);
            int cameronEnd = 0, jamieEnd = 0;
            
            for (int g = 0; g < n; g++) {
                for (int j = 0; j < n; j++) {
                    if (startTimes[g] == intervals[j][0]) {
                        if (intervals[j][0] >= cameronEnd) {
                            cameronEnd = intervals[j][1];
                            assignments[j] = "C";
                        } else if (intervals[j][0] >= jamieEnd) {
                            jamieEnd = intervals[j][1];
                            assignments[j] = "J";
                        } else {
                            impossible = true;
                        }
                    }
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (String assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
        
        in.close();
    }
}