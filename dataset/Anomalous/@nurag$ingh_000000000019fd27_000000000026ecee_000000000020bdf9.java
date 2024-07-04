import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int rr = 0; rr < t; rr++) {
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
            assignments[0] = 10; // 10 represents 'C'
            int k = 1;
            boolean isImpossible = false;
            
            int[] timeOverlapCheck = new int[1441];
            for (int i = 0; i < n; i++) {
                for (int j = startTimes[i]; j <= endTimes[i]; j++) {
                    timeOverlapCheck[j]++;
                }
            }
            
            for (int j = 0; j < 1440; j++) {
                if (timeOverlapCheck[j] > 2) {
                    isImpossible = true;
                    break;
                }
            }
            
            if (!isImpossible) {
                for (int i = 1; i < n; i++) {
                    List<Integer> availableAssignments = new ArrayList<>(Arrays.asList(10, 11)); // 10 represents 'C' and 11 represents 'J'
                    
                    for (int j = 0; j < k; j++) {
                        boolean isOverlap = (startTimes[i] < assignedEndTimes[j] && startTimes[i] >= assignedStartTimes[j]) ||
                                            (endTimes[i] <= assignedEndTimes[j] && endTimes[i] > assignedStartTimes[j]) ||
                                            (startTimes[i] >= assignedStartTimes[j] && endTimes[i] <= assignedEndTimes[j]) ||
                                            (startTimes[i] <= assignedStartTimes[j] && endTimes[i] >= assignedEndTimes[j]);
                        
                        if (isOverlap) {
                            int currentAssignment = assignments[j];
                            if (!availableAssignments.contains(currentAssignment)) {
                                isImpossible = true;
                                break;
                            } else {
                                availableAssignments.remove(Integer.valueOf(currentAssignment));
                            }
                        }
                    }
                    
                    if (isImpossible || availableAssignments.isEmpty()) {
                        isImpossible = true;
                        break;
                    }
                    
                    assignedStartTimes[k] = startTimes[i];
                    assignedEndTimes[k] = endTimes[i];
                    assignments[k] = availableAssignments.get(0);
                    k++;
                }
            }
            
            if (isImpossible) {
                System.out.println("Case #" + (rr + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (rr + 1) + ": ");
                for (int i = 0; i < k; i++) {
                    System.out.print(assignments[i] == 10 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }
}