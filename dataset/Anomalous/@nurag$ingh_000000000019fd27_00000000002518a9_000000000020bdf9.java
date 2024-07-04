import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
            
            int[] assignedStarts = new int[n];
            int[] assignedEnds = new int[n];
            int[] assignments = new int[n];
            
            assignedStarts[0] = startTimes[0];
            assignedEnds[0] = endTimes[0];
            assignments[0] = 10;
            int count = 1;
            
            boolean isImpossible = false;
            
            for (int i = 1; i < n; i++) {
                List<Integer> availableAssignments = new ArrayList<>(Arrays.asList(10, 11));
                
                for (int j = 0; j < count; j++) {
                    if ((startTimes[i] < assignedEnds[j] && startTimes[i] > assignedStarts[j]) ||
                        (endTimes[i] < assignedEnds[j] && endTimes[i] > assignedStarts[j]) ||
                        (startTimes[i] > assignedStarts[j] && endTimes[i] < assignedEnds[j])) {
                        
                        availableAssignments.remove(new Integer(assignments[j]));
                    }
                }
                
                if (availableAssignments.isEmpty()) {
                    isImpossible = true;
                    break;
                }
                
                assignedStarts[count] = startTimes[i];
                assignedEnds[count] = endTimes[i];
                assignments[count] = availableAssignments.get(0);
                count++;
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i < count; i++) {
                    System.out.print(assignments[i] == 10 ? "C" : "J");
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}