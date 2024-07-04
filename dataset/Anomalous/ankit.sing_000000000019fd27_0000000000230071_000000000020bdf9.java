import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        
        for (int i = 1; i <= tests; i++) {
            int schedules = in.nextInt();
            TreeMap<Integer, Integer> scheduleMap = new TreeMap<>();
            
            for (int j = 0; j < schedules; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                scheduleMap.put(start, end);
            }
            
            int[] endTimes = new int[2];
            StringBuilder output = new StringBuilder("JC");
            boolean possible = true;
            
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : scheduleMap.entrySet()) {
                int start = entry.getKey();
                int end = entry.getValue();
                
                if (count == 0) {
                    endTimes[0] = end;
                } else if (count == 1) {
                    endTimes[1] = end;
                } else {
                    if (start >= endTimes[0]) {
                        output.append("J");
                        endTimes[0] = end;
                    } else if (start >= endTimes[1]) {
                        output.append("C");
                        endTimes[1] = end;
                    } else {
                        output = new StringBuilder("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
                count++;
            }
            
            System.out.println("Case #" + i + ": " + output);
        }
        
        in.close();
    }
}