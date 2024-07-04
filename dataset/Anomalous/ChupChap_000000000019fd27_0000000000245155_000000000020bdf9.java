import java.util.*;
import java.io.*;

public class Solution {
    
    public static String sequence(int[][] intervals, int N) {
        int[] assignments = new int[N];
        assignments[0] = 1;
        
        for (int i = 1; i < N; i++) {
            int flag = 1;
            for (int j = 0; j < i; j++) {
                if ((intervals[i][0] > intervals[j][0] && intervals[i][0] < intervals[j][1]) || 
                    (intervals[i][1] > intervals[j][0] && intervals[i][1] < intervals[j][1]) ||
                    (intervals[i][0] < intervals[j][0] && intervals[i][1] > intervals[j][1])) {
                    flag--;
                }
            }
            if (flag == 1) {
                assignments[i] = 0;
            } else if (flag == 0) {
                assignments[i] = 1;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder seq = new StringBuilder("C");
        for (int k = 1; k < N; k++) {
            seq.append(assignments[k] == 1 ? "C" : "J");
        }
        return seq.toString();
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        
        for (int i = 1; i <= T; ++i) {
            int N = in.nextInt();
            int[][] intervals = new int[N][2];
            
            for (int j = 0; j < N; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }
            
            String seq = sequence(intervals, N);
            System.out.println("Case #" + i + ": " + seq);
        }
        
        in.close();
    }
}