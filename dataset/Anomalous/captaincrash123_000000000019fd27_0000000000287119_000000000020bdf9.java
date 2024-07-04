import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
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
                    }
                }
            }
            
            int[] timeSlots = new int[1441];
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean isPossible = true;
            int overlapCount = 0;
            
            for (int i = 0; i < n && isPossible; i++) {
                for (int j = startTimes[i]; j <= endTimes[i] && isPossible; j++) {
                    timeSlots[j]++;
                    if (timeSlots[j] == 3) {
                        if (overlapCount == 1) {
                            isPossible = false;
                        } else {
                            overlapCount = 1;
                        }
                    } else if (overlapCount == 1) {
                        overlapCount = 0;
                    }
                }
            }
            
            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t + 1);
            } else {
                sortedAssignments[0] = 'J';
                
                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < i; j++) {
                        if ((sortedStartTimes[i] > sortedStartTimes[j] && sortedEndTimes[i] < sortedEndTimes[j]) ||
                            (sortedStartTimes[i] > sortedStartTimes[j] && sortedStartTimes[i] < sortedEndTimes[j]) ||
                            (sortedStartTimes[i] == sortedStartTimes[j])) {
                            
                            if (sortedAssignments[j] == 'J') {
                                sortedAssignments[i] = 'C';
                            } else {
                                sortedAssignments[i] = 'J';
                            }
                        }
                    }
                    if (sortedAssignments[i] != 'C' && sortedAssignments[i] != 'J') {
                        sortedAssignments[i] = 'J';
                    }
                }
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[i] == startTimes[j]) {
                            assignments[j] = sortedAssignments[i];
                        }
                    }
                }
                
                System.out.printf("Case #%d: ", t + 1);
                for (int i = 0; i < n; i++) {
                    System.out.print(assignments[i]);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}