import java.util.*;

class It {
    private char[] assignments;
    private int[] startTimes, endTimes, originalIndices;
    private int numActivities;

    It(int[] startTimes, int[] endTimes, int numActivities, int[] originalIndices) {
        this.numActivities = numActivities;
        this.startTimes = startTimes;
        this.endTimes = endTimes;
        this.originalIndices = originalIndices;
        this.assignments = new char[numActivities];
    }

    public String allot() {
        int lastCameron = 0, lastJamie = 0;
        boolean isJamieAssigned = false;
        assignments[0] = 'C';

        for (int i = 1; i < numActivities; i++) {
            if (startTimes[i] >= endTimes[lastCameron]) {
                assignments[i] = 'C';
                lastCameron = i;
            }
        }

        for (int i = 0; i < numActivities; i++) {
            if (assignments[i] == 0) {
                if (!isJamieAssigned) {
                    assignments[i] = 'J';
                    lastJamie = i;
                    isJamieAssigned = true;
                } else if (startTimes[i] >= endTimes[lastJamie]) {
                    assignments[i] = 'J';
                    lastJamie = i;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        char[] finalAssignments = new char[numActivities];
        for (int i = 0; i < numActivities; i++) {
            finalAssignments[originalIndices[i]] = assignments[i];
        }

        return new String(finalAssignments);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int numActivities = scanner.nextInt();
            int[] startTimes = new int[numActivities];
            int[] endTimes = new int[numActivities];
            int[] originalIndices = new int[numActivities];

            for (int j = 0; j < numActivities; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[j] = scanner.nextInt();
                originalIndices[j] = j;
            }

            for (int j = 0; j < numActivities; j++) {
                for (int k = j + 1; k < numActivities; k++) {
                    if (endTimes[j] > endTimes[k]) {
                        int temp = endTimes[j];
                        endTimes[j] = endTimes[k];
                        endTimes[k] = temp;

                        temp = startTimes[j];
                        startTimes[j] = startTimes[k];
                        startTimes[k] = temp;

                        temp = originalIndices[j];
                        originalIndices[j] = originalIndices[k];
                        originalIndices[k] = temp;
                    }
                }
            }

            It scheduler = new It(startTimes, endTimes, numActivities, originalIndices);
            results[i] = scheduler.allot();
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }

        scanner.close();
    }
}