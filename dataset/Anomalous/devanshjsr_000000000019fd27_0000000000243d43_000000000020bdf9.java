import java.util.*;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedStartTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                sortedStartTimes[i] = startTimes[i];
                originalStartTimes[i] = startTimes[i];
                endTimes[i] = scanner.nextInt();
                sortedEndTimes[i] = endTimes[i];
                originalEndTimes[i] = endTimes[i];
            }

            Arrays.sort(sortedStartTimes);

            char[] assignments = new char[n];
            int cEnd = 0, jEnd = 0, minDiff = Integer.MAX_VALUE, minIndex = 0;

            for (int i = 0; i < n; i++) {
                minDiff = Integer.MAX_VALUE;
                minIndex = 0;
                for (int j = 0; j < n; j++) {
                    if (originalStartTimes[j] == sortedStartTimes[i]) {
                        int duration = originalEndTimes[j] - originalStartTimes[j];
                        if (duration < minDiff) {
                            minDiff = duration;
                            minIndex = j;
                        }
                    }
                }

                sortedEndTimes[i] = originalEndTimes[minIndex];
                originalStartTimes[minIndex] = -1;
            }

            assignments[0] = 'C';
            cEnd = sortedEndTimes[0];
            boolean isPossible = true;

            for (int i = 1; i < n; i++) {
                if (sortedStartTimes[i] >= cEnd) {
                    assignments[i] = 'C';
                    cEnd = sortedEndTimes[i];
                } else if (sortedStartTimes[i] >= jEnd) {
                    assignments[i] = 'J';
                    jEnd = sortedEndTimes[i];
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (!isPossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[j] == startTimes[i] && sortedEndTimes[j] == endTimes[i]) {
                            System.out.print(assignments[j]);
                            sortedStartTimes[j] = -1;
                            sortedEndTimes[j] = -1;
                        }
                    }
                }
            }

            System.out.println();
            caseNumber++;
        }
    }
}