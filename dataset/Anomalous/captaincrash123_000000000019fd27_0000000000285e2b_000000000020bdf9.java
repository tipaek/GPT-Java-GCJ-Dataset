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

            int[] time = new int[1441];
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean possible = true;
            int overlapCounter = 0;

            for (int j = 0; j < n && possible; j++) {
                for (int k = startTimes[j]; k <= endTimes[j] && possible; k++) {
                    time[k]++;
                    if (time[k] == 3) {
                        if (overlapCounter == 1) {
                            possible = false;
                        } else {
                            overlapCounter = 1;
                        }
                    } else if (overlapCounter == 1) {
                        overlapCounter = 0;
                    }
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", i + 1);
            } else {
                sortedAssignments[0] = 'J';
                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < j; k++) {
                        if (sortedStartTimes[j] > sortedStartTimes[k] && sortedEndTimes[j] < sortedEndTimes[k]) {
                            sortedAssignments[j] = sortedAssignments[k] == 'J' ? 'C' : 'J';
                        } else if (sortedStartTimes[j] > sortedStartTimes[k] && sortedStartTimes[j] < sortedEndTimes[k]) {
                            sortedAssignments[j] = sortedAssignments[k] == 'J' ? 'C' : 'J';
                        } else if (sortedStartTimes[j] == sortedStartTimes[k]) {
                            sortedAssignments[j] = sortedAssignments[k] == 'J' ? 'C' : 'J';
                        } else if (k == j - 1 && sortedStartTimes[j] > sortedEndTimes[k]) {
                            sortedAssignments[j] = 'J';
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (sortedStartTimes[j] == startTimes[k]) {
                            assignments[k] = sortedAssignments[j];
                            if (sortedAssignments[j] != 'C' && sortedAssignments[j] != 'J') {
                                assignments[k] = 'J';
                            }
                        }
                    }
                }

                System.out.printf("Case #%d: ", i + 1);
                for (int j = 0; j < n; j++) {
                    System.out.print(assignments[j]);
                }
                System.out.println();
            }
        }
        in.close();
    }
}