import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
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
            boolean[] isSorted = new boolean[n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sortedStartTimes[i] == startTimes[j] && !isSorted[j]) {
                        sortedEndTimes[i] = endTimes[j];
                        isSorted[j] = true;
                        break;
                    }
                }
            }
            
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean possible = true;
            
            sortedAssignments[0] = 'J';
            for (int i = 0; i < n; i++) {
                if (sortedAssignments[i] != 'C' && sortedAssignments[i] != 'J') {
                    sortedAssignments[i] = sortedAssignments[i - 1] == 'C' ? 'J' : 'C';
                }
                
                for (int j = i + 1; j < n; j++) {
                    if (sortedStartTimes[j] >= sortedStartTimes[i] && sortedEndTimes[j] <= sortedEndTimes[i]) {
                        sortedAssignments[j] = sortedAssignments[i] == 'J' ? 'C' : 'J';
                    } else if (sortedStartTimes[j] > sortedStartTimes[i] && sortedStartTimes[j] < sortedEndTimes[i]) {
                        sortedAssignments[j] = sortedAssignments[i] == 'J' ? 'C' : 'J';
                    } else if (sortedStartTimes[i] == sortedStartTimes[j]) {
                        sortedAssignments[j] = sortedAssignments[i] == 'J' ? 'C' : 'J';
                    }
                }
            }
            
            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];
            int cameronOverlap = 0;
            int jamieOverlap = 0;
            
            for (int i = 0; i < n; i++) {
                if (sortedAssignments[i] == 'C') {
                    for (int time = sortedStartTimes[i]; time <= sortedEndTimes[i]; time++) {
                        cameronSchedule[time]++;
                        if (cameronSchedule[time] == 2 && cameronOverlap == 1 && time != sortedStartTimes[Math.min(i + 1, n - 1)]) {
                            possible = false;
                        } else if (cameronSchedule[time] == 1 && cameronOverlap == 1) {
                            cameronOverlap = 0;
                        } else if (cameronSchedule[time] == 2) {
                            cameronOverlap = 1;
                        }
                    }
                } else {
                    for (int time = sortedStartTimes[i]; time <= sortedEndTimes[i]; time++) {
                        jamieSchedule[time]++;
                        if (jamieSchedule[time] == 2 && jamieOverlap == 1 && time != sortedStartTimes[Math.min(i + 1, n - 1)]) {
                            possible = false;
                        } else if (jamieSchedule[time] == 1 && jamieOverlap == 1) {
                            jamieOverlap = 0;
                        } else if (jamieSchedule[time] == 2) {
                            jamieOverlap = 1;
                        }
                    }
                }
            }
            
            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", testCase);
            } else {
                boolean[] isFilled = new boolean[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[i] == startTimes[j] && !isFilled[j]) {
                            assignments[j] = sortedAssignments[i];
                            isFilled[j] = true;
                            break;
                        }
                    }
                }
                
                System.out.printf("Case #%d: ", testCase);
                for (int i = 0; i < n; i++) {
                    System.out.print(assignments[i]);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}