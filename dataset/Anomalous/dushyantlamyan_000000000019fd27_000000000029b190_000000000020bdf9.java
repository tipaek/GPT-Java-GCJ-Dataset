import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numActivities = scanner.nextInt();
            int[][] activities = new int[numActivities][2];
            int[][] tempActivities = new int[numActivities][2];
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < numActivities; j++) {
                for (int k = 0; k < 2; k++){
                    activities[j][k] = scanner.nextInt();
                    tempActivities[j][k] = activities[j][k];
                }
            }
            
            String outcome = "";
            int overlapCount = 0;
            int lastOverlapIndex = 0;
            
            for (int j = 0; j < numActivities; j++) {
                for (int k = 0; k <= j; k++) {
                    if (j == k) {
                        if (j == 0) {
                            overlapCount = 0;
                            break;
                        }
                        break;
                    }
                    if ((activities[j][0] > tempActivities[k][0] && activities[j][0] < tempActivities[k][1]) ||
                        (activities[j][1] > tempActivities[k][0] && activities[j][1] < tempActivities[k][1])) {
                        overlapCount += 1;
                        lastOverlapIndex = k;
                    }
                }
                
                if (j == 0 || overlapCount == 0) {
                    if (j == 0) {
                        result.append('C');
                    } else if (result.charAt(lastOverlapIndex) == 'C') {
                        result.append('C');
                    } else {
                        result.append('J');
                    }
                } else if (overlapCount == 1) {
                    if (result.charAt(lastOverlapIndex) == 'C') {
                        result.append('J');
                    } else {
                        result.append('C');
                    }
                } else {
                    outcome = "IMPOSSIBLE";
                }
                overlapCount = 0;
            }
            System.out.println("Case #" + i + ": " + (outcome.equals("IMPOSSIBLE") ? outcome : result.toString()));
        }
    }
}