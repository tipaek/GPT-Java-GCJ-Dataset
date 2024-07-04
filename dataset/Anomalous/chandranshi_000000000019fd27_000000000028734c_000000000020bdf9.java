import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        if (t < 1 || t > 100) {
            System.out.println("Error");
            return;
        }
        
        for (int i = 0; i < t; i++) {
            List<int[]> intervalsC = new ArrayList<>();
            List<int[]> intervalsJ = new ArrayList<>();
            boolean possible = true;
            StringBuilder result = new StringBuilder("Case #").append(i + 1).append(": ");
            
            int n = Integer.parseInt(br.readLine());
            char[] schedule = new char[n];
            
            for (int j = 0; j < n; j++) {
                String[] parts = br.readLine().split(" ");
                int start = Integer.parseInt(parts[0]);
                int end = Integer.parseInt(parts[1]);
                
                if (start < 0 || start > 1440 || end < 0 || end > 1440) {
                    possible = false;
                    break;
                }
                
                boolean assigned = false;
                
                if (canAssign(intervalsJ, start, end)) {
                    intervalsJ.add(new int[] { start, end });
                    schedule[j] = 'J';
                    assigned = true;
                } else if (canAssign(intervalsC, start, end)) {
                    intervalsC.add(new int[] { start, end });
                    schedule[j] = 'C';
                    assigned = true;
                }
                
                if (!assigned) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                result.append(new String(schedule));
            } else {
                result.append("IMPOSSIBLE");
            }
            
            System.out.println(result);
        }
    }
    
    private static boolean canAssign(List<int[]> intervals, int start, int end) {
        for (int[] interval : intervals) {
            if (!(end <= interval[0] || start >= interval[1])) {
                return false;
            }
        }
        return true;
    }
}