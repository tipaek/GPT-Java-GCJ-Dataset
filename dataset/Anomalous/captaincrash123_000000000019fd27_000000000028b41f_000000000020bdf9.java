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
            int[] sortedEndTimes = new int[n];
            char[] assignments = new char[n];
            char[] sortedAssignments = new char[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                sortedStartTimes[i] = startTimes[i];
            }

            Arrays.sort(sortedStartTimes);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sortedStartTimes[i] == startTimes[j]) {
                        sortedEndTimes[i] = endTimes[j];
                    }
                }
            }

            boolean isPossible = true;
            sortedAssignments[0] = 'J';

            for (int i = 0; i < n; i++) {
                if (sortedAssignments[i] != 'C' && sortedAssignments[i] != 'J') {
                    sortedAssignments[i] = 'J';
                }
                for (int j = i + 1; j < n; j++) {
                    if (sortedStartTimes[j] >= sortedEndTimes[i]) {
                        sortedAssignments[j] = sortedAssignments[j] == 'J' ? 'C' : 'J';
                    } else if (sortedStartTimes[j] < sortedEndTimes[i]) {
                        sortedAssignments[j] = sortedAssignments[i] == 'J' ? 'C' : 'J';
                    }
                }
            }

            int[] cameron = new int[1441];
            int[] jamie = new int[1441];

            for (int i = 0; i < n; i++) {
                if (sortedAssignments[i] == 'C') {
                    for (int j = sortedStartTimes[i]; j < sortedEndTimes[i]; j++) {
                        cameron[j]++;
                    }
                } else {
                    for (int j = sortedStartTimes[i]; j < sortedEndTimes[i]; j++) {
                        jamie[j]++;
                    }
                }
            }

            for (int i = 0; i < 1441; i++) {
                if (cameron[i] > 1 || jamie[i] > 1) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (startTimes[i] == sortedStartTimes[j]) {
                            assignments[i] = sortedAssignments[j];
                        }
                    }
                }
                System.out.print("Case #" + testCase + ": ");
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}