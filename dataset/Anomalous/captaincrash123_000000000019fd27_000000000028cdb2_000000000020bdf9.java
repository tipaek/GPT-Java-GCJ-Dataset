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
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                sortedStartTimes[j] = startTimes[j];
            }
            
            Arrays.sort(sortedStartTimes);
            int[] sortedEndTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (sortedStartTimes[j] == startTimes[k]) {
                        sortedEndTimes[j] = endTimes[k];
                    }
                }
            }
            
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean isPossible = true;
            
            sortedAssignments[0] = 'J';
            for (int j = 0; j < n; j++) {
                if (sortedAssignments[j] != 'C' && sortedAssignments[j] != 'J') {
                    sortedAssignments[j] = 'J';
                }
                for (int k = j + 1; k < n; k++) {
                    if (sortedStartTimes[k] >= sortedStartTimes[j] && sortedEndTimes[k] <= sortedEndTimes[j]) {
                        sortedAssignments[k] = (sortedAssignments[j] == 'J') ? 'C' : 'J';
                    } else if (sortedStartTimes[k] > sortedStartTimes[j] && sortedStartTimes[k] < sortedEndTimes[j]) {
                        sortedAssignments[k] = (sortedAssignments[j] == 'J') ? 'C' : 'J';
                    } else if (sortedStartTimes[j] == sortedStartTimes[k]) {
                        sortedAssignments[k] = (sortedAssignments[j] == 'J') ? 'C' : 'J';
                    }
                }
            }
            
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            
            for (int j = 0; j < n; j++) {
                if (sortedAssignments[j] == 'C') {
                    for (int k = sortedStartTimes[j]; k < sortedEndTimes[j]; k++) {
                        cameronSchedule[k]++;
                    }
                } else {
                    for (int k = sortedStartTimes[j]; k < sortedEndTimes[j]; k++) {
                        jamieSchedule[k]++;
                    }
                }
            }
            
            for (int j = 0; j < 1441; j++) {
                if (cameronSchedule[j] > 1 || jamieSchedule[j] > 1) {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                boolean[] filled = new boolean[n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (!filled[k] && sortedStartTimes[j] == startTimes[k]) {
                            assignments[k] = sortedAssignments[j];
                            filled[k] = true;
                            break;
                        }
                    }
                }
                
                System.out.print("Case #" + caseNum + ": ");
                for (int j = 0; j < n; j++) {
                    System.out.print(assignments[j]);
                }
                System.out.println();
            }
        }
        
        scanner.close();
    }
}