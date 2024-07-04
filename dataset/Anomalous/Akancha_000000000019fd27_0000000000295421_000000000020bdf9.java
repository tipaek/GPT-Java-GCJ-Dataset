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
        boolean jamieAssigned = false;

        assignments[0] = 'C';
        for (int i = 1; i < numActivities; i++) {
            if (startTimes[i] >= endTimes[lastCameron]) {
                assignments[i] = 'C';
                lastCameron = i;
            }
        }

        for (int i = 0; i < numActivities; i++) {
            if (assignments[i] == 0) {
                if (!jamieAssigned) {
                    assignments[i] = 'J';
                    lastJamie = i;
                    jamieAssigned = true;
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
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] originalIndices = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = sc.nextInt();
                endTimes[j] = sc.nextInt();
                originalIndices[j] = j;
            }

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (endTimes[j] > endTimes[k]) {
                        swap(startTimes, j, k);
                        swap(endTimes, j, k);
                        swap(originalIndices, j, k);
                    }
                }
            }

            It scheduler = new It(startTimes, endTimes, n, originalIndices);
            results[i] = scheduler.allot();
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}