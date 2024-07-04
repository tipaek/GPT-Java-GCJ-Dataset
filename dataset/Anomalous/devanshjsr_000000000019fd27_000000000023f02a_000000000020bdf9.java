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
            int[] correspondingEndTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = sc.nextInt();
                sortedStartTimes[i] = startTimes[i];
                endTimes[i] = sc.nextInt();
                correspondingEndTimes[i] = endTimes[i];
            }

            Arrays.sort(sortedStartTimes);

            char[] assignments = new char[n];
            int cEndTime = 0, jEndTime = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (startTimes[j] == sortedStartTimes[i]) {
                        correspondingEndTimes[i] = endTimes[j];
                    }
                }
            }

            assignments[0] = 'C';
            cEndTime = correspondingEndTimes[0];

            for (int i = 1; i < n; i++) {
                if (sortedStartTimes[i] >= cEndTime) {
                    assignments[i] = 'C';
                    cEndTime = correspondingEndTimes[i];
                } else if (sortedStartTimes[i] >= jEndTime) {
                    assignments[i] = 'J';
                    jEndTime = correspondingEndTimes[i];
                } else {
                    possible = false;
                    break;
                }
            }

            System.out.print("Case #" + caseNumber + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (sortedStartTimes[j] == startTimes[i] && correspondingEndTimes[j] == endTimes[i]) {
                            System.out.print(assignments[j]);
                        }
                    }
                }
                System.out.println();
            }

            caseNumber++;
        }
    }
}