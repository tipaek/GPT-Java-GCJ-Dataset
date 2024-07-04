import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] assignments = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt() - 1;
            }
            
            boolean impossible = false;
            
            for (int i = 1; i < n; i++) {
                boolean firstAssignment = false;
                
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        boolean overlap = (startTimes[i] <= startTimes[j] && endTimes[i] >= startTimes[j])
                                        || (startTimes[i] <= endTimes[j] && endTimes[i] >= endTimes[j])
                                        || (startTimes[i] >= startTimes[j] && endTimes[i] <= endTimes[j]);
                        
                        if (overlap) {
                            if (!firstAssignment) {
                                assignments[i] = 1 - assignments[j];
                                firstAssignment = true;
                            } else if (assignments[i] == assignments[j]) {
                                impossible = true;
                            }
                        }
                    }
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 1 ? 'J' : 'C');
                }
                System.out.println("Case #" + caseNum + ": " + result.toString());
            }
        }
    }
}