import java.util.*;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            int[] sortedStartTimes = new int[n];
            int[] sortedEndTimes = new int[n];
            int[] originalStartTimes = new int[n];
            int[] originalEndTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                sortedStartTimes[i] = startTimes[i];
                originalStartTimes[i] = startTimes[i];
                endTimes[i] = sc.nextInt();
                sortedEndTimes[i] = endTimes[i];
                originalEndTimes[i] = endTimes[i];
            }

            Arrays.sort(sortedStartTimes);

            char[] assignments = new char[n];
            int cameronEnd = 0, jamieEnd = 0, minDuration, minIndex;

            for (int i = 0; i < n; i++) {
                minDuration = Integer.MAX_VALUE;
                minIndex = -1;

                for (int j = 0; j < n; j++) {
                    if (originalStartTimes[j] == sortedStartTimes[i]) {
                        int duration = originalEndTimes[j] - originalStartTimes[j];
                        if (duration < minDuration) {
                            minDuration = duration;
                            minIndex = j;
                        }
                    }
                }
                
                sortedEndTimes[i] = originalEndTimes[minIndex];
                originalStartTimes[minIndex] = -1;
            }

            assignments[0] = 'C';
            cameronEnd = sortedEndTimes[0];
            boolean isPossible = true;

            for (int i = 1; i < n; i++) {
                if (sortedStartTimes[i] >= cameronEnd) {
                    assignments[i] = 'C';
                    cameronEnd = sortedEndTimes[i];
                } else if (sortedStartTimes[i] >= jamieEnd) {
                    assignments[i] = 'J';
                    jamieEnd = sortedEndTimes[i];
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[j] == startTimes[i] && sortedEndTimes[j] == endTimes[i]) {
                            System.out.print(assignments[j]);
                            sortedStartTimes[j] = -1;
                            sortedEndTimes[j] = -1;
                            break;
                        }
                    }
                }
                System.out.println();
            }
            caseNumber++;
        }
    }
}