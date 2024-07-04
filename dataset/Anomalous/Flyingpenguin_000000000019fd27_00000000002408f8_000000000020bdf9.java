import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = inputScanner.nextInt();
        
        for (int case_n = 1; case_n <= t; case_n++) {
            int n = inputScanner.nextInt();
            int[][] activities = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = inputScanner.nextInt();
                activities[i][1] = inputScanner.nextInt();
                activities[i][2] = i;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int jEnd = 0, cEnd = 0;
            char[] result = new char[n];
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                if (activities[i][0] >= cEnd) {
                    result[activities[i][2]] = 'C';
                    cEnd = activities[i][1];
                } else if (activities[i][0] >= jEnd) {
                    result[activities[i][2]] = 'J';
                    jEnd = activities[i][1];
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + case_n + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + case_n + ": " + new String(result));
            }
        }
    }
}