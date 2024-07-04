import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int tn = 1; tn <= t; tn++) {
            int n = scan.nextInt();
            int[][] times = new int[n][2];
            for (int i = 0; i < n; i++) {
                times[i][0] = scan.nextInt();
                times[i][1] = scan.nextInt();
            }
            
            // Sort intervals by start time
            int[][] sortedTimes = times.clone();
            java.util.Arrays.sort(sortedTimes, (a, b) -> Integer.compare(a[0], b[0]));
            
            // Check for impossibility
            boolean possible = true;
            for (int i = 0; i < n - 1; i++) {
                if (sortedTimes[i][1] > sortedTimes[i + 1][0]) {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + tn + ": IMPOSSIBLE");
                continue;
            }
            
            // Assign activities to Cameron (C) or Jamie (J)
            StringBuilder output = new StringBuilder("C");
            int lastC = sortedTimes[0][1];
            int lastJ = 0;
            
            for (int i = 1; i < n; i++) {
                if (sortedTimes[i][0] >= lastC) {
                    output.append("C");
                    lastC = sortedTimes[i][1];
                } else {
                    output.append("J");
                    lastJ = sortedTimes[i][1];
                }
            }
            
            // Output the result
            System.out.println("Case #" + tn + ": " + output.toString());
        }
        
        scan.close();
    }
}