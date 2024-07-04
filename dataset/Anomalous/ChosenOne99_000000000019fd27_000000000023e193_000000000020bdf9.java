import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Number of test cases
        
        for (int p = 1; p <= t; p++) {
            int number = in.nextInt();
            StringBuilder answer = new StringBuilder();
            boolean impossible = false;
            Map<Integer, Integer> jMap = new HashMap<>();
            Map<Integer, Integer> cMap = new HashMap<>();
            
            for (int i = 0; i < number; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                boolean assigned = false;
                
                if (isAvailable(jMap, start, end)) {
                    jMap.put(start, end);
                    answer.append("J");
                    assigned = true;
                } else if (isAvailable(cMap, start, end)) {
                    cMap.put(start, end);
                    answer.append("C");
                    assigned = true;
                }
                
                if (!assigned) {
                    impossible = true;
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + p + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + p + ": " + answer.toString());
            }
        }
    }

    private static boolean isAvailable(Map<Integer, Integer> map, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();
            if ((start < existingEnd && end > existingStart) || start == existingStart) {
                return false;
            }
        }
        return true;
    }
}