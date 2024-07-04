import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        
        for (int t = 1; t <= cases; ++t) {
            int n = in.nextInt();
            int[][] activities = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = in.nextInt(); // start time
                activities[i][1] = in.nextInt(); // end time
                activities[i][2] = i; // original index
            }
            
            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
            
            boolean isPossible = true;
            char[] result = new char[n];
            int cameronEnd = 0, jamieEnd = 0;
            
            for (int i = 0; i < n; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                int index = activities[i][2];
                
                if (start >= cameronEnd) {
                    result[index] = 'C';
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    result[index] = 'J';
                    jamieEnd = end;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}