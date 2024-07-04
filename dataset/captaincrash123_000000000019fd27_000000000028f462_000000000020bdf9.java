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

            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean possible = true;

            sortedAssignments[0] = 'J';
            for (int j = 0; j < n; j++) {
                if (sortedAssignments[j] != 'C' && sortedAssignments[j] != 'J') {
                    if (sortedAssignments[j - 1] == 'C') {
                        sortedAssignments[j] = 'J';
                    } else {
                        sortedAssignments[j] = 'C';
                    }
                }
                for (int k = j + 1; k < n; k++) {
                    if (sortedStartingTimes[k] >= sortedStartingTimes[j] && sortedEndingTimes[k] <= sortedEndingTimes[j]) {
                        if (sortedAssignments[j] == 'J') {
                            sortedAssignments[k] = 'C';
                        } else {
                            sortedAssignments[k] = 'J';
                        }
                    } else if (sortedStartingTimes[k] > sortedStartingTimes[j] && sortedStartingTimes[k] < sortedEndingTimes[j]) {
                        if (sortedAssignments[j] == 'J') {
                            sortedAssignments[k] = 'C';
                        } else if (sortedAssignments[j] == 'C') {
                            sortedAssignments[k] = 'J';
                        }
                    } else if (sortedStartingTimes[j] == sortedStartingTimes[k]) {
                        if (sortedAssignments[j] == 'J') {
                            sortedAssignments[k] = 'C';
                        } else if (sortedAssignments[j] == 'C') {
                            sortedAssignments[k] = 'J';
                        }
                    }
                }
            }

            int[] cameron = new int[1441];
            int[] jamie = new int[1441];
            int jamieCounter = 0;
            int cameronCounter = 0;
            for (int j = 0; j < n; j++) {
                if (sortedAssignments[j] == 'C') {
                    for (int k = sortedStartingTimes[j]; k <= sortedEndingTimes[j]; k++) {
                        cameron[k] = cameron[k] + 1;
                        if (cameron[k] == 2 && cameronCounter == 1 && k != startingTimes[j] && k != endingTimes[j]) {
                            possible = false;
                        } else if (cameron[k] == 1 && cameronCounter == 1) {
                            cameronCounter = 0;
                        } else if (cameron[k] == 2) {
                            cameronCounter = 1;
                        }
                    }
                } else {
                    for (int k = sortedStartingTimes[j]; k <= sortedEndingTimes[j]; k++) {
                        jamie[k] = jamie[k] + 1;
                        if (jamie[k] == 2 && jamieCounter == 1 && k != startingTimes[j] && k != endingTimes[j]) {
                            possible = false;
                        } else if (jamie[k] == 1 && jamieCounter == 1) {
                            jamieCounter = 0;
                        } else if (jamie[k] == 2) {
                            jamieCounter = 1;
                        }
                    }
                }
            }
            
            if (!possible) {
                System.out.print("Case #");
                System.out.print(i + 1);
                System.out.println(": IMPOSSIBLE");
            } else {
                boolean[] filled = new boolean[n];
                for (int j = 0; j < n; j++) {
                    boolean done = false;
                    for (int k = 0; k < n && !done; k++) {
                        if (sortedStartingTimes[j] == startingTimes[k] && !filled[k]) {
                            assignments[k] = sortedAssignments[j];
                            filled[k] = true;
                            done = true;
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