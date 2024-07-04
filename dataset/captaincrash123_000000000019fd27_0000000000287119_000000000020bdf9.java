import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] startingTimes = new int[n];
            int[] endingTimes = new int[n];
            int[] sortedStartingTimes = new int[n];
            for (int j = 0; j < n; j++) {
                startingTimes[j] = in.nextInt();
                endingTimes[j] = in.nextInt();
                sortedStartingTimes[j] = startingTimes[j];
            }
            
            Arrays.sort(sortedStartingTimes);
            int[] sortedEndingTimes = new int[n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (sortedStartingTimes[j] == startingTimes[k]) {
                        sortedEndingTimes[j] = endingTimes[k];
                    }
                }
            }

            int[] time = new int[1441];
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean possible = true;
            int threeCounter = 0;
            for (int j = 0; j < n && possible; j++) {
                for (int k = startingTimes[j]; k <= endingTimes[j] && possible; k++) {
                    time[k] = time[k] + 1;
                    if (time[k] == 3 && threeCounter == 1) {
                        possible = false;
                    } else if (time[k] == 3) {
                        threeCounter = 1;
                    } else if (threeCounter == 1) {
                        threeCounter = 0;
                    }
                }
            }

            if (!possible) {
                System.out.print("Case #");
                System.out.print(i + 1);
                System.out.println(": IMPOSSIBLE");
            } else {
                sortedAssignments[0] = 'J';

                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < j; k++) {
                        if (sortedStartingTimes[j] > sortedStartingTimes[k] && sortedEndingTimes[j] < sortedEndingTimes[k]) {
                            if (sortedAssignments[k] == 'J') {
                                sortedAssignments[j] = 'C';
                            } else {
                                sortedAssignments[j] = 'J';
                            }
                        } else if (sortedStartingTimes[j] > sortedStartingTimes[k] && sortedStartingTimes[j] < sortedEndingTimes[k]) {
                            if (sortedAssignments[k] == 'J') {
                                sortedAssignments[j] = 'C';
                            } else {
                                sortedAssignments[j] = 'J';
                            }
                        } else if (sortedStartingTimes[j] == sortedStartingTimes[k]) {
                            if (sortedAssignments[k] == 'J') {
                                sortedAssignments[j] = 'C';
                            } else {
                                sortedAssignments[j] = 'J';
                            }
                        }
                    }
                    if (sortedAssignments[j] != 'C' && sortedAssignments[j] != 'J') {
                        assignments[j] = 'J';
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (sortedStartingTimes[j] == startingTimes[k]) {
                            assignments[k] = sortedAssignments[j];
                        }
                    }
                }

                System.out.print("Case #");
                System.out.print(i + 1);
                System.out.print(": ");
                for (int j = 0; j < n; j++) {
                    if (j == n - 1) {
                        System.out.println(assignments[j]);
                    } else {
                        System.out.print(assignments[j]);
                    }
                }
            }

            
            

        }
        in.close();
        
    }
}