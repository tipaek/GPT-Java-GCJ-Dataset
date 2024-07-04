import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedStartTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                sortedStartTimes[i] = startTimes[i];
            }
            
            Arrays.sort(sortedStartTimes);
            int[] sortedEndTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sortedStartTimes[i] == startTimes[j]) {
                        sortedEndTimes[i] = endTimes[j];
                        break;
                    }
                }
            }
            
            int[] timeSlots = new int[1441];
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean isPossible = true;
            
            for (int i = 0; i < n && isPossible; i++) {
                for (int j = startTimes[i]; j < endTimes[i] && isPossible; j++) {
                    timeSlots[j]++;
                    if (timeSlots[j] > 2) {
                        isPossible = false;
                    }
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                Arrays.fill(sortedAssignments, 'J');
                for (int i = 1; i < n; i++) {
                    boolean assigned = false;
                    for (int j = 0; j < i; j++) {
                        if (sortedStartTimes[i] >= sortedEndTimes[j]) {
                            sortedAssignments[i] = sortedAssignments[j];
                            assigned = true;
                            break;
                        }
                    }
                    if (!assigned) {
                        sortedAssignments[i] = sortedAssignments[i - 1] == 'J' ? 'C' : 'J';
                    }
                }
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[i] == startTimes[j]) {
                            assignments[j] = sortedAssignments[i];
                            break;
                        }
                    }
                }
                
                System.out.print("Case #" + caseNum + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}