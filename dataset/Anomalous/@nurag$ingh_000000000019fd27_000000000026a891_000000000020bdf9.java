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
            
            int[] assignedStartTimes = new int[n];
            int[] assignedEndTimes = new int[n];
            int[] assignments = new int[n];
            
            assignedStartTimes[0] = startTimes[0];
            assignedEndTimes[0] = endTimes[0];
            assignments[0] = 10;
            int taskCount = 1;
            boolean isImpossible = false;
            
            for (int i = 1; i < n; i++) {
                List<Integer> availableAssignments = new ArrayList<>(Arrays.asList(10, 11));
                
                for (int j = 0; j < taskCount; j++) {
                    if (isOverlapping(startTimes[i], endTimes[i], assignedStartTimes[j], assignedEndTimes[j])) {
                        int currentAssignment = assignments[j];
                        if (availableAssignments.contains(currentAssignment)) {
                            availableAssignments.remove(Integer.valueOf(currentAssignment));
                        }
                    }
                }
                
                if (availableAssignments.isEmpty()) {
                    isImpossible = true;
                    break;
                }
                
                assignedStartTimes[taskCount] = startTimes[i];
                assignedEndTimes[taskCount] = endTimes[i];
                assignments[taskCount] = availableAssignments.get(0);
                taskCount++;
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i < taskCount; i++) {
                    System.out.print(assignments[i] == 10 ? "C" : "J");
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
    
    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && start1 >= start2) || (end1 <= end2 && end1 > start2) || 
               (start1 >= start2 && end1 <= end2) || (start1 <= start2 && end1 >= end2);
    }
}