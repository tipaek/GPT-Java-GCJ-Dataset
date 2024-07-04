import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> arrC = new ArrayList<>();
        List<Integer> arrJ = new ArrayList<>();
        
        for (int i = 0; i < t; i++) {
            arrC.clear();
            arrJ.clear();
            boolean isPossible = true;
            StringBuilder ans = new StringBuilder("Case #" + (i + 1) + ": ");
            
            int n = Integer.parseInt(br.readLine());
            String[] schedule = new String[n];
            
            for (int j = 0; j < n; j++) {
                schedule[j] = br.readLine();
            }
            
            for (int j = 0; j < n; j++) {
                String[] times = schedule[j].split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                
                boolean assigned = false;
                
                if (canAssign(arrJ, start, end)) {
                    arrJ.add(start);
                    arrJ.add(end);
                    ans.append('J');
                    assigned = true;
                } else if (canAssign(arrC, start, end)) {
                    arrC.add(start);
                    arrC.add(end);
                    ans.append('C');
                    assigned = true;
                }
                
                if (!assigned) {
                    ans = new StringBuilder("Case #" + (i + 1) + ": IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }
            
            System.out.println(ans.toString());
        }
    }
    
    private static boolean canAssign(List<Integer> arr, int start, int end) {
        for (int k = 0; k < arr.size(); k += 2) {
            if (start >= arr.get(k + 1) || end <= arr.get(k)) {
                continue;
            }
            return false;
        }
        return true;
    }
}