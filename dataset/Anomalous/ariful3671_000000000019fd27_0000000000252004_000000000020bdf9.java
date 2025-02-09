import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNo = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }

            int[] sortedStartTimes = Arrays.copyOf(startTimes, n);
            int[] sortedEndTimes = Arrays.copyOf(endTimes, n);

            // Sorting the intervals based on start times
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (sortedStartTimes[i] > sortedStartTimes[j]) {
                        int tempStart = sortedStartTimes[i];
                        sortedStartTimes[i] = sortedStartTimes[j];
                        sortedStartTimes[j] = tempStart;

                        int tempEnd = sortedEndTimes[i];
                        sortedEndTimes[i] = sortedEndTimes[j];
                        sortedEndTimes[j] = tempEnd;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            int[] endTimeTracker = new int[2];

            if (sortedEndTimes[0] > sortedStartTimes[1]) {
                result.append("CJ");
                endTimeTracker[0] = sortedEndTimes[0];
                endTimeTracker[1] = sortedEndTimes[1];
            } else {
                result.append("CC");
                endTimeTracker[0] = sortedEndTimes[1];
            }

            for (int i = 2; i < n; i++) {
                if (sortedStartTimes[i] >= endTimeTracker[0]) {
                    endTimeTracker[0] = sortedEndTimes[i];
                    result.append("C");
                } else if (sortedStartTimes[i] >= endTimeTracker[1]) {
                    endTimeTracker[1] = sortedEndTimes[i];
                    result.append("J");
                } else {
                    result.setLength(0);
                    result.append("IMPOSSIBLE");
                    break;
                }
            }

            if (!result.toString().equals("IMPOSSIBLE")) {
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (startTimes[i] == sortedStartTimes[j]) {
                            output.append(result.charAt(j));
                        }
                    }
                }
                System.out.println("Case #" + caseNo + ": " + output);
            } else {
                System.out.println("Case #" + caseNo + ": " + result);
            }
            caseNo++;
        }
    }
}