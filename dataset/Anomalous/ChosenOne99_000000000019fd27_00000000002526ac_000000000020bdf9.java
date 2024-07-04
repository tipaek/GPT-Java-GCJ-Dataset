import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            Map<Integer, Integer> jSchedule = new HashMap<>();
            Map<Integer, Integer> cSchedule = new HashMap<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean assigned = false;
                
                for (Map.Entry<Integer, Integer> entry : jSchedule.entrySet()) {
                    int jStart = entry.getKey();
                    int jEnd = entry.getValue();
                    if ((start < jStart && jStart < end) || (start == jStart) || (start > jStart && start < jEnd)) {
                        assigned = true;
                        break;
                    }
                }
                
                if (!assigned) {
                    jSchedule.put(start, end);
                    result.append("J");
                } else {
                    for (Map.Entry<Integer, Integer> entry : cSchedule.entrySet()) {
                        int cStart = entry.getKey();
                        int cEnd = entry.getValue();
                        if ((start < cStart && cStart < end) || (start == cStart) || (start > cStart && start < cEnd)) {
                            isImpossible = true;
                            break;
                        }
                    }
                    
                    if (!isImpossible) {
                        cSchedule.put(start, end);
                        result.append("C");
                    }
                }
                
                if (isImpossible) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}