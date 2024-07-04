import java.util.*;
import java.io.*;

public class Solution {
    
    private static String solve(int[][] activities) {
        // Idea: greedily assign activities from the earliest to the latest
        //       to whichever parent is available. If no parent is available
        //       return IMPOSSIBLE.
        int n = activities.length;
        Arrays.sort(activities, (a,b)->{
            int diff = a[0]-b[0];
            if(diff == 0) {
                return a[1]-b[1];
            }
            return diff;
        });
        int cUnavailUntil = 0;
        int jUnavailUntil = 0;
        char[] out = new char[n];
        for(int[] activ : activities) {
            if(activ[0] >= cUnavailUntil) {
                out[activ[2]] = 'C';
                cUnavailUntil = activ[1];
            } else if(activ[0] >= jUnavailUntil) {
                out[activ[2]] = 'J';
                jUnavailUntil = activ[1];
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(out);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] activities = new int[n][3];
            for(int j = 0; j < n; j++) {
                activities[j][0] = in.nextInt();
                activities[j][1] = in.nextInt();
                activities[j][2] = j;
            }
            String solution = solve(activities);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
  
}
