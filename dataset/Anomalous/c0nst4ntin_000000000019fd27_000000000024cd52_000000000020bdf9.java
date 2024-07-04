import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int _t = 1; _t <= t; _t++) {
            int n = in.nextInt();
            int[][] activities = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
                activities[i][2] = i;
            }
            
            Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));
            
            int[] jEnd = {-1};
            int[] cEnd = {-1};
            char[] result = new char[n];
            
            boolean possible = true;
            
            for (int i = 0; i < n; i++) {
                int start = activities[i][0];
                int end = activities[i][1];
                int index = activities[i][2];
                
                if (start >= jEnd[0]) {
                    jEnd[0] = end;
                    result[index] = 'J';
                } else if (start >= cEnd[0]) {
                    cEnd[0] = end;
                    result[index] = 'C';
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + _t + ": " + new String(result));
            } else {
                System.out.println("Case #" + _t + ": IMPOSSIBLE");
            }
        }
        
        in.close();
    }
}