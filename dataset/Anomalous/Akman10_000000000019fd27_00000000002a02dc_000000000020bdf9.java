import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Read number of test cases
        for (int ii = 1; ii <= t; ++ii) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] assignments = new int[n];
            
            // Read start and end times
            for (int i = 0; i < n; i++) {
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
            }
            
            boolean isImpossible = false;
            
            // Check for overlapping intervals
            for (int i = 1; i < n; i++) {
                boolean firstAssignment = false;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        if ((startTimes[i] >= startTimes[j] && startTimes[i] < endTimes[j]) ||
                            (endTimes[i] > startTimes[j] && endTimes[i] < endTimes[j])) {
                            if (!firstAssignment) {
                                assignments[i] = 1 - assignments[j];
                                firstAssignment = true;
                            } else {
                                if (assignments[i] == assignments[j]) {
                                    isImpossible = true;
                                }
                            }
                        }
                    }
                }
            }
            
            // Print the result for the current test case
            if (isImpossible) {
                System.out.println("Case #" + ii + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(assignments[i] == 1 ? "J" : "C");
                }
                System.out.println("Case #" + ii + ": " + result.toString());
            }
        }
    }
}