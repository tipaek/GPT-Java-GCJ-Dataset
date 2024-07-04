import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Map<Integer, Integer> cameron = new HashMap<>();
            Map<Integer, Integer> jamie = new HashMap<>();
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                
                if (i == 0) {
                    cameron.put(start, end);
                    result.append("C");
                } else {
                    boolean canAssignToCameron = checkAvailability(cameron, start, end);
                    if (canAssignToCameron) {
                        result.append("C");
                        cameron.put(start, end);
                    } else {
                        boolean canAssignToJamie = checkAvailability(jamie, start, end);
                        if (canAssignToJamie) {
                            result.append("J");
                            jamie.put(start, end);
                        } else {
                            isImpossible = true;
                        }
                    }
                }
            }
            
            if (isImpossible) {
                output.append("Case #").append(testCase).append(": IMPOSSIBLE\n");
            } else {
                output.append("Case #").append(testCase).append(": ").append(result.toString()).append("\n");
            }
        }
        
        System.out.println(output.toString());
    }
    
    private static boolean checkAvailability(Map<Integer, Integer> schedule, int start, int end) {
        for (Map.Entry<Integer, Integer> entry : schedule.entrySet()) {
            int existingStart = entry.getKey();
            int existingEnd = entry.getValue();
            if ((start < existingEnd && end > existingStart)) {
                return false;
            }
        }
        return true;
    }
}