import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] schedule = new int[100000];
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            boolean isImpossible = false;

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();

                for (int time = startTimes[i]; time < endTimes[i]; time++) {
                    schedule[time]++;
                    if (schedule[time] > 2) {
                        isImpossible = true;
                    }
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                int[] assignments = new int[n];
                assignments[0] = 0;

                for (int i = 1; i < n; i++) {
                    for (int j = i - 1; j >= 0; j--) {
                        if ((startTimes[i] >= startTimes[j] && startTimes[i] < endTimes[j]) ||
                            (endTimes[i] > startTimes[j] && endTimes[i] <= endTimes[j])) {
                            assignments[i] = 1 - assignments[j];
                            break;
                        }
                    }
                }

                System.out.print("Case #" + testCase + ": ");
                for (int i = 0; i < n; i++) {
                    System.out.print(assignments[i] == 1 ? "J" : "C");
                }
                System.out.println();
            }
        }
    }
}