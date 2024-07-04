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
                        break;
                    }
                }
            }

            int[] time = new int[1441];
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];
            boolean possible = true;

            for (int j = 0; j < n && possible; j++) {
                for (int k = startingTimes[j]; k < endingTimes[j] && possible; k++) {
                    time[k]++;
                    if (time[k] > 2) {
                        possible = false;
                    }
                }
            }

            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                Arrays.fill(sortedAssignments, 'J');
                boolean[] assigned = new boolean[n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < j; k++) {
                        if (sortedStartingTimes[j] < sortedEndingTimes[k] && sortedAssignments[j] == sortedAssignments[k]) {
                            sortedAssignments[j] = (sortedAssignments[k] == 'J') ? 'C' : 'J';
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (sortedStartingTimes[j] == startingTimes[k] && !assigned[k]) {
                            assignments[k] = sortedAssignments[j];
                            assigned[k] = true;
                            break;
                        }
                    }
                }

                System.out.print("Case #" + (i + 1) + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        in.close();
    }
}