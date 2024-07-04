import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedStartTimes = new int[n];
            
            for (int j = 0; j < n; j++) {
                startTimes[j] = in.nextInt();
                endTimes[j] = in.nextInt();
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
            boolean possible = true;

            sortedAssignments[0] = 'J';
            for (int j = 0; j < n; j++) {
                if (sortedAssignments[j] != 'C' && sortedAssignments[j] != 'J') {
                    sortedAssignments[j] = (sortedAssignments[j - 1] == 'C') ? 'J' : 'C';
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

            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            for (int j = 0; j < n; j++) {
                if (sortedAssignments[j] == 'C') {
                    for (int k = sortedStartTimes[j]; k <= sortedEndTimes[j]; k++) {
                        cameron[k]++;
                    }
                } else {
                    for (int k = sortedStartTimes[j]; k <= sortedEndTimes[j]; k++) {
                        jamie[k]++;
                    }
                }
            }

            int jamieCounter = 0;
            int cameronCounter = 0;

            for (int j = 0; j < 1441 && possible; j++) {
                if ((cameron[j] == 2 && cameronCounter == 1) || (jamie[j] == 2 && jamieCounter == 1)) {
                    possible = false;
                } else if (cameron[j] == 1 && cameronCounter == 1) {
                    cameronCounter = 0;
                } else if (cameron[j] == 2) {
                    cameronCounter = 1;
                } else if (jamie[j] == 1 && jamieCounter == 1) {
                    jamieCounter = 0;
                } else if (jamie[j] == 2) {
                    jamieCounter = 1;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                boolean[] filled = new boolean[n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (sortedStartTimes[j] == startTimes[k] && !filled[k]) {
                            assignments[k] = sortedAssignments[j];
                            filled[k] = true;
                            break;
                        }
                    }
                }

                System.out.print("Case #" + (i + 1) + ": ");
                for (int j = 0; j < n; j++) {
                    System.out.print(assignments[j]);
                }
                System.out.println();
            }
        }
        in.close();
    }
}