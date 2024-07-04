import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[1441];
            int[] originalStartTimes = new int[n];

            for (int j = 0; j < n; j++) {
                startTimes[j] = scanner.nextInt();
                endTimes[startTimes[j]] = scanner.nextInt();
            }

            System.arraycopy(startTimes, 0, originalStartTimes, 0, n);
            Arrays.sort(startTimes);

            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            char[] schedule = new char[1441];

            for (int j = 0; j < n; j++) {
                if (startTimes[j] >= cEnd) {
                    schedule[startTimes[j]] = 'C';
                    cEnd = endTimes[startTimes[j]];
                } else if (startTimes[j] >= jEnd) {
                    schedule[startTimes[j]] = 'J';
                    jEnd = endTimes[startTimes[j]];
                } else {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < n; j++) {
                result.append(schedule[originalStartTimes[j]]);
            }

            if (isPossible) {
                System.out.println("Case #" + i + ": " + result);
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }
}