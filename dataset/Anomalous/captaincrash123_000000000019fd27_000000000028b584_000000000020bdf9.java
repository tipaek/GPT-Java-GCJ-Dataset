import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int activityCount = scanner.nextInt();
            int[] startTimes = new int[activityCount];
            int[] endTimes = new int[activityCount];
            int[] sortedStartTimes = new int[activityCount];

            for (int i = 0; i < activityCount; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                sortedStartTimes[i] = startTimes[i];
            }
            
            Arrays.sort(sortedStartTimes);
            int[] sortedEndTimes = new int[activityCount];

            for (int i = 0; i < activityCount; i++) {
                for (int j = 0; j < activityCount; j++) {
                    if (sortedStartTimes[i] == startTimes[j]) {
                        sortedEndTimes[i] = endTimes[j];
                    }
                }
            }

            char[] assignments = new char[activityCount];
            char[] sortedAssignments = new char[activityCount];
            boolean isPossible = true;

            sortedAssignments[0] = 'J';
            for (int i = 0; i < activityCount; i++) {
                if (sortedAssignments[i] != 'C' && sortedAssignments[i] != 'J') {
                    sortedAssignments[i] = 'J';
                }
                for (int j = i + 1; j < activityCount; j++) {
                    if (sortedStartTimes[j] > sortedStartTimes[i] && sortedEndTimes[j] < sortedEndTimes[i]) {
                        sortedAssignments[j] = (sortedAssignments[i] == 'J') ? 'C' : 'J';
                    } else if (sortedStartTimes[j] > sortedStartTimes[i] && sortedStartTimes[j] < sortedEndTimes[i]) {
                        sortedAssignments[j] = (sortedAssignments[i] == 'J') ? 'C' : 'J';
                    } else if (sortedStartTimes[i] == sortedStartTimes[j]) {
                        sortedAssignments[j] = (sortedAssignments[i] == 'J') ? 'C' : 'J';
                    }
                }
            }

            int[] cameronSchedule = new int[1441];
            int[] jamieSchedule = new int[1441];

            for (int i = 0; i < activityCount; i++) {
                int[] schedule = (sortedAssignments[i] == 'C') ? cameronSchedule : jamieSchedule;
                for (int j = sortedStartTimes[i]; j <= sortedEndTimes[i]; j++) {
                    schedule[j]++;
                }
            }

            int cameronOverlap = 0;
            int jamieOverlap = 0;

            for (int i = 0; i < 1441 && isPossible; i++) {
                if (cameronSchedule[i] == 2) {
                    if (cameronOverlap == 1) {
                        isPossible = false;
                    } else {
                        cameronOverlap = 1;
                    }
                } else if (cameronSchedule[i] == 1) {
                    cameronOverlap = 0;
                }

                if (jamieSchedule[i] == 2) {
                    if (jamieOverlap == 1) {
                        isPossible = false;
                    } else {
                        jamieOverlap = 1;
                    }
                } else if (jamieSchedule[i] == 1) {
                    jamieOverlap = 0;
                }
            }
            
            if (!isPossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseIndex + 1);
            } else {
                for (int i = 0; i < activityCount; i++) {
                    for (int j = 0; j < activityCount; j++) {
                        if (sortedStartTimes[i] == startTimes[j]) {
                            assignments[j] = sortedAssignments[i];
                        }
                    }
                }

                System.out.printf("Case #%d: ", caseIndex + 1);
                for (char assignment : assignments) {
                    System.out.print(assignment);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}